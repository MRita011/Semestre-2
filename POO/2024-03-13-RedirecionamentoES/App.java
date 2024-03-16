// Imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;

public class App {
    private Scanner entrada = null;                 // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)

    public App() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("entrada.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);

        // Implemente aqui o seu codigo adicional do construtor
    }

    // Restaura E/S padrao de tela(console)/teclado
    private void restauraES() {
        System.setOut(saidaPadrao);
    }

    public void executar() {

        System.out.println("\fFunfando...");

        int idade;
        String nome;

        System.out.println("\nDigite a idade: ");
        idade = entrada.nextInt();
        entrada.nextLine();

        System.out.println("\nDigite o nome: ");
        nome = entrada.nextLine();


        System.out.println("\nIdade: " + idade + "\nNome: " + nome);
    }
}
