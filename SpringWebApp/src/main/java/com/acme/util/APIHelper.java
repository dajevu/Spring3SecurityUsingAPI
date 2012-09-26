package com.acme.util;

import com.acme.shared.dto.User;
import com.acme.shared.proxy.UserProxy;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

/**
 * User: jdavis
 * Date: 9/17/12
 * Time: 10:10 AM
 */
@Component
public class APIHelper {

    protected static ClientRequest clientRequest;
    protected static ClientResponse<String> clientResponse;
    protected static ObjectMapper mapper = new ObjectMapper();

    @Value("${API.host}")
    private String HOST;

    public APIHelper() {};

    public User getApiUser(String username) throws Exception {

        System.out.println("HOST is; " + HOST);

        clientRequest = new ClientRequest(HOST + UserProxy.Urls.BASE_URL + UserProxy.Urls.USER);

        // Path Parameters
        clientRequest.pathParameter("username", "wes@wes.com");

        // GET response
        clientResponse = clientRequest.accept(MediaType.APPLICATION_JSON).get(String.class);

        // get the HTTP Header Body
        User user = mapper.readValue(clientResponse.getEntity(), User.class);

        return user;
    }

}
