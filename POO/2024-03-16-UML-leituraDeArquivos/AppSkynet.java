
// Imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;

public class AppSkynet 
{
    private Scanner entrada = null;
    private PrintStream saidaPadrao = System.out;
    private Enxame enxame;

    public AppSkynet() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
            entrada = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        Locale.setDefault(Locale.ENGLISH);
        entrada.useLocale(Locale.ENGLISH);

        enxame = new Enxame();
        entrada = new Scanner(System.in);

    private void restauraES() {
        System.setOut(saidaPadrao);
    }
}

    public void executar() {
        menu();
        int opcao = entrada.nextInt();
        entrada.nextLine();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    adicionaRobo();
                    break;

                case 2:
                    consultaRobo();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpcao invalida. Redigite.");
            }

            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();
        }
        System.out.println("\nFim da execucao...");
    }

    private void adicionaRobo() {
        System.out.println("\nDigite o modelo do robô: ");
        String modelo = entrada.nextLine();

        System.out.println("\nDigite o valor do robô: ");
        double valor = entrada.nextDouble();
        entrada.nextLine();

        Robo r = new Robo(modelo, valor);
        if (enxame.adicionaRobo(r))
            System.out.println("Produto cadastrado!");
    }

    private void consultaRobo() {
        System.out.println("\nDigite o modelo do robô: ");
        String modelo = entrada.nextLine();

        Robo r = enxame.consultaRobo(modelo);
        if (r == null)
            System.out.println("Nenhum produto encontrado com este nome.");
        else
            System.out.println(r);
    }

    private void menu() {
        System.out.println("\n[1] Cadastrar um produto: " +
                "[2] Consultar um produto pelo nome: " +
                "[3] Remover produtos pelo ano: " +
                "[0] Sair.");
    }
}
