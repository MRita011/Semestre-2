public class Veiculo {
    public static final double TAXA = 0.3;
    private String placa;
    private double valor;

    public Veiculo(String placa, double valor) {
        this.placa = placa;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValor() {
        return valor;
    }

    /**
     * Calculo do valor do imposto IPVA
     * @return valor do IPVA
     */
    public double calculaIPVA() {
        return valor * TAXA;
    }

    /**
     * Gera string com a descricao do veiculo
     * @return descricao do veiculo
     */
    public String geraDescricao() {
        String descricao = "";
        descricao += "Placa: "+ placa + "\n";
        descricao += "Valor: " + valor + "\n";
        descricao += "Imposto: "+ calculaIPVA() + "\n";
        return descricao;
    }

}
