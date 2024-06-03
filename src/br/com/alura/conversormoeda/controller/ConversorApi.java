package br.com.alura.conversormoeda.controller;

public record ConversorApi(String result, String base_code, String target_code, double conversion_rate) {

}
