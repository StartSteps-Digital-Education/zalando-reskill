package org.startsteps.week13.class01;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RestServer {
    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        System.out.println("Server started at http://localhost:" + serverPort);

        server.createContext("/api/user", new UserHandler());
        server.createContext("/api/login", new LoginHandler());
        // http://localhost:8000 + /api/user GET POST PUT DELETE PATCH

        // Test with curl: curl http://localhost:8000/api/user
        // Test with curl: curl -X POST http://localhost:8000/api/user -d '{"name":"John Doe","email":"john@example.com"}'

        server.setExecutor(null); // Default executor
        server.start();
    }
}
