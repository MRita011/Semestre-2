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
	private Medalheiro medalheiro;
	private Plantel plantel;

	// Atributos para redirecionamento de E/S
	private Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
	private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
	private final String nomeArquivoEntrada = "entrada.txt";  // Nome do arquivo de entrada de dados
	private final String nomeArquivoSaida = "saida.txt";  // Nome do arquivo de saida de dados

	public ACMESports() {
		medalheiro = new Medalheiro();
		plantel = new Plantel();

		redirecionaES();    // Redireciona E/S para arquivos
	}

	public void executar() {
		cadastrarAtletas();
		cadastrarMedalhas();
		cadastrarMedalhasAtletasCorrespondentes();

		int numero = entrada.nextInt();
		mostrarAtleta(numero);

		String nome = entrada.nextLine();
		mostrarAtleta(nome);
	}

	public void cadastrarAtletas() {
//		lê todos os dados de cada atleta e, se o número não for repetido, cadastra-o no sistema.
//		Para cada atleta cadastrado com sucesso no sistema, mostra os dados do atleta no formato: 1:número,nome,país

//		No passo 1. Cadastrar atletas: cada linha corresponde ao número, nome e país de um atleta.
//		Quando o número lido for -1, não há mais atletas a serem cadastrados.

		System.out.println("\nCADASTRAR ATLETAS:\n");

		int numero;
		String nome;
		String pais;
		numero = entrada.nextInt();

		while(numero != (-1)) {
			nome = entrada.nextLine();
			pais = entrada.nextLine();

			Atleta a = new Atleta(numero, nome, pais);
			plantel.cadastraAtleta(a);

			if (plantel.cadastraAtleta(a))
				System.out.println("\nATLETA CADASTRADO(A): " + "\n1: Número: " + numero + ", nome: " + nome + ", País: " + pais);

			else
				System.out.println("\nAtleta não cadastrado(a)!!!!!!");

			numero = entrada.nextInt();
		}
	}

	public void cadastrarMedalhas() {
		System.out.println("\nCADASTRAR MEDALHAS:");

		int tipo;
		boolean individual;
		String modalidade;
		int codigo = entrada.nextInt();

		while(codigo != (-1)) {
			tipo = entrada.nextInt();
			individual = entrada.nextBoolean();
			modalidade = entrada.nextLine();

			Medalha m = new Medalha(codigo, tipo, individual, modalidade);

			if (medalheiro.cadastraMedalha(m))
				System.out.println("\n2: Código" + codigo + ", tipo: " + tipo + ", individual: " + individual + ", modalidade: " + modalidade);

			else
				System.out.print("\nMedalha não cadastrada!!!!!!");
		}
		codigo = entrada.nextInt();
	}

	public void cadastrarMedalhasAtletasCorrespondentes() {
		// percorre todos os atletas
		for (Atleta atleta : plantel.getAtletas()) {
			// percorre todas as medalhas
			for (Medalha medalha : medalheiro.getMedalhas()) {
				// se a medalha for do atleta
				if (atleta.getMedalhas().contains(medalha)) {
					// faz a associação da medalha com o atleta
					medalha.adicionaAtleta(atleta);
					atleta.adicionaMedalha(medalha);

					System.out.println("\n3: Código: " + medalha.getCodigo() + ", número: " + atleta.getNumero());
				}
			}
		}
	}

	public void mostrarAtleta(int numero) {
//		lê o número de um determinado atleta.
//		Se não existir um atleta com o número indicado, mostra a mensagem de erro: “4:Nenhum atleta encontrado.”
//		Se existir, mostra os dados do atleta no formato: 4:número,nome,país

		boolean encontrado = false;

		for (Atleta a : plantel.getAtletas()) {
			if (a.getNumero() == numero) {
				System.out.println("\n4: " + a.getNumero() + ", " + a.getNome() + ", " + a.getPais());
				encontrado = true;
				break;
			}
		}

		if (!encontrado)
			System.out.println("\n4: Nenhum atleta encontrado.");
	}

	public void mostrarAtleta(String nome) {
//		lê o nome de um determinado atleta.
//		Se não existir um atleta com o nome indicado, mostra a mensagem de erro: “5:Nenhum atleta encontrado.”
//		Se existir, mostra os dados do atleta no formato: 5:número,nome,país

		ArrayList<Atleta> atletas = plantel.consultaAtleta(nome);

		if (atletas.size() == 0) {
			System.out.println("5: Nenhum atleta encontrado");
		} else {
			for (Atleta a : atletas) {
				System.out.println("5: " + a.getNumero() + ", " + a.getNome() + ", " + a.getPais());
			}
		}
	}

/*	public void mostrarAtletaPorMedalhaCodigo() {
//		lê um código de medalha.
//		Se não existir uma medalha com o código indicado, mostra a mensagem de erro: “6:Nenhuma medalha encontrada.”
//		Se existir, mostra os dados da medalha no formato: 6:codigo,tipo,é individual?,modalidade

	}

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
