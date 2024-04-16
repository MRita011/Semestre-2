public class Exercicio1 {


    public static void main(String args[]) {

        try {

            int i = getAlgo(); // ponto que volta

            System.out.println("Tudo certo"); // não aparece/executa

        } catch (IndexOutOfBoundsException e1) {

            System.out.println("Excecao 1");

        } catch (Exception e2) { // cai aqui

            System.out.println("Excecao 2"); // SOUT

        } finally {

            System.out.println("Mais nada"); // SOUT em todos os casos

        }

        System.out.println("Adeus"); // SOUT tambem

    }


    public static int getAlgo() {

        if (true)

            throw new IllegalArgumentException(); // não tem  try catch. Ele vai pra quem chamou

        else

            return 0;

    }


}
