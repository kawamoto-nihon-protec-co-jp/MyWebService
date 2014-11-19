package com.example.kpp;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

@RunWith(Enclosed.class)
public class ResourceTest extends JerseyTest {

    public ResourceTest() {
        super("com.example.kpp.rest");
    }

    public static class WebResourceTest extends DBunitSetup {
        static {
            xlsFile = "com/example/kpp/HEALTH_INFO.xml";
        }

        @Mocked
        private com.example.kpp.rest.WebResource webResourceMock;

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

        @Test
        public void testPutHealthInfo() {
            new NonStrictExpectations() {{
                webResourceMock.registerHealthInfo(null); result = new Exception();
            }};
            assertThat(webResourceMock.registerHealthInfo(null).getStatus(), is("9"));
        }
    }

//    @Test
//    public void testGetGridData() {
//        Client client = Client.create();
//        WebResource resource = client.resource("http://192.168.0.23:8080/testapp/api/resource/getGridData");
//        ClientResponse response = resource.get(ClientResponse.class);
//        String responseEntity = response.getEntity(String.class);
//        assertThat(responseEntity, not(isEmptyOrNullString()));
//    }
//
//    @Test
//    public void testGetChartData() {
//        Client client = Client.create();
//        WebResource resource = client.resource("http://192.168.0.23:8080/testapp/api/resource/getChartData");
//        ClientResponse response = resource.get(ClientResponse.class);
//        String responseEntity = response.getEntity(String.class);
//        assertThat(responseEntity, not(isEmptyOrNullString()));
//    }

}
