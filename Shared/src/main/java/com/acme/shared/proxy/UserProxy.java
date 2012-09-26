package com.acme.shared.proxy;

import com.acme.shared.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * User: jdavis
 * Date: 9/16/12
 * Time: 8:15 PM
 */


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path(UserProxy.Urls.BASE_URL)
public interface UserProxy {

    public interface Urls {
        public static final String BASE_URL = "/api/v1";
        public static final String USER = "/user/{username}";
    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    @Path(UserProxy.Urls.USER)
    public User getUserByUsername(@PathParam("username") String username);
}
