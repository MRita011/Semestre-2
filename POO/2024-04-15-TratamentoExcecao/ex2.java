//Neste código há situações que podem gerar exceções.
//Identifique-as e recodifique para o tratamento de possíveis exceções, com mensagens coerentes para cada exceção.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String args[]) {
        int a = 0, b = 0, c = 0;
        double d = 0;
        double e[];

        e = new double[10];
        Scanner sc = new Scanner(System.in);
        boolean ok = false;

        while (!ok) {
            System.out.print("Valor de a: ");
            
            try {
                a = sc.nextInt(); // 1º lugar onde pode dar erro
                ok = true; // encerra o loop
            }

            catch (InputMismatchException e1) {
                sc.nextLine(); // limpa o Scanner e evita o loop
                System.out.println("Valor inválido!");
            }
        }

        
        while (!ok) {
            System.out.print("Valor de b: ");
            
            try {
                
            }
        }

        b = sc.nextInt();

        c = a / b;

        d = e[a];

        System.out.println("Valor de a/b: " + c);
        System.out.println("Valor no vetor: " + d);
    }
}
