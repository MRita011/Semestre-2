public class VeiculoEletrico extends Veiculo {
    private double cargaBateria;

    public VeiculoEletrico(String placa, double valor, double cargaBateria) {
        super(placa, valor);
        this.cargaBateria = cargaBateria;
    }

    @Override
    public double calculaIPVA() {
        return 0.0;
    }

    @Override
    public String geraDescricao() {
        String descricao = super.geraDescricao(); // variavel aux
        descricao = descricao + "Carga da bateria: " + cargaBateria;
        return descricao;

    }
}
