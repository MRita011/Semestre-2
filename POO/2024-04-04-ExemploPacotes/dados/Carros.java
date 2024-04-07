package dados;

public class Carros implements Tributavel {
    private double preco;

    public Carros(double preco) {
        this.preco = preco;
    }

    @Override
    public double calculaImposto() {
        return preco * 0.5;
    }

    @Override
    public String toString() {
        return "Carros {" +
                "preco = " + preco +
                '}';
    }
}
