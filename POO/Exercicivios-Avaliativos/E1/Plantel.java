import java.util.ArrayList;

public class Plantel 
{
	private ArrayList<Atleta> atletas;

	public Plantel() {
		atletas = new ArrayList<Atleta>();
	}

	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}

	// recebe como parâmetro um novo Atleta e o cadastra no sistema.
	// não pode haver atletas com o mesmo número.
	// retorna true se o cadastro teve sucesso; ou false em caso contrário.

	public boolean cadastraAtleta(Atleta a) {
		for (Atleta atleta : atletas) {
			if (a.getNumero() == atleta.getNumero()) {
				return false; // Já existe um atleta com o mesmo número
			}
		}
		atletas.add(a);
		return true; // Cadastro bem-sucedido
	}

	// retorna o atleta com o nome indicado.
	// Se não houver nenhum atleta com este nome retorna null.

	public Atleta consultaAtleta(String nome) {
		for (Atleta a : atletas) {
			if (a.getNome().equalsIgnoreCase(nome))
				return a;
		}
		return null; // Retorna null se o atleta não for encontrado
	}

	// retorna o atleta com o número indicado.
	// Se não houver nenhum atleta com este número retorna null.

	public Atleta consultaAtleta(int numero) {
		for (Atleta a : atletas) {
			if (a.getNumero() == numero)
				return a;
		}
		return null;
	}
}
