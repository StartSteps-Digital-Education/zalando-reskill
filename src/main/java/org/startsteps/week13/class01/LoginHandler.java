package org.startsteps.week13.class01;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class LoginHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        boolean isLoggedIn = false;
        String password = "test12345";

        for (Map.Entry<String, List<String>> entry : exchange.getRequestHeaders().entrySet()){
            if(entry.getKey().equals("Authorization")){
                if(entry.getValue().get(0).equals(password))
                    isLoggedIn = true;
            }
        }

        if(isLoggedIn) {
            exchange.sendResponseHeaders(200, "Logged in, congrats!".length());
            OutputStream os = exchange.getResponseBody();
            os.write("Logged in, congrats!".getBytes(StandardCharsets.UTF_8));
            os.close();
        }else{
            exchange.sendResponseHeaders(401, "You're not Menil".length());
            OutputStream os = exchange.getResponseBody();
            os.write("You're not Menil".getBytes(StandardCharsets.UTF_8));
            os.close();
        }

    }
}
