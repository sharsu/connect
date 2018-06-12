# Rainmaker

## Config Service
It is a Spring Cloud Config Server, that provides runtime configuration to all applications. 

### Running locally
To run the service in IDE provide VM options:
 ```-Dspring.profiles.active=native``` 
 * A native configuration, which is used by default in development and uses the local filesystem.

## Discovery Service
Eureka is a REST based service that is primarily used for locating services for the purpose of load balancing and failover. 
 
## UAA Service
UAA application is part of connect and used for securing microservices using the OAuth2 authorization protocol.
* Central authentication server for all independent resource servers.
* Stateless solution. Users session state management is not required.
* Safe and secure
* Scalable solution

Steps the each request from the clients follows: 

1. Every request to any endpoint passes through a "Client". 
2. Clients accessing resources with user authentication, are authenticated using “password grant” with the client ID and client secret.
3. Clients accessing resources without user, are authenticated using “client credentials grant”.
4. Every client is defined inside UAA (web-app, internal, etc...).

For the user calls, a login request is sent to the gateway’s /auth/login endpoint. 
This endpoint uses OAuth2TokenEndpointClientAdapter to send a request to the UAA authenticating with the “password” grant. 
Because this request happens on the gateway, the client ID and secret are not stored in any client-side code and are inaccessible to users. 
The gateway returns a new Cookie containing the token, and this cookie is sent with each request performed from the client.
 
For the machine calls, the machine has to authenticate with UAA server using client credentials grant. 
