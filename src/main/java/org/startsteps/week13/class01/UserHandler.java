package org.startsteps.week13.class01;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserHandler implements HttpHandler {

    List<User> users = new ArrayList<>();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        String response="";

        System.out.println(exchange.getRequestMethod());
        System.out.println(exchange.getRequestURI());
        System.out.println(exchange.getResponseBody());

        for (Map.Entry<String, List<String>> entry : exchange.getRequestHeaders().entrySet()){
            System.out.println(entry);
        }

        if (method.equalsIgnoreCase("GET")) {
            // Handle GET request
            List<User> users = handleGetRequest(exchange);
            for (User u: users) {
                response += u.toString();
            }
        } else if (method.equalsIgnoreCase("POST")) {
            // Handle POST request
            List<User> updatedUsers = handlePostRequest(exchange);
            for (User u: updatedUsers) {
                response += u.toString();
            }
        } else if (method.equalsIgnoreCase("PUT")) {
            // Handle PUT request
            response = handlePutRequest(exchange);
        } else if (method.equalsIgnoreCase("DELETE")) {
            // Handle DELETE request
            List<User> updatedUsers = handleDeleteRequest(exchange);
            for (User u: updatedUsers) {
                response += u.toString();
            }
        }



        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    private List<User> handleGetRequest(HttpExchange exchange) {
        return users;
    }

    private List<User> handlePostRequest(HttpExchange exchange) {
        User user = new User(1, "Menil", "menilv@gmail.com");
        users.add(user);
        return users;
    }

    private String handlePutRequest(HttpExchange exchange) {
        return "PUT response";
    }

    private List<User> handleDeleteRequest(HttpExchange exchange) {
        users.remove(0);
        return users;
    }
}

