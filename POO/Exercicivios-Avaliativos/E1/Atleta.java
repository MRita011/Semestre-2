// classe que representa um atleta da competição:
import java.util.ArrayList;

public class Atleta
{
	private int numero;
	private String nome;
	private String pais;

	private ArrayList<Medalha> medalhas; // Lista de medalhas do atleta

	public Atleta(int numero, String nome, String pais) {
		this.numero = numero;
		this.nome = nome;
		this.pais = pais;
		this.medalhas = new ArrayList<>();
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

	public ArrayList<Medalha> getMedalhas() {
		return medalhas;
	}

// adiciona uma nova medalha ao atleta
	public void adicionaMedalha(Medalha m) {
		medalhas.add(m);
	}

//	retorna a quantidade de medalhas do atleta
	public int consultaQuantidadeMedalha() {
		int quant = medalhas.size();
		return quant;
	}
}
