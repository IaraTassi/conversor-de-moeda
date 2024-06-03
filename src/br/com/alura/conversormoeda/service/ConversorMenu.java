package br.com.alura.conversormoeda.service;

import br.com.alura.conversormoeda.controller.ConsultaApi;
import br.com.alura.conversormoeda.controller.ConversorApi;

import java.util.Scanner;


public class ConversorMenu {
    public void menu() {

        System.out.println(
                """
                        ***************************************************
                        Seja bem-vindo/a ao conversor de Moeda =]
                        
                        1) Dólar =>> Peso argentino
                        2) Peso argentino =>> Dólar
                        3) Dólar =>> Real brasileiro
                        4) Real brasileiro =>> Dólar
                        5) Dólar =>> Peso colombiano
                        6) Peso colombiano =>> Dólar
                        7) Sair
                        Escolha uma opção válida:
                        ***************************************************
                        """
        );
    }

    private String converter(double valor, String moeda1, String moeda2) {
        ConsultaApi consultaApi = new ConsultaApi();
        ConversorApi conversorApi = consultaApi.buscarConversoes(moeda1, moeda2);
        double valorConvertido = valor * Double.valueOf(conversorApi.conversion_rate());
        return String.format("Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]", valor, moeda1, valorConvertido, moeda2);
    }

    public void selecionarConversao(int opcao) {
        try {
            Scanner leitura = new Scanner(System.in);

           if (opcao == 7) {
                System.out.println("Programa encerrado.");
                System.exit(0);
            }

            System.out.println("Digite o valor que deseja converter: ");
            double valor = leitura.nextDouble();

            String moeda1 = "";
            String moeda2 = "";

            switch (opcao) {
                case 1:
                    moeda1 = "USD";
                    moeda2 = "ARS";
                    break;
                case 2:
                    moeda1 = "ARS";
                    moeda2 = "USD";
                    break;
                case 3:
                    moeda1 = "USD";
                    moeda2 = "BRL";
                    break;
                case 4:
                    moeda1 = "BRL";
                    moeda2 = "USD";
                    break;
                case 5:
                    moeda1 = "USD";
                    moeda2 = "COP";
                    break;
                case 6:
                    moeda1 = "COP";
                    moeda2 = "USD";
                    break;
                default:
                    System.out.println("Opção inválida, tente uma válida!");
                    return;
            }

            System.out.println(converter(valor, moeda1, moeda2));

        } catch (Exception e) {
            throw new RuntimeException("Conversão não pode ser realizada, adicione valores corretos!");
        }
    }
}








