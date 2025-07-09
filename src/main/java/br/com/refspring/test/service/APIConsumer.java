package br.com.refspring.test.service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumer {

    public String consumeAPI(String url) {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .build();
        HttpResponse<String> response = null;

        try {
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao consumir API", e);
        }catch (InterruptedException e) {
            throw new RuntimeException("Erro ao consumir API", e);
        }

        String json = response.body();
        return json;
    }
}
