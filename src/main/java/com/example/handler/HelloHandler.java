package com.example.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class HelloHandler implements HttpHandler {
    private final String version;

    public HelloHandler() {
        Properties p = new Properties();
        String v = "unknown";
        try (InputStream in = getClass().getResourceAsStream("/version.properties")) {
            if (in != null) {
                p.load(in);
                v = p.getProperty("version", v);
            }
        } catch (IOException ignored) {
        }
        version = v;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = String.format("{\"message\":\"Hello from Java sample\",\"version\":\"%s\"}", version);
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
