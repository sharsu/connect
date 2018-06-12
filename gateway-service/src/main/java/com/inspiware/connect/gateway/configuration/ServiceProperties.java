package com.inspiware.connect.gateway.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(
        prefix = "service",
        ignoreUnknownFields = false
)
public class ServiceProperties {

    private final CorsConfiguration cors = new CorsConfiguration();

    private final ServiceProperties.Security security = new ServiceProperties.Security();

    public ServiceProperties() {
    }

    public ServiceProperties.Security getSecurity() {
        return this.security;
    }

    public CorsConfiguration getCors() {
        return this.cors;
    }

    public static class Security {
        private final ServiceProperties.Security.ClientAuthorization clientAuthorization = new ServiceProperties.Security.ClientAuthorization();
        private final ServiceProperties.Security.Authentication authentication = new ServiceProperties.Security.Authentication();

        public Security() {
        }

        public ServiceProperties.Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public ServiceProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public static class Authentication {
            private final ServiceProperties.Security.Authentication.Jwt jwt = new ServiceProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public ServiceProperties.Security.Authentication.Jwt getJwt() {
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
    }

}
