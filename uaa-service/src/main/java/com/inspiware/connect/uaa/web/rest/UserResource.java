package com.inspiware.connect.uaa.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

//    /**
//     * @return a string list of the all of the roles
//     */
//    @GetMapping("/users/authorities")
//    @Secured(AuthoritiesConstants.ADMIN)
//    public List<String> getAuthorities() {
//        return userService.getAuthorities();
//    }
//
//    /**
//     * GET /users/:login : get the "login" user.
//     *
//     * @param login the login of the user to find
//     * @return the ResponseEntity with status 200 (OK) and with body the "login" user, or with status 404 (Not Found)
//     */
//    @GetMapping("/users/{login:" + LOGIN_REGEX + "}")
//    public ResponseEntity<UserDTO> getUser(@PathVariable String login) {
//        log.debug("REST request to get User : {}", login);
//        return ResponseUtil.wrapOrNotFound(
//            userService.getUserWithAuthoritiesByLogin(login)
//                .map(UserDTO::new));
//    }
}
