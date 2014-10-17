package ngdemo.rest;

import java.net.URI;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

final class TestServer {

    private static final int PORT = 8080;

    private Server server;

    public void start() throws Exception {
        server = new Server(PORT);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar("src/main/webapp");

        server.setHandler(context);
        server.start();
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            System.out.println("Failed to stop server.");
            e.printStackTrace();
        }
    }

    public URI getBaseUri() {
        return server.getURI();
    }

}