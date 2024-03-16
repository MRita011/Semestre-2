/* 1) Realiza a entrada de dados:
 * Se houver parâmetros do sistema operacional (String[] args), deve haver 3 parâmetros: 
     * o primeiro deve ser o dividendo, 
     * o segundo deve ser o divisor 
     * o terceiro deve ser a precisão.
 
 * Se não houver parâmetros do sistema operacional, deve-se solicitar ao usuário que digite os valores do dividendo, divisor e precisão.
 
 * 2) Realiza o cálculo da divisão, se os dados de entrada estiverem corretos.
 * 3) Apresenta o resultado da divisão. Se houve dados de entrada inválidos ou cálculo nulo, apresenta a mensagem: "Não foi possível realizar a divisão".
*/

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int dividendo, divisor, precisao;

        if (args.length == 3) {
            // Se houver parâmetros do sistema operacional
            dividendo = Integer.parseInt(args[0]);
            divisor = Integer.parseInt(args[1]);
            precisao = Integer.parseInt(args[2]);
        } 
        
        else {
            // Se não houver parâmetros do sistema operacional, solicita ao usuário
            Scanner in = new Scanner(System.in);

            System.out.print("\fDigite o dividendo: ");
            dividendo = in.nextInt();

            System.out.print("\nDigite o divisor: ");
            divisor = in.nextInt();

            System.out.print("\nDigite a precisão: ");
            precisao = in.nextInt();
        }

        // Realiza o cálculo da divisão
        String resultado = Matematica.realizarDivisao(dividendo, divisor, precisao);

        // Apresenta o resultado da divisão ou uma mensagem de erro
        if (resultado != null) 
            System.out.println("\nResultado da divisão: " + resultado);
            
        else 
            System.out.println("\nNão foi possível realizar a divisão.");
    }
}
