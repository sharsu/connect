package com.inspiware.connect.uaa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(UaaProperties.class)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class UaaWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UaaProperties uaaProperties;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UaaWebSecurityConfiguration(UaaProperties uaaProperties,
                                       AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.uaaProperties = uaaProperties;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase(uaaProperties.getSecurity().getLdap().getUserSearchBase()) //don't add the base
                // .userSearchFilter("(sAMAccountName={0})") // For Active directory search
                .userSearchFilter(uaaProperties.getSecurity().getLdap().getUserSearchFilter())
                .groupSearchBase(uaaProperties.getSecurity().getLdap().getGroupSearchBase()) //don't add the base
                .groupSearchFilter(uaaProperties.getSecurity().getLdap().getGroupSearchFilter())
                .contextSource(contextSource());
    }

    @PostConstruct
    public void init() throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(activeDirectoryLdapAuthenticationProvider())
                .userDetailsService(customLdapUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(uaaProperties.getSecurity().getLdap().getProviderUrl());
        contextSource.setBase(uaaProperties.getSecurity().getLdap().getBase());
        // contextSource.setUserDn("cn=admin,dc=example,dc=example,dc=com");
        // contextSource.setPassword("admin");
        contextSource.setReferral("follow");
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("", "");
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);

        return provider;
    }

    @Bean
    public LdapUserDetailsService customLdapUserDetailsService() throws Exception {
        LdapUserDetailsService userDetailsService = new LdapUserDetailsService(userSearch(), authPopulator());
        return userDetailsService;

    }

    @Bean
    public FilterBasedLdapUserSearch userSearch() throws Exception {
        FilterBasedLdapUserSearch search = new FilterBasedLdapUserSearch("", "cn={0}", contextSource());
        return search;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public DefaultLdapAuthoritiesPopulator authPopulator() throws Exception {

        DefaultLdapAuthoritiesPopulator authPop = new DefaultLdapAuthoritiesPopulator(contextSource(), "dc=groups");
        authPop.setGroupRoleAttribute("cn");
        authPop.setGroupSearchFilter("(member={0})");
        return authPop;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/index.html").permitAll();
    }
}
