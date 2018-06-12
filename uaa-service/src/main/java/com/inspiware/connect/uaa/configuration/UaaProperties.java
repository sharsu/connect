package com.inspiware.connect.uaa.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(
        prefix = "uaa",
        ignoreUnknownFields = false
)
public class UaaProperties {
    private final UaaProperties.Security security = new UaaProperties.Security();

    private final KeyStore keyStore = new KeyStore();

    private final WebClientConfiguration webClientConfiguration = new WebClientConfiguration();

    private final CorsConfiguration cors = new CorsConfiguration();

    public UaaProperties() { }

    public UaaProperties.Security getSecurity() {
        return this.security;
    }

    public KeyStore getKeyStore() {
        return keyStore;
    }

    public WebClientConfiguration getWebClientConfiguration() {
        return webClientConfiguration;
    }

    public CorsConfiguration getCors() {
        return this.cors;
    }

    public static class Security {
        private final UaaProperties.Security.ClientAuthorization clientAuthorization = new UaaProperties.Security.ClientAuthorization();
        private final UaaProperties.Security.Authentication authentication = new UaaProperties.Security.Authentication();
        private final UaaProperties.Security.RememberMe rememberMe = new UaaProperties.Security.RememberMe();
        private final UaaProperties.Security.Ldap ldap = new UaaProperties.Security.Ldap();

        public Security() {
        }

        public UaaProperties.Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public UaaProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public UaaProperties.Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }

        public UaaProperties.Security.Ldap getLdap() {
            return ldap;
        }

        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = null;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class Authentication {
            private final UaaProperties.Security.Authentication.Jwt jwt = new UaaProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public UaaProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }

        public static class Ldap {
            private String providerUrl;
            private String userSearchBase = "ou=People";
            private String userSearchFilter = "(uid={0})";
            private String groupSearchBase = "ou=Groups";
            private String groupSearchFilter = "member={0}";
            private String base;

            public Ldap() {

            }

            public String getProviderUrl() {
                return providerUrl;
            }

            public void setProviderUrl(String providerUrl) {
                this.providerUrl = providerUrl;
            }

            public String getUserSearchBase() {
                return userSearchBase;
            }

            public void setUserSearchBase(String userSearchBase) {
                this.userSearchBase = userSearchBase;
            }

            public String getUserSearchFilter() {
                return userSearchFilter;
            }

            public void setUserSearchFilter(String userSearchFilter) {
                this.userSearchFilter = userSearchFilter;
            }

            public String getGroupSearchBase() {
                return groupSearchBase;
            }

            public void setGroupSearchBase(String groupSearchBase) {
                this.groupSearchBase = groupSearchBase;
            }

            public String getGroupSearchFilter() {
                return groupSearchFilter;
            }

            public void setGroupSearchFilter(String groupSearchFilter) {
                this.groupSearchFilter = groupSearchFilter;
            }

            public String getBase() {
                return base;
            }

            public void setBase(String base) {
                this.base = base;
            }
        }
    }

    /**
     * Keystore configuration for signing and verifying JWT tokens.
     */
    public static class KeyStore {
        //name of the keystore in the classpath
        private String name = "keystore.jks";
        //password used to access the key
        private String password = "password";
        //name of the alias to fetch
        private String alias = "selfsigned";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }

    public static class WebClientConfiguration {
        //validity of the short-lived access token in secs (min: 60), don't make it too long
        private int accessTokenValidityInSeconds = 5 * 60;
        //validity of the refresh token in secs (defines the duration of "remember me")
        private int refreshTokenValidityInSecondsForRememberMe = 7 * 24 * 60 * 60;
        private String clientId = "web_app";
        private String secret = "changeit";

        public int getAccessTokenValidityInSeconds() {
            return accessTokenValidityInSeconds;
        }

        public void setAccessTokenValidityInSeconds(int accessTokenValidityInSeconds) {
            this.accessTokenValidityInSeconds = accessTokenValidityInSeconds;
        }

        public int getRefreshTokenValidityInSecondsForRememberMe() {
            return refreshTokenValidityInSecondsForRememberMe;
        }

        public void setRefreshTokenValidityInSecondsForRememberMe(int refreshTokenValidityInSecondsForRememberMe) {
            this.refreshTokenValidityInSecondsForRememberMe = refreshTokenValidityInSecondsForRememberMe;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
