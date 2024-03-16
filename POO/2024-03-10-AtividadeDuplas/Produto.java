public class Produto 
{
    private String nome;
    private double valor;
    private int ano;

    public Produto(String nome, double valor, int ano) {
        this.nome = nome;
        this.valor = valor;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Produto{" +
        "nome='" + nome + '\'' +
        ", valor=" + valor +
        ", ano=" + ano +
        '}';
    }
}
