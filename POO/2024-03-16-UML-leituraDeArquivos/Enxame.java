import java.util.ArrayList;

public class Enxame {
    private ArrayList<Robo> robos;

    public Enxame() {
        robos = new ArrayList<Robo>();
    }

    // --------- CREATE --------- //

    public boolean adicionaRobo(Robo r) { // Recebe como parâmetro um novo robô e cadastra-o no sistema.
        if (consultaRobo(r.getModelo()) == null) { // Não pode haver robôs com o mesmo modelo. 
            robos.add(r);
            System.out.println("Robô adicionado com sucesso!");
            return true; // Retorna true se o cadastro teve sucesso;
        }

        else {
            System.out.println("Já existe um robô com o modelo " + r.getModelo() + ".");
            return false; //  ou false em caso contrário.
        }
    }

    // --------- RETRIEVE --------- //

    public Robo consultaRobo(String modelo) { 
        if (!robos.isEmpty()) { // Verifica se o arraylst está vazio
            for (int i = 0; i < robos.size(); i++) {
                Robo r = robos.get(i);

                if (r.getModelo().equals(modelo))
                    return r; // Retorna o robô com o modelo indicado. 
            }
        }
        return null; // Não há robôs deste modelo
    }

    public double calculaSomatorio() { // Retorna o somatório dos valores de todos os robôs cadastrados no sistema.
        double somatorio = 0.0;

        for (int i = 0; i < robos.size(); i++) {
            Robo r = robos.get(i);
            somatorio += r.getValor();
        }
        return somatorio;
    }
}
