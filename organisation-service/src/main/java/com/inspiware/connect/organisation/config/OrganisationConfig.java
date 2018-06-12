package com.inspiware.connect.organisation.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class OrganisationConfig {

    @Autowired
    private JdbcProperties jdbcProperties;

    @Bean
    public DataSource dataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(jdbcProperties.getUser());
        ds.setPassword(jdbcProperties.getPassword());
        ds.setDatabaseName(jdbcProperties.getDatabase());
        ds.setServerName(jdbcProperties.getServername());
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
