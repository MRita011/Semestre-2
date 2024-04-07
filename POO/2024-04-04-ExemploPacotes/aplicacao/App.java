package aplicacao;
import dados.*;

import java.util.ArrayList;

public class App
{
    public void executar() {
//        System.out.println("Executando...");

        Pedidos pedido = new Pedidos(111.11);
        System.out.println("Valor: " + pedido.getValor());

        PedidoEspecial pe = new PedidoEspecial(222.22, 33.33);
        System.out.println("Valor PE: " + pe.getValor());

        pedido = pe; // polimorfismo (classes)
        if (pedido instanceof PedidoEspecial)
            System.out.println("Bonus: " + ((PedidoEspecial)pedido).getBonus()); // cast para forçar o pedido em um PedidoEspecial

        Tributavel t;
        t = pe; // polimorfismo de interface
        System.out.println("Imposto: " + t.calculaImposto()); // calcula imposto do ProdutoEspecial

        ArrayList<Tributavel> tributaveis;
        tributaveis = new ArrayList<>();

        // Polimorfismo de interface
        tributaveis.add(new Carros(100000.00));
        tributaveis.add(new PedidoEspecial(333.33, 3.3));
        tributaveis.add(new Carros(200000.00));
        tributaveis.add(new Carros(300000.00));
        tributaveis.add(new PedidoEspecial(444.44, 3.3));

        for (Tributavel tr : tributaveis) {
            System.out.println(tr.toString());
        }
    }
}
