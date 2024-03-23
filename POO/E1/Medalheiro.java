import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ArrayList;

// classe catálogo que gerencia o cadastro de medalhas:
public class Medalheiro {
	private ArrayList<Medalha> medalhas;

	public Medalheiro() {
		medalhas = new ArrayList<Medalha>();
	}

	/*  Recebe como parâmetro uma nova medalha e a cadastra no sistema.
		Não pode haver medalhas com o mesmo código.
		Retorna true se o cadastro teve sucesso; ou false em caso contrário
	*/

	public boolean cadastraMedalha(Medalha m) {
		if (consultaMedalha(m.getCodigo()) != null) {
			return false;
		}
		medalhas.add(m);
		return true;
	}

	/*  Retorna a medalha com o código indicado.
		Se não houver medalha com este código retorna null.
	*/
	public Medalha consultaMedalha(int codigo) {
		for (Medalha m : medalhas) {
			if (m.getCodigo() == codigo)
				return m;
		}
		return null;
	}

	/*	Retorna uma coleção de medalhas com a modalidade indicada.
		Se não houver nenhuma medalha com esta modalidade retorna null.
	*/
	public ArrayList<Medalha> consultaMedalhas(String modalidade) {
		ArrayList<Medalha> medalhasModalidade = new ArrayList<>();

		for (Medalha m : medalhas) {
			if (m.getModalidade().equals(modalidade))
				medalhasModalidade.add(m);
		}

			if (!medalhasModalidade.isEmpty())
				return medalhasModalidade;

		return null; // "lista" nula//
	}
}
