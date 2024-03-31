// classe que representa um atleta da competição:
import java.util.ArrayList;

public class Atleta
{
	private int numero;
	private String nome;
	private String pais;
	private int quant;

	private ArrayList<Medalha> medalhas;

	public Atleta(int numero, String nome, String pais) {
		this.numero = numero;
		this.nome = nome;
		this.pais = pais;
		this.medalhas = new ArrayList<>();
		quant = 0;
	}

	public ArrayList<Medalha> getMedalhas() {
		return medalhas;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}
	// adiciona uma nova medalha ao atleta

	public void adicionaMedalha(Medalha m) {
		medalhas.add(m);
	}

//	retorna a quantidade de medalhas do atleta
	public int consultaQuantidadeMedalha() {
		quant = medalhas.size();
		return quant;
	}

	public int quantidadeMedalhasTipo(int tipo) {
		int quantidade = 0;

		for (Medalha medalha : medalhas) {
			if (medalha.getTipo() == tipo)
				quantidade++;
		}
		return quantidade;
	}
}
