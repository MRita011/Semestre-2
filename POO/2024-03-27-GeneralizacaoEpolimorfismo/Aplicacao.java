import java.util.Scanner;

public class Aplicacao {
    private Frota frota;
    private Scanner entrada;

    public Aplicacao() {
        frota = new Frota();
        entrada = new Scanner(System.in);
    }

    /**
     * Inclui alguns objetos para testes
     */
    public void inicializa() {
        Veiculo v;
        v= new Veiculo("AAA-1A11",50000.00);
        frota.addVeiculo(v);

        v= new Veiculo("BBB-2B22",100000.00);
        frota.addVeiculo(v);

        v = new VeiculoEletrico("CCC-3C33", 30000, 333);
        frota.addVeiculo(v);
    }

    /**
     * Execucao da aplicacao
     */
    public void executa() {
        int opcao = 0;
        do {
            System.out.println("===================");
            System.out.println("Opcoes:");
            System.out.println("[0] Sair");
            System.out.println("[1] Consulta por placa");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    consultaPorPlaca();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while(opcao != 0);
    }

    /**
     * Consulta um veiculo pela placa
     */
    private void consultaPorPlaca() {
        System.out.println("===================");
        System.out.print("Digite a placo do veiculo: ");
        String placa = entrada.nextLine();
        Veiculo f = frota.pesquisaPlaca(placa);
        if(f == null)
            System.out.println("Erro. Nao ha veiculo com esta placa.");
        else {
            System.out.println(f.geraDescricao());
        }
    }

}
