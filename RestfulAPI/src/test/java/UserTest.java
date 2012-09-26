
import com.acme.shared.dto.User;
import com.acme.shared.proxy.UserProxy;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.springmvc.tjws.TJWSEmbeddedSpringMVCServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * User: jdavis
 * Date: 9/16/12
 * Time: 9:25 PM
 */
public class UserTest {

    protected static ClientRequest clientRequest;
    protected static ClientResponse<String> clientResponse;
    protected static ObjectMapper mapper = new ObjectMapper();
    static TJWSEmbeddedSpringMVCServer server;
    protected static final String HOST = "http://localhost:8282";

    @Test
    public void UserTest() throws Exception {
        clientRequest = new ClientRequest(HOST + UserProxy.Urls.BASE_URL + UserProxy.Urls.USER);

        // Path Parameters
        clientRequest.pathParameter("username", "wes@wes.com");

        // GET response
        clientResponse = clientRequest.accept(MediaType.APPLICATION_JSON).get(String.class);

        // get the HTTP Header Body
        User user = mapper.readValue(clientResponse.getEntity(), User.class);

        Assert.assertEquals(user.getFullName(), "John Doe");
    }

    @BeforeClass
    public static void setup() throws Exception {
        System.out.println("BeforeClass Start " + new Date());

        server = new TJWSEmbeddedSpringMVCServer("classpath:springmvc-servlet.xml", 8282);
        server.start();

        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
    }

    @AfterClass
    public static void end() {
        System.out.println("AfterClass End " + new Date());
        server.stop();
    }
}
