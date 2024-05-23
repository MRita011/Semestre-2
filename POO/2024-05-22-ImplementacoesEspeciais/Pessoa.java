public class Pessoa {
    private String nome;
    private Nascimento nascimento;

    public Pessoa(String nome, Nascimento nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nascimento getNascimento() {
        return nascimento;
    }

    public void setNascimento(Nascimento nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Pessoa { nome = '" + nome + "', nascimento = " + nascimento + " }";
    }
}

class Nascimento {
    private int dia;
    private int mes;
    private int ano;

    public Nascimento(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
