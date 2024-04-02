// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class ACMESports
{
    // Atributos para redirecionamento de E/S
    private Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "dadosin.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "dadosout.txt";  // Nome do arquivo de saida de dados

    private Medalheiro medalheiro;
    private Plantel plantel;

    public ACMESports() {
        medalheiro = new Medalheiro();
        plantel = new Plantel();

        redirecionaES();    // Redireciona E/S para arquivos
    }

    public void executar() {
        cadastrarAtletas();
        cadastrarMedalhas();
        cadastrarMedalhasAtletasCorrespondentes();

        mostrarAtletaPorNumero();
        mostrarAtletaPorNome();

        mostrarMedalhaPorCodigo();
        mostrarAtletaPorPais();
        mostrarAtletaPorTipoMedalha();
        mostrarAtletaPorModalidade();
        MostrarAtletaComMaisMedalhas();
        
        mostrarQuadroMedalhasPorPais();
        mostrarQuadroMedalhasCompleto();
    }

    public void cadastrarAtletas() {
//       1. Cadastrar atletas: lê todos os dados de cada atleta e, se o número não for repetido, cadastra-o no sistema.
//       Para cada atleta cadastrado com sucesso no sistema, mostra os dados do atleta no formato:
//       1:número,nome,país

        int numero;
        String nome;
        String pais;
        numero = entrada.nextInt();

        while(numero != -1) {
            entrada.nextLine();

            nome = entrada.nextLine();
            pais = entrada.nextLine();

            Atleta atleta = new Atleta(numero, nome, pais);
            if (plantel.cadastraAtleta(atleta))
                System.out.println("1: " + numero + ", " + nome + ", " + pais);

            else
                System.out.println("Atleta não cadastrado(a)!!!!!!");

            numero = entrada.nextInt();
        }
    }

    public void cadastrarMedalhas() {
//       2. Cadastrar medalhas: lê todos os dados de cada medalha e, se o código não for repetido, cadastra-a no sistema.
//       Para cada medalha cadastrada com sucesso no sistema, mostra os dados da medalha no formato:
//       2:codigo,tipo,é individual?,modalidade

        int tipo;
        boolean individual;
        String modalidade;
        int codigo = entrada.nextInt();

        while (codigo != -1) {
            tipo = entrada.nextInt();

            individual = entrada.nextBoolean();
            entrada.nextLine();

            modalidade = entrada.nextLine();

            Medalha medalha = new Medalha(codigo, tipo, individual, modalidade);
            if (medalheiro.cadastraMedalha(medalha))
                System.out.println("2: " + codigo + ", " + tipo + ", " + individual + ", " + modalidade);

            else
                System.out.println("2: Medalha não cadastrada.");

            codigo = entrada.nextInt();
        }
    }

    public void cadastrarMedalhasAtletasCorrespondentes() {
//       3. Cadastrar medalhas e atletas correspondentes: adiciona uma medalha para cada atleta e vice-versa.
//       Para cada cadastramento com sucesso mostra os dados no formato:
//       3:código,número

        do {
            int codigo = entrada.nextInt();
            if (codigo == -1)
                break;

            int numero = entrada.nextInt();
            entrada.nextLine();

            Medalha medalha = medalheiro.consultaMedalha(codigo);
            Atleta atleta = plantel.consultaAtleta(numero);

            if (medalha != null && atleta != null) {
                medalha.adicionaAtleta(atleta);
                atleta.adicionaMedalha(medalha);
                System.out.println("3: " + codigo + ", " + numero);
            } else {
                System.out.println("3: Não foi possível associar a medalha " + codigo + " ao atleta " + numero);
            }
        } while (true);
    }

    public void mostrarAtletaPorNumero() {
//       4. Mostrar os dados de um determinado atleta por número: lê o número de um determinado atleta.
//       Se não existir um atleta com o número indicado, mostra a mensagem de erro: “4:Nenhum atleta encontrado.”.
//       Se existir, mostra os dados do atleta no formato:
//       4:número,nome,país

        int numero = entrada.nextInt();
        entrada.nextLine();

        Atleta atleta = plantel.consultaAtleta(numero);
        if (atleta != null)
            System.out.println("4: " + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());

        else
            System.out.println("4:Nenhum atleta encontrado.");
    }

    public void mostrarAtletaPorNome() {
//       5. Mostrar os dados de um determinado atleta por nome: lê o nome de um determinado atleta.
//       Se não existir um atleta com o nome indicado, mostra a mensagem de erro: “5:Nenhum atleta encontrado.”.
//       Se existir, mostra os dados do atleta no formato:
//       5:número,nome,país

        String nome = entrada.nextLine();

        Atleta atleta = plantel.consultaAtleta(nome);
        if (atleta != null)
            System.out.println("5: " + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());

        else
            System.out.println("5: Nenhum atleta encontrado.");
    }

    public void mostrarMedalhaPorCodigo() {
//       6. Mostrar os dados de uma determinada medalha: lê um código de medalha.
//       Se não existir uma medalha com o código indicado, mostra a mensagem de erro: “6:Nenhuma medalha encontrada.”.
//       Se existir, mostra os dados da medalha no formato:
//       6:codigo,tipo,é individual?,modalidade

        int codigo = entrada.nextInt();
        entrada.nextLine();

        Medalha medalha = medalheiro.consultaMedalha(codigo);
        if (medalha != null)
            System.out.println("6: " + medalha.getCodigo() + ", " + medalha.getTipo() + ", " + medalha.getIndividual() + ", " + medalha.getModalidade());

        else
            System.out.println("6: Nenhum atleta encontrado.");
    }

    public void mostrarAtletaPorPais() {
//    7. Mostrar os dados dos atletas de um determinado país: lê o nome de um país.
//    Se não existir nenhum país com o nome indicado, mostra a mensagem de erro: “7:Pais nao encontrado.”.
//    Se existir, mostra os dados de cada atleta no formato:
//    7:número,nome,país

        String pais = entrada.nextLine();
        boolean encontrado = false;

        for (Atleta atleta : plantel.getAtletas()) {
            if (atleta.getPais().equalsIgnoreCase(pais)) {
                System.out.println("7: " + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("7:Pais nao encontrado.");
    }

    public void mostrarAtletaPorTipoMedalha() {
//    8. Mostrar os dados atletas de um determinado tipo de medalha: lê o tipo de uma medalha.
//    Se não houver nenhum atleta com o tipo de medalha indicado, mostra a mensagem de erro: “8:Nenhum atleta encontrado.”
//    caso contrário, mostra os dados de cada atleta no formato:
//    8:número,nome,país

        int tipo = entrada.nextInt();
        entrada.nextLine();

        boolean encontrado = false;
        for (Atleta atleta : plantel.getAtletas()) {
            for (Medalha medalha : atleta.getMedalhas()) {
                if (medalha.getTipo() == tipo) {
                    System.out.println("8: " + atleta.getNumero() + ", " + atleta.getNome() + ", " + atleta.getPais());
                    encontrado = true;
                }
            }
        }

        if (!encontrado)
            System.out.println("8: Nenhum atleta encontrado.");
    }

    public void mostrarAtletaPorModalidade() {
//    9. Mostrar os dados atletas de uma determinada modalidade: lê uma modalidade.
//    Se não houver a modalidade no sistema, mostra a mensagem de erro: “9:Modalidade não encontrada.”
//    Se uma medalha não tiver atleta, mostra uma mensagem no formato: 9:modalidade,tipo,Sem atletas com medalha.
//    Caso contrário, mostra os dados de cada atleta da medalha no formato: 9:modalidade,tipo,número,nome,país

        String modalidade = entrada.nextLine();
        ArrayList<Medalha> medalhasEncontradas = medalheiro.consultaMedalhas(modalidade);
        boolean encontrouAtleta = false;

        if (medalhasEncontradas == null || medalhasEncontradas.isEmpty()) {
            System.out.println("9: " + modalidade + ", Nenhum tipo de medalha encontrado.");
            return;
        }

        for (Medalha medalha : medalhasEncontradas) {
            ArrayList<Atleta> atletas = medalha.getAtletas();

            if (atletas.isEmpty())
                System.out.println("9:" + modalidade + "," + medalha.getTipo() + ",Sem atletas com medalha.");

            else {
                for (Atleta atleta : atletas) {
                    System.out.println("9:" + modalidade + "," + medalha.getTipo() + "," + atleta.getNumero() + "," + atleta.getNome() + "," + atleta.getPais());
                    encontrouAtleta = true;
                }
            }
        }

        if (!encontrouAtleta)
            System.out.println("9:" + modalidade + ",Sem atletas com medalha.");
    }

    public void MostrarAtletaComMaisMedalhas() {
//    10.Mostrar os dados do atleta com mais medalhas: localiza o atleta com maior número de medalhas.
//    Se não houver atletas com medalhas, mostra a mensagem de erro: “10:Nenhum atleta com medalha.”.
//    Caso contrário, mostra os dados do atleta e medalhas no formato:
//    10:número,nome,país,Ouro:quantidade,Prata:quantidade,Bronze:quantidade

        int max = 0;
        Atleta atletaMedalhado = null;

        if (plantel.getAtletas().isEmpty()) {
            System.out.println("10: Nenhum atleta com medalha.");
            return;
        }

        for (Atleta atleta : plantel.getAtletas()) {
            int total = atleta.getMedalhas().size();
            if (total > max) {
                max = total;
                atletaMedalhado = atleta;
            }
        }

        if (atletaMedalhado != null) {
            int ouro = atletaMedalhado.consultaQuantidadeMedalhas(1);
            int prata = atletaMedalhado.consultaQuantidadeMedalhas(2);
            int bronze = atletaMedalhado.consultaQuantidadeMedalhas(3);

            System.out.println("10: " + atletaMedalhado.getNumero() + ", " + atletaMedalhado.getNome() + ", " + atletaMedalhado.getPais() + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);

        }

        else
            System.out.println("10: Nenhum atleta com medalha.");
    }

    public void mostrarQuadroMedalhasPorPais() {
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
                    ouro += atleta.consultaQuantidadeMedalhas(1);
                    prata += atleta.consultaQuantidadeMedalhas(2);
                    bronze += atleta.consultaQuantidadeMedalhas(3);
                }
            }

            System.out.println("11: País: " + pais + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);
        }
    }

    public void mostrarQuadroMedalhasCompleto() {
        ArrayList<String> paises = new ArrayList<>();

        for (Atleta atleta : plantel.getAtletas()) {
            String pais = atleta.getPais();
            if (!paises.contains(pais))
                paises.add(pais);
        }

        for (String pais : paises) {
            int total = 0;
            System.out.println("\nPAÍS: " + pais);

            for (Atleta atleta : plantel.getAtletas()) {
                if (atleta.getPais().equals(pais)) {
                    int ouro = atleta.consultaQuantidadeMedalhas(1);
                    int prata = atleta.consultaQuantidadeMedalhas(2);
                    int bronze = atleta.consultaQuantidadeMedalhas(3);
                    total += ouro + prata + bronze;

                    System.out.println("12: Atleta: " + atleta.getNome() + ", Ouro: " + ouro + ", Prata: " + prata + ", Bronze: " + bronze);
                }
            }
            System.out.println("Total de Medalhas: " + total);
        }
    }
    
    // Redireciona E/S para arquivos
    // Chame este metodo para redirecionar a leitura e escrita de dados para arquivos
    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("dadosouts.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Restaura E/S padrao de tela(console)/teclado
    // Chame este metodo para retornar a leitura e escrita de dados para o padrao
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
}
