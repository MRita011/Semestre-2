import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> produtos;

    public Loja() {
        produtos = new ArrayList<Produto>(); // inicializa o Arraylist
    }

    // CRUD
    // C-Create - cadastrar
    public void cadastrarProduto(Produto p) {
        produtos.add(p); // adiciona ao arraylist

    }

    // R - Retrieve - consultar
    public Produto consultarPorNome(String nome) { // retornar o produto do nome indicado, senão retorna null
        if (!produtos.isEmpty()) {
            for (int i = 0; i < produtos.size(); i++) {
                Produto p = produtos.get(i);

                if (p.getNome().equals(nome))
                    return p;
            }
        }
        return null; //não achou nadann
    }
}
