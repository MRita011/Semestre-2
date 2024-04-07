package dados;

public class PedidoEspecial extends Pedidos implements Tributavel // subclasse que implementa uma interface
{
    private double bonus;

    public PedidoEspecial(double valor, double bonus) {
        super(valor); // chama o valor da super classe
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getValor() {
        return super.getValor() - bonus;
    }

    @Override
    public double calculaImposto() {
        return getValor() * 0.4;
    }

    @Override
    public String toString() {
        return "PedidoEspecial {" +
                "valor = " + getValor() +
                ", bonus = " + bonus +
                '}';
    }
}


