package ngdemo.rest;

import java.net.URI;

import org.junit.rules.ExternalResource;

final class ServerResource extends ExternalResource {

    private final TestServer server = new TestServer();

    @Override
    protected void before() throws Throwable {
        server.start();
    }

    @Override
    protected void after() {
        server.stop();
    }

    public URI getBaseUri() {
        return server.getBaseUri();
    }
}
