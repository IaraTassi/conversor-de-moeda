import br.com.alura.conversormoeda.service.ConversorMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            ConversorMenu meuMenu = new ConversorMenu();
            while (true) {
                meuMenu.menu();
                Scanner leitura = new Scanner(System.in);
                int opcao = leitura.nextInt();
                meuMenu.selecionarConversao(opcao);

        }
    }

}

