// Robo: classe que representa um robô criado na empresa:
// o métodos get: retornam os valores dos atributos correspondentes

public class Robo 
{
    private String modelo;
    private double valor;

    public Robo(String modelo, double valor) {
        this.modelo = modelo;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nROBO" +
                "\nModelo: " + modelo +
                "\nValor: " + valor;
    }
}
