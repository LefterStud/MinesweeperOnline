
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class Server implements HttpHandler {

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
        OutputStream outputStream = exchange.getResponseBody();
        StringBuilder response = new StringBuilder();

        if(requestParamValues[0].equals("test")){
            response.append("Connected");
        }
    }
}
