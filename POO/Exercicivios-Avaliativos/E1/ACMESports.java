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

        String nome = entrada.nextLine().trim();
        mostrarAtleta(nome);

        int codigo = entrada.nextInt();
        entrada.nextLine();
        mostrarMedalha(codigo);

        String pais = entrada.nextLine().trim();
        mostrarAtletaPorPais(pais);

        int tipo = entrada.nextInt();
        entrada.nextLine();
        mostrarAtletaPorMedalha(tipo);

        String modalidade = entrada.nextLine().trim();
        mostrarAtletaPorModalidade(modalidade);

        mostraratletaMedalhado();
        mostrarQuadroMedalhasPorPais();
        mostrarQuadroMedalhasCompleto();
    }

    public void cadastrarAtletas() {
//       1. Cadastrar atletas: lê todos os dados de cada atleta e, se o número não for repetido, cadastra-o no sistema.
//       Para cada atleta cadastrado com sucesso no sistema, mostra os dados do atleta no formato:
//       1:número,nome,país

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
//       2. Cadastrar medalhas: lê todos os dados de cada medalha e, se o código não for repetido, cadastra-a no sistema.
//       Para cada medalha cadastrada com sucesso no sistema, mostra os dados da medalha no formato:
//       2:codigo,tipo,é individual?,modalidade

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
//       3. Cadastrar medalhas e atletas correspondentes: adiciona uma medalha para cada atleta e vice-versa.
//       Para cada cadastramento com sucesso mostra os dados no formato:
//       3:código,número

        System.out.println("\n------- CADASTRAR MEDALHAS E ATLETAS CORRESPONDENTES -------");

        ArrayList<Atleta> atletas = plantel.getAtletas();
        ArrayList<Medalha> medalhas = medalheiro.getMedalhas();

        int nAtletas = atletas.size();
        int nMedalhas = medalhas.size();

        int minSize = Math.min(nAtletas, nMedalhas);

        for (int i = 0; i < minSize; i++) {
            Atleta atleta = atletas.get(i);
            Medalha medalha = medalhas.get(i);

            medalha.adicionaAtleta(atleta);
            atleta.adicionaMedalha(medalha);

            System.out.println("3:" + medalha.getCodigo() + "," + atleta.getNumero());
        }

        if (nAtletas > nMedalhas) {
            for (int i = minSize; i < nAtletas; i++) {
                Atleta atleta = atletas.get(i);
                System.out.println("3:Não há medalha para o atleta " + atleta.getNumero());
            }
        } else if (nMedalhas > nAtletas) {
            for (int i = minSize; i < nMedalhas; i++) {
                Medalha medalha = medalhas.get(i);
                System.out.println("3:" + medalha.getCodigo() + ",Não há atleta para a medalha ");
            }
        }
    }

    public void mostrarAtleta(int numero) {
//       4. Mostrar os dados de um determinado atleta por número: lê o número de um determinado atleta.
//       Se não existir um atleta com o número indicado, mostra a mensagem de erro: “4:Nenhum atleta encontrado.”.
//       Se existir, mostra os dados do atleta no formato:
//       4:número,nome,país

        System.out.println("\n------- MOSTRAR ATLETA POR NÚMERO -------");

        while (true) {
            numero = entrada.nextInt();
            if (numero == -1)
                break;

            Atleta a = plantel.consultaAtleta(numero);
            if (a != null)
                System.out.println("\n4:" + a.getNumero() + "," + a.getNome() + "," + a.getPais());

            else
                System.out.println("\n4:Nenhum atleta encontrado.");
        }
    }

    public void mostrarAtleta(String nome) {
//       5. Mostrar os dados de um determinado atleta por nome: lê o nome de um determinado atleta.
//       Se não existir um atleta com o nome indicado, mostra a mensagem de erro: “5:Nenhum atleta encontrado.”.
//       Se existir, mostra os dados do atleta no formato:
//       5:número,nome,país

        System.out.println("\n------- MOSTRAR ATLETA POR NOME -------");

        entrada.nextLine();
        nome = entrada.nextLine().trim();

        Atleta a = plantel.consultaAtleta(nome);
        if (a != null)
            System.out.println("\n5:" + a.getNumero() + "," + a.getNome() + "," + a.getPais());

        else
            System.out.println("\n5:Nenhum atleta encontrado.");
    }

    public void mostrarMedalha(int codigo) {
//       6. Mostrar os dados de uma determinada medalha: lê um código de medalha.
//       Se não existir uma medalha com o código indicado, mostra a mensagem de erro: “6:Nenhuma medalha encontrada.”.
//       Se existir, mostra os dados da medalha no formato:
//       6:codigo,tipo,é individual?,modalidade

        System.out.println("\n------- MOSTRAR MEDALHA POR CÓDIGO -------");
        Medalha m = medalheiro.consultaMedalha(codigo);
        if (m != null)
            System.out.println("\n6:" + m.getCodigo() + ", " + m.getTipo() + ", " + m.getIndividual() + ", " + m.getModalidade());

        else
            System.out.println("\n5:Nenhum atleta encontrado.");
    }

    public void mostrarAtletaPorPais(String pais) {
//    7. Mostrar os dados dos atletas de um determinado país: lê o nome de um país.
//    Se não existir nenhum país com o nome indicado, mostra a mensagem de erro: “7:Pais nao encontrado.”.
//    Se existir, mostra os dados de cada atleta no formato:
//    7:número,nome,país

        System.out.println("\n------- MOSTRAR ATLETA POR PAÍS -------");

        ArrayList<Atleta> atletasDoPais = new ArrayList<>();

        for (Atleta a : plantel.getAtletas()) {
            if (a.getPais().equalsIgnoreCase(pais))
                atletasDoPais.add(a);
        }

        if (atletasDoPais.isEmpty())
            System.out.println("7:Pais nao encontrado.");

        else {
            for (Atleta a : atletasDoPais) {
                System.out.println("7:" + a.getNumero() + "," + a.getNome() + "," + a.getPais());
            }
        }
    }

    public void mostrarAtletaPorMedalha(int tipo) {
//    8. Mostrar os dados atletas de um determinado tipo de medalha: lê o tipo de uma medalha.
//    Se não houver nenhum atleta com o tipo de medalha indicado, mostra a mensagem de erro: “8:Nenhum atleta encontrado.”
//    caso contrário, mostra os dados de cada atleta no formato:
//    8:número,nome,país

        System.out.println("\n------- MOSTRAR ATLETA POR TIPO DE MEDALHA -------");
        boolean encontrar = false;

        for (Medalha medalha : medalheiro.getMedalhas()) {
            if (medalha.getTipo() == tipo) {
                for (Atleta atleta : medalha.getAtletas()) {
                    System.out.println("\n8:" + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());
                    encontrar = true;
                }
            }
        }

        if (!encontrar)
            System.out.println("8:Nenhum atleta encontrado.");
    }

    public void mostrarAtletaPorModalidade(String modalidade) {
//    9. Mostrar os dados atletas de uma determinada modalidade: lê uma modalidade.
//    Se não houver a modalidade no sistema, mostra a mensagem de erro: “9:Modalidade não encontrada.”
//    Se uma medalha não tiver atleta, mostra uma mensagem no formato: 9:modalidade,tipo,Sem atletas com medalha.
//    Caso contrário, mostra os dados de cada atleta da medalha no formato: 9:modalidade,tipo,número,nome,país

        System.out.println("\n------- MOSTRAR ATLETAS POR MODALIDADE -------");
        ArrayList<Medalha> medalhasEncontradas = medalheiro.consultaMedalhas(modalidade);

        if (medalhasEncontradas == null || medalhasEncontradas.isEmpty()) {
            System.out.println("9:" + modalidade + ",Nenhum tipo de medalha encontrado.");
            return;
        }

        boolean encontrouAtleta = false;

        for (Medalha medalha : medalhasEncontradas) {
            ArrayList<Atleta> atletas = medalha.getAtletas();

            if (atletas.isEmpty()) {
                System.out.println("9:" + modalidade + "," + medalha.getTipo() + ",Sem atletas com medalha.");
            } else {
                for (Atleta atleta : atletas) {
                    System.out.println("9:" + modalidade + "," + medalha.getTipo() + "," + atleta.getNumero() + "," + atleta.getNome() + "," + atleta.getPais());
                    encontrouAtleta = true;
                }
            }
        }

        if (!encontrouAtleta) {
            System.out.println("9:" + modalidade + ",Sem atletas com medalha.");
        }
    }

    public void mostraratletaMedalhado() {
//    10.Mostrar os dados do atleta com mais medalhas: localiza o atleta com maior número de medalhas.
//    Se não houver atletas com medalhas, mostra a mensagem de erro: “10:Nenhum atleta com medalha.”.
//    Caso contrário, mostra os dados do atleta e medalhas no formato:
//    10:número,nome,país,Ouro:quantidade,Prata:quantidade,Bronze:quantidade

        System.out.println("\n------- ATLETA COM MAIS MEDALHAS -------");

        int max = 0;
        Atleta atletaMedalhado = null;

        if (plantel.getAtletas().isEmpty()) {
            System.out.println("\n10: Nenhum atleta com medalha.");
            return;
        }

        // Percorre todos os atletas
        for (Atleta atleta : plantel.getAtletas()) {
            int total = atleta.consultaQuantidadeMedalha();

            // Atualiza o atleta com mais medalhas
            if (total > max) {
                max = total;
                atletaMedalhado = atleta;
            }
        }

        // Verifica se algum atleta possui medalhas
        if (atletaMedalhado != null) {
            int ouro = atletaMedalhado.quantidadeMedalhasTipo(1);
            int prata = atletaMedalhado.quantidadeMedalhasTipo(2);
            int bronze = atletaMedalhado.quantidadeMedalhasTipo(3);

            System.out.println("\n10: " + atletaMedalhado.getNumero() + ", " + atletaMedalhado.getNome() + ", " + atletaMedalhado.getPais() + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);
        }

        else
            System.out.println("\n10: Nenhum atleta com medalha.");
    }

    public void mostrarQuadroMedalhasPorPais() {
        System.out.println("\n------- QUADRO GERAL DE MEDALHAS POR PAÍS -------");
        ArrayList<String> paises = new ArrayList<>();

        for (Atleta atleta : plantel.getAtletas()) {
            String pais = atleta.getPais();
            if (!paises.contains(pais))
                paises.add(pais);
        }

        // Para cada país, calcula a quantidade de medalhas de ouro, prata e bronze
        for (String pais : paises) {
            int ouro = 0;
            int prata = 0;
            int bronze = 0;

            for (Atleta atleta : plantel.getAtletas()) {
                if (atleta.getPais().equals(pais)) {
                    ouro += atleta.quantidadeMedalhasTipo(1);
                    prata += atleta.quantidadeMedalhasTipo(2);
                    bronze += atleta.quantidadeMedalhasTipo(3);
                }
            }

            // Exibe as informações do país
            System.out.println("\n11: País: " + pais + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);
        }
    }

    public void mostrarQuadroMedalhasCompleto() {
        System.out.println("\n------- QUADRO GERAL DE MEDALHAS COMPLETO -------");
        ArrayList<String> paises = new ArrayList<>();

        for (Atleta atleta : plantel.getAtletas()) {
            String pais = atleta.getPais();
            if (!paises.contains(pais))
                paises.add(pais);
        }

        // Para cada país, calcula a quantidade total de medalhas e exibe os dados de cada atleta
        for (String pais : paises) {
            int total = 0;
            System.out.println("\nPaís: " + pais);

            for (Atleta atleta : plantel.getAtletas()) {
                if (atleta.getPais().equals(pais)) {
                    int ouro = atleta.quantidadeMedalhasTipo(1);
                    int prata = atleta.quantidadeMedalhasTipo(2);
                    int bronze = atleta.quantidadeMedalhasTipo(3);
                    total += ouro + prata + bronze;

                    System.out.println("12: Atleta: " + atleta.getNome() + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);
                }
            }
            System.out.println("Total de Medalhas: " + total);
        }
    }

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
