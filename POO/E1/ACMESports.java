
// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMESports
{
	private Medalheiro medalheiro;
	private Plantel plantel;

// Atributos para redirecionamento de E/S
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

		mostrarAtletaPorNumero();
		mostrarAtletaPorNome();
		mostrarAtletaPorMedalhaCodigo();
		mostrarAtletaPorPais();
		mostrarAtletaPorTipo();
		mostrarAtletaPorModalidade();
		mostrarAtletaComMaisMedalhas();
	}

	public void cadastrarAtletas() {
//		lê todos os dados de cada atleta e, se o número não for repetido, cadastra-o no sistema.
//		Para cada atleta cadastrado com sucesso no sistema, mostra os dados do atleta no formato: 1:número,nome,país

		bw.write("\nCADASTRAR ATLETAS:\n");

		int numero = entrada.nextInt();
		entrada.nextLine(); // consome a linha
		String nome = entrada.nextLine();
		String pais = entrada.nextLine();

		Atleta a = new Atleta(numero, nome, pais);

		if (plantel.cadastraAtleta(a)) {
			bw.write("1: " + numero + ", " + nome + ", " + pais); // escreve no dadosout
			bw.newLine(); // "quebra linha"
		}

		else {
			bw.write("\nFalha ao cadastrar o atleta com número " + numero);
			bw.newLine();
		}
	}

	public void cadastrarMedalhas() {
//		lê todos os dados de cada medalha e, se o código não for repetido, cadastra-a no sistema.
//		Para cada medalha cadastrada com sucesso no sistema, mostra os dados da medalha no formato:
//		2:codigo,tipo,é individual?,modalidade

		bw.write("\nCADASTRAR MEDALHAS:\n");

		int codigo = entrada.nextInt();
		int tipo = entrada.nextInt();
		boolean individual = entrada.nextBoolean();
		String modalidade = entrada.nextLine();

		Medalha m = new Medalha(codigo, tipo, individual, modalidade);

		if (medalheiro.cadastraMedalha(m)) {
			bw.write("2: " + codigo + ", " + tipo + ", " + individual + ", " + modalidade);
			bw.newLine();
		}

		else {
			bw.write("Falha ao cadastrar a medalha com código " + codigo);
			bw.newLine();
		}
	}

	public void cadastrarMedalhasAtletasCorrespondentes() {
//		adiciona uma medalha para cada atleta e vice-versa.
//		Para cada cadastramento com sucesso mostra os dados no formato: 3:código,número

		bw.write("\nCADASTRAR MEDALHA DO ATLETA:\n");

		for (Atleta a : plantel.getAtletas()) {
			Medalha m = new Medalha();

			// Cadastrar a medalha no sistema
			if (medalheiro.cadastraMedalha(m)) {
				m.adicionaAtleta(a); // Adicionar o atleta à medalha

				bw.write("3: " + m.getCodigo() + ", " + a.getNumero());
				bw.newLine();
			}

			else {
				bw.write("Falha ao cadastrar a medalha para o atleta com número " + a.getNumero());
				bw.newLine();
			}
		}
	}

	public void mostrarAtletaPorNumero() {
//		lê o número de um determinado atleta.
//		Se não existir um atleta com o número indicado, mostra a mensagem de erro: “4:Nenhum atleta encontrado.”
//		Se existir, mostra os dados do atleta no formato: 4:número,nome,país

	}

	public void mostrarAtletaPorNome() {
//		lê o nome de um determinado atleta.
//		Se não existir um atleta com o nome indicado, mostra a mensagem de erro: “5:Nenhum atleta encontrado.”
//		Se existir, mostra os dados do atleta no formato: 5:número,nome,país

	}

	public void mostrarAtletaPorMedalhaCodigo() {
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

	}
	private void redirecionaES() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader(dadosin.txt));
			entrada = new Scanner(streamEntrada);
			PrintStream streamSaida = new PrintStream(new File(dadosout.txt), Charset.forName("UTF-8"));
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
