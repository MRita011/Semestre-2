import java.util.ArrayList;

public class Medalheiro
{
    private ArrayList <Medalha> medalhas;

    public Medalheiro() {
        medalhas = new ArrayList<>();
    }

    public ArrayList<Medalha> getMedalhas() {
        return medalhas;
    }

    //  Recebe como parâmetro uma nova medalha e a cadastra no sistema.
    // 	Não pode haver medalhas com o mesmo código.
    // 	Retorna true se o cadastro teve sucesso; ou false em caso contrário

    public boolean cadastraMedalha(Medalha medalha) {
        if (consultaMedalha(medalha.getCodigo()) != null) {
            return false;
        }

        medalhas.add(medalha);
        return true;
    }

    //	Retorna a medalha com o código indicado.
    // 	Se não houver medalha com este código retorna null.

    public Medalha consultaMedalha(int codigo) {
        if (!medalhas.isEmpty()) {
            for (Medalha medalha : medalhas) {
                if(medalha.getCodigo() == codigo)
                    return medalha;
            }
        }
        return null;
    }

    //	Retorna uma coleção de medalhas com a modalidade indicada.
    // 	Se não houver nenhuma medalha com esta modalidade retorna null.

    public ArrayList<Medalha> consultaMedalhas(String modalidade) {
        ArrayList<Medalha> medalhasEncontradas = new ArrayList<>();

        if (!medalhas.isEmpty()) {
            for (Medalha medalha : medalhas) {
                if (medalha.getModalidade().equalsIgnoreCase(modalidade)) {
                    medalhasEncontradas.add(medalha);
                }
            }
        }

        if (medalhasEncontradas.isEmpty()) {
            return null;
        }
        
        return medalhasEncontradas;
    }
}
