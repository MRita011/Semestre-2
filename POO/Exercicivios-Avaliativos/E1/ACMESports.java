// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class ACMESports
{
    private final Medalheiro medalheiro;
    private final Plantel plantel;

    private Scanner entrada = new Scanner(System.in);
    private PrintStream saidaPadrao = System.out;
    private final String nomeArquivoEntrada = "dadosin.txt";
    private final String nomeArquivoSaida = "dadosout.txt";

    public ACMESports() {
        medalheiro = new Medalheiro();
        plantel = new Plantel();
        redirecionaES();
    }

    public void executar() {
        cadastrarAtletas();
        cadastrarMedalhas();
        cadastrarMedalhasAtletasCorrespondentes();

        int numero = entrada.nextInt();
        entrada.nextLine();
        mostrarAtleta(numero);

        String nome = entrada.nextLine();
        mostrarAtleta(nome);
    }

    public void cadastrarAtletas() {
        System.out.println("\n------- CADASTRAR ATLETAS -------");

        int numero;
        String nome;
        String pais;
        numero = entrada.nextInt();

        while(numero != -1) {
            entrada.nextLine();

            nome = entrada.nextLine();
            pais = entrada.nextLine();

            Atleta a = new Atleta(numero, nome, pais);
            if (plantel.cadastraAtleta(a))
                System.out.println("\n1: " + numero + ", " + nome + ", " + pais);

            else
                System.out.println("\nAtleta não cadastrado(a)!!!!!!");

            numero = entrada.nextInt();
        }
    }

    public void cadastrarMedalhas() {
        System.out.println("\n------- CADASTRAR MEDALHAS -------");

        int codigo;
        int tipo;
        boolean individual;
        String modalidade;

        codigo = entrada.nextInt();
        while(codigo != -1) {
            tipo = entrada.nextInt();
            individual = entrada.nextBoolean();

            entrada.nextLine();
            modalidade = entrada.nextLine();

            Medalha m = new Medalha(codigo, tipo, individual, modalidade);
            if (medalheiro.cadastraMedalha(m))
                System.out.println("\n2: " + codigo + ", " + tipo + ", " + individual + ", " + modalidade);

            else
                System.out.print("\nMedalha não cadastrada!!!!!!");

            codigo = entrada.nextInt();
        }
    }

    public void cadastrarMedalhasAtletasCorrespondentes() {
        System.out.println("\n------- CADASTRAR MEDALHAS E ATLETAS CORRESPONDENTES -------");

        ArrayList<Atleta> atletas = plantel.getAtletas();
        ArrayList<Medalha> medalhas = medalheiro.getMedalhas();

        int nAtletas = atletas.size();
        int nMedalhas = medalhas.size();

        for (int i = 0; i < Math.min(nAtletas, nMedalhas); i++) {
            Atleta atleta = atletas.get(i);
            Medalha medalha = medalhas.get(i);

            medalha.adicionaAtleta(atleta);
            atleta.adicionaMedalha(medalha);

            System.out.println("\n3: " + medalha.getCodigo() + ", " + atleta.getNumero());
        }

        if (nAtletas > nMedalhas) {
            for (int i = nMedalhas; i < nAtletas; i++) {
                Atleta atleta = atletas.get(i);
                System.out.println("\n3: Não há medalha para o atleta " + atleta.getNumero());
            }
        }

        else if (nMedalhas > nAtletas) {
            for (int i = nAtletas; i < nMedalhas; i++) {
                Medalha medalha = medalhas.get(i);
                System.out.println("\n3: Não há atleta para a medalha " + medalha.getCodigo());
            }
        }
    }

    public void mostrarAtleta(int numero) {
        System.out.println("\n------- MOSTRAR ATLETA POR NÚMERO -------");

        System.out.println(numero);
        Atleta a = plantel.consultaAtleta(numero);

        if (a != null) {
            System.out.println("\n4:" + a.getNumero() + "," + a.getNome() + "," + a.getPais());
        } else {
            System.out.println("\n4: Nenhum atleta encontrado.");
        }
    }

    public void mostrarAtleta(String nome) {
        System.out.println("\n------- MOSTRAR ATLETA POR NOME -------");
        
        Atleta atleta = plantel.consultaAtleta(nome);
        System.out.println(nome);

        if (atleta != null)
            System.out.println("\n5: " + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());

        else
            System.out.println("\n5: Nenhum atleta encontrado.");
    }

    /*        public void mostrarAtletaPorMedalhaCodigo() {
        //		lê um código de medalha.
        //		Se não existir uma medalha com o código indicado, mostra a mensagem de erro: “6:Nenhuma medalha encontrada.”
        //		Se existir, mostra os dados da medalha no formato: 6:codigo,tipo,é individual?,modalidade

            }
        /*
            public void mostrarAtletaPorPais() {
        //		lê o nome de um país.
        //		Se não existir nenhum país com o nome indicado, mostra a mensagem de erro: “7:Pais nao encontrado.”
        //		Se existir, mostra os dados de cada atleta no formato: 7:número,nome,país

            }

            public void mostrarAtletaPorTipo() {
        //		lê o tipo de uma medalha.
        //		Se não houver nenhum atleta com o tipo de medalha indicado, mostra a mensagem de erro: “8:Nenhum atleta encontrado.”
        //		caso contrário, mostra os dados de cada atleta no formato: 8:número,nome,país
            }

            public void mostrarAtletaPorModalidade() {
        //		lê uma modalidade.
        //		Se não houver a modalidade no sistema, mostra a mensagem de erro: “9:Modalidade não encontrada.”
        //		Se uma medalha não tiver atleta, mostra uma mensagem no formato: 9:modalidade,tipo,Sem atletas com medalha.
        //		Caso contrário, mostra os dados de cada atleta da medalha no formato: 9:modalidade,tipo,número,nome,país

            }

            public void mostrarAtletaComMaisMedalhas() {
        //		localiza o atleta com maior número de medalhas.
        //		Se não houver atletas com medalhas, mostra a mensagem de erro: “10:Nenhum atleta com medalha.”
        //		Caso contrário, mostra os dados do atleta e medalhas no formato: 10:número,nome,país,Ouro:quantidade,Prata:quantidade,Bronze:quantidade

            }*/
    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
            entrada = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), Charset.forName("UTF-8"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        entrada.useLocale(Locale.ENGLISH);
    }

    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
}
