package com.example.kpp;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class WebResourceTest extends JerseyTest {

    public WebResourceTest() {
        super("com.example.kpp.rest");
    }

    @Test
    public void testGetGridData() {
        Client client = Client.create();
        WebResource resource = client.resource("http://192.168.0.23:8080/testapp/api/resource/getGridData");
        ClientResponse response = resource.get(ClientResponse.class);
        String responseEntity = response.getEntity(String.class);
        assertThat(responseEntity, not(isEmptyOrNullString()));
    }

    @Test
    public void testGetChartData() {
        Client client = Client.create();
        WebResource resource = client.resource("http://192.168.0.23:8080/testapp/api/resource/getChartData");
        ClientResponse response = resource.get(ClientResponse.class);
        String responseEntity = response.getEntity(String.class);
        assertThat(responseEntity, not(isEmptyOrNullString()));
    }


}
