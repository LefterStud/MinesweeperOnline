
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class Server implements HttpHandler {
    static int requestCounter = 0;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST");
        String[] requestParams = null;
        if ("GET".equals(exchange.getRequestMethod())) {
            requestParams = getRequestParams(exchange);
        }
        if ("POST".equals(exchange.getRequestMethod())) {
            requestParams = getRequestParams(exchange);
        }
        returnResponse(exchange, requestParams);
    }

    private String[] getRequestParams(HttpExchange exchange) {
        String parameters = exchange.getRequestURI().toString().split("\\?")[1];
        return parameters.split("&");
    }

    private void returnResponse(HttpExchange exchange, String[] requestParamValues) throws IOException {
        requestCounter++;
        System.out.println("Request received: " + requestCounter);
        OutputStream outputStream = exchange.getResponseBody();
        StringBuilder response = new StringBuilder();

        if(requestParamValues[0].equals("test")){
            response.append("Connected");
        }
        exchange.sendResponseHeaders(0, response.length());
        outputStream.write(response.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
