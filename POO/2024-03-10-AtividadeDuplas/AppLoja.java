import java.util.Scanner;

public class AppLoja 
{
    private Loja loja;
    private Scanner entrada;

    public AppLoja() {
        loja = new Loja();
        entrada = new Scanner(System.in);
    }

    public void executar() {
        System.out.println("\fIniciando a execucao...");
        menu();
        
        int opcao = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println("====================================");
        
        while(opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                    
                case 2:
                    consultarProdutoPeloNome();
                    break;
                    
                case 3:
                    removerProdutoPeloAno();
                    break;
                    
                case 0:
                    break;
                    
                case 99:
                    easterEgg();
                    break;
                default:
                    System.out.println("Opcao invalida. Redigite.");
            }
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            System.out.println("====================================");
        }
        System.out.println("Fim da execucao...");
    }

    private void menu() {
        System.out.println("====================================");
        System.out.println("Opcoes:");
        System.out.println("[1] Cadastrar um produto");
        System.out.println("[2] Consultar um produto pelo nome");
        System.out.println("[3] Remover produtos pelo ano");
        System.out.println("[0] Sair");
        System.out.print("Digite a opcao desejada: ");
    }

    private void cadastrarProduto() {
        System.out.println("CADASTRAR UM PRODUTO");
        System.out.print("Digite o nome do produto: ");
        String nome = entrada.nextLine();
        
        System.out.print("Digite o valor do produto: ");
        double valor = entrada.nextDouble();
        
        System.out.print("Digite o ano do produto: ");
        int ano = entrada.nextInt();
        entrada.nextLine();
        
        Produto produto = new Produto(nome, valor, ano);
        loja.cadastrarProduto(produto);
        System.out.println("Produto cadastrado!");
    }

    private void consultarProdutoPeloNome() {
        System.out.println("CONSULTAR Produto POR NOME");
        
        System.out.print("Digite o nome do Produto: ");
        String nome = entrada.nextLine();
        
        Produto produto = loja.consultarPorNome(nome);
        if(produto == null)
            System.out.println("Nenhum produto encontrado com este nome.");
            
        else {
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Valor do produto: " + produto.getValor());
            System.out.println("Ano do produto: " + produto.getAno());
        }
    }

    private void removerProdutoPeloAno() {
        System.out.println("REMOVER PRODUTOS PELO ANO");
        
        System.out.print("Digite o ano dos produtos que deseja remover: ");
        int ano = entrada.nextInt();
        entrada.nextLine();
        
        loja.removerProdutoPeloAno(ano);
        System.out.println("Produtos removidos com sucesso!");
    }

    private void easterEgg() {
        System.out.println("Easter egg!");
        Produto produto = new Produto("Computador", 5000.0, 2024);
        loja.cadastrarProduto(produto);
        produto = new Produto("Celular", 3000.0, 2022);
        loja.cadastrarProduto(produto);
        produto = new Produto("Access point", 3000.0, 2024);
        loja.cadastrarProduto(produto);
        produto = new Produto("TV", 5000.0, 2024);
        loja.cadastrarProduto(produto);
    }
}
