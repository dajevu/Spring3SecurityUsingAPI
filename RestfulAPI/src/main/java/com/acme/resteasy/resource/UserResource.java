package com.acme.resteasy.resource;

import com.acme.shared.dto.User;
import com.acme.shared.proxy.UserProxy;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.ws.rs.PathParam;

/**
 * User: jdavis
 * Date: 9/16/12
 * Time: 8:56 PM
 */
@Controller
public class UserResource implements UserProxy {

    ShaPasswordEncoder pe = new ShaPasswordEncoder(256);

    public User getUserByUsername(@PathParam("username") String username) {
        User user = new User();

        // would normally look up this object from another service (like db), but hard-coding a response for now.
        user.setUsername("john");
        user.setPassword(pe.encodePassword("doe", null));
        user.setFullName("John Doe");
        user.setDesc("Admin user");

        return user;
    }
}
