// classe que representa uma medalha da competição:
import java.util.ArrayList;

public class Medalha {

	private int codigo;
	private int tipo;
	private boolean individual; // medalha é individual (true) ou equipe (false)
	private String modalidade; // nome do esporte

	private ArrayList<Atleta> atletas; // Lista de atletas associadoa medalha

	public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.individual = individual;
		this.modalidade = modalidade;
		this.atletas = new ArrayList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public int getTipo() {
		return tipo;
	}

	public boolean getIndividual() {
		return individual;
	}

	public String getModalidade() {
		return modalidade;
	}

	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}

	// adiciona um atleta à medalha.
	public void adicionaAtleta(Atleta a) {
		atletas.add(a);
	}
}
