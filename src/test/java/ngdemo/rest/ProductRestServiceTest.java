package ngdemo.rest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ngdemo.domain.Product;

import org.junit.ClassRule;
import org.junit.Test;

public class ProductRestServiceTest {

    @ClassRule
    public static ServerResource server = new ServerResource();

    private WebTarget target = ClientBuilder.newClient().target(server.getBaseUri());

    @Test
    public void testGetProducts() {
        Response response = target.path("api/products").request(MediaType.APPLICATION_JSON).get();

        assertEquals(Status.OK.getStatusCode(), response.getStatus());

        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getFirst("Content-Type"));

        List<Product> products = response.readEntity(new GenericType<List<Product>>(){});
        assertEquals(2, products.size());
    }

}
