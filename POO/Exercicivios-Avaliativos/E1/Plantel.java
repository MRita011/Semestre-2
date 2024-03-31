import java.util.ArrayList;

public class Plantel
{
	private final ArrayList<Atleta> atletas;

	public Plantel() {
		atletas = new ArrayList<>();
	}

	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}

	// recebe como parâmetro um novo Atleta e o cadastra no sistema.
	// não pode haver atletas com o mesmo número.
	// retorna true se o cadastro teve sucesso; ou false em caso contrário.

	public boolean cadastraAtleta(Atleta a) {
		if(consultaAtleta(a.getNumero()) == null) {
			atletas.add(a);
			return true;
		}
		return false;
	}

	// retorna o atleta com o nome indicado.
	// Se não houver nenhum atleta com este nome retorna null.

	public Atleta consultaAtleta(String nome) {
		if (!atletas.isEmpty()) {
			for (int i = 0; i < atletas.size(); i++) {
				Atleta a = atletas.get(i);

				if (a.getNome().equalsIgnoreCase(nome))
					return a;
			}
		}
		return null;
	}

	// retorna o atleta com o número indicado.
	// Se não houver nenhum atleta com este número retorna null.

	public Atleta consultaAtleta(int numero) {
		if(!atletas.isEmpty()) {
			for (int i = 0; i < atletas.size(); i++) {
				Atleta a = atletas.get(i);

				if (a.getNumero() == numero)
					return a;
			}
		}
		return null;
	}
}
