import java.util.ArrayList;

public class Medalha
{
    private int codigo;
    private int tipo;
    private boolean individual;
    private String modalidade;
    private ArrayList<Atleta> medalhas;

    public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.individual = individual;
        this.modalidade = modalidade;
        this.medalhas = new ArrayList<Atleta>();
    }

    public int getCodigo() {
        return codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public boolean getIndividual() {
        return individual;
    }

    public String getModalidade() {
        return modalidade;
    }

    public ArrayList<Atleta> getMedalhas() {
        return medalhas;
    }

    public void adicionaAtleta(Atleta atleta) {
        medalhas.add(atleta);
    }

    public ArrayList<Atleta> getAtletas() {
        return medalhas
                ;
    }

}
