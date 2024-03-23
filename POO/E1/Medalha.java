// classe que representa uma medalha da competição:

public class Medalha {

	private int codigo;
	private int tipo;
	private boolean individual; // medalha é individual (true) ou equipe (false)
	private String modalidade; // nome do esporte
	private ArrayList<Atleta> atletas; // Lista de atletas associadoa medalha

	public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
		codigo = this.codigo;
		tipo = this.tipo;
		individual = this.individual;
		modalidade = this.modalidade;
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
		a.adicionaMedalha(this); // this: medalha atual
	}
}
