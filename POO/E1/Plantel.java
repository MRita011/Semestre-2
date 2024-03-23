// classe catálogo que gerencia o cadastro de atletas:

import java.util.ArrayList;
import java.util.Collection;

public class Plantel 
{
	private ArrayList<Atleta> atletas;

	public Plantel() {
		atletas = new ArrayList<Atleta>();
	}

	// recebe como parâmetro um novo Atleta e o cadastra no sistema.
	// não pode haver atletas com o mesmo número.
	// retorna true se o cadastro teve sucesso; ou false em caso contrário.

	public boolean cadastraAtleta(Atleta atleta) {
		for (Atleta a : atletas) {
			if (a.getNumero() == atleta.getNumero()) {
				return false; // Já existe um atleta com o mesmo número
			}
		}
		atletas.add(atleta);
		return true; // Cadastro bem-sucedido
	}

	// retorna o atleta com o nome indicado.
	// Se não houver nenhum atleta com este nome retorna null.

	public Atleta consultaAtleta(String nome) {
		for (Atleta a : atletas) {
			if (a.getNome().equals(nome))
				return a;
		}
		return null;
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
