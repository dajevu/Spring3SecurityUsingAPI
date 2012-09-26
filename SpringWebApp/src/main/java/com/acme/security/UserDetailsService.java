package com.acme.security;

import com.acme.shared.dto.User;
import com.acme.util.APIHelper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User: jdavis
 * Date: 9/12/12
 * Time: 3:39 PM
 */

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    APIHelper apiHelper;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User apiUser = null;

        log.debug("Inside loadUserByUsername, username is :: " + username);

        UserDetails userDetails = new UserDetails();

        try {
            apiUser = apiHelper.getApiUser(username);

            userDetails.setPassword(apiUser.getPassword());

            userDetails.setUsername(username);

            userDetails.setUser(apiUser);

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not found");
        }

        return userDetails;
    }


}