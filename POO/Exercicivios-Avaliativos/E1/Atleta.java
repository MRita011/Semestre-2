import java.util.ArrayList;

public class Atleta
{
    private int numero;
    private String nome;
    private String pais;
    private ArrayList<Medalha> medalhas;


    public Atleta(int numero, String nome, String pais) {
        this.numero = numero;
        this.nome = nome;
        this.pais = pais;
        this.medalhas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public ArrayList<Medalha> getMedalhas() {
        return medalhas;
    }

    public void adicionaMedalha(Medalha medalha) {
        medalhas.add(medalha);
    }

    public int consultaQuantidadeMedalhas(int tipo) {
        int quantidade = 0;

        for (Medalha medalha : medalhas) {
            if (medalha.getTipo() == tipo)
                quantidade++;
        }

        return quantidade;
    }

}

