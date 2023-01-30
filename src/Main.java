import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/back", new Server());
        server.start();
        System.out.println(System.lineSeparator() + "Server started at: localhost:8080");
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        startServer();
    }

}