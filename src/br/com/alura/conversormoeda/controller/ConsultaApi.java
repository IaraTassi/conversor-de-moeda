package br.com.alura.conversormoeda.controller;

import br.com.alura.conversormoeda.controller.ConversorApi;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public ConversorApi buscarConversoes(String moeda1, String moeda2) {
        String enderecoApi = "https://v6.exchangerate-api.com/v6/83b0daae62de89ad3fa7f134/pair/";
        URI endereco = URI.create(enderecoApi + moeda1 + "/" + moeda2 );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversorApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a conversão endereço API inválido.");
        }
    }

}




