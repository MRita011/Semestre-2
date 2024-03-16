
import java.util.ArrayList;

public class Loja {
    private ArrayList<Produto> produtos;

    public Loja() {
        produtos = new ArrayList<Produto>();
    }

    // CRUD

    // C-Create - cadastrar
    public void cadastrarProduto(Produto p) {
        produtos.add(p);
    }

    // R-Retrieve - consultar
    // Retorna um produto com o nome indicado,
    // senao retorna null
    public Produto consultarPorNome(String nome) {
        if(!produtos.isEmpty()) {
            for(int i=0; i<produtos.size() ;i++) {
                Produto p = produtos.get(i);
                if(p.getNome().equals(nome))
                    return p;
            }
        }
        return null;
    }

    public Produto consultarPorAno(int ano) {
        if(!produtos.isEmpty()) {
            for(int i = 0; i< produtos.size() ; i++) {
                Produto p = produtos.get(i);
                if(p.getAno() == ano)
                    return p;
            }
        }
        return null;
    }

    public void removerProdutoPeloAno(int ano) {
        Produto produtoParaRemover = consultarPorAno(ano);

        if (produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
        }
    }
}
