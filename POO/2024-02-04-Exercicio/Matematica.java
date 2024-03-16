/* Desenvolva um sistema que possua pelo menos 2 classes: Matematica e Main. 

 * Na classe Matematica deve haver um método de classe (static) que recebe 3 parâmetros: dividendo (inteiro), divisor (inteiro), precisao (inteiro). 
 * Este método retorna uma String com o resultado da divisão do dividendo pelo divisor, com tantas casas decimais significativas quanto a precisão. 
 * Se a divisão não for possível, retorna null.
 * Exemplo 1: dividendo: 10, divisor: 4, precisão: 10, string de retorno: "2.5"
 * Exemplo 2: dividendo: 10, divisor: 0, precisão: 10, string de retorno: null
 * Exemplo 3: dividendo: 100, divisor: 3, precisão: 20, string de retorno: "33.33333333333333333333"
 */

/* Desenvolva um sistema que possua pelo menos 2 classes: Matematica e Main. 

 * Na classe Matematica deve haver um método de classe (static) que recebe 3 parâmetros: dividendo (inteiro), divisor (inteiro), precisao (inteiro). 
 * Este método retorna uma String com o resultado da divisão do dividendo pelo divisor, com tantas casas decimais significativas quanto a precisão. 
 * Se a divisão não for possível, retorna null.
 * Exemplo 1: dividendo: 10, divisor: 4, precisão: 10, string de retorno: "2.5"
 * Exemplo 2: dividendo: 10, divisor: 0, precisão: 10, string de retorno: null
 * Exemplo 3: dividendo: 100, divisor: 3, precisão: 20, string de retorno: "33.33333333333333333333"
 */

public class Matematica 
{
    public static String realizarDivisao(int dividendo, int divisor, int precisao) {
        if (divisor == 0) 
            return null; // divisão por zero não é possível

        if (precisao < 0) 
            return null; // a precisão não pode ser menor que zero

        int quociente = dividendo/divisor; // pega a parte inteira da divisão
        int resto = dividendo%divisor;

        StringBuilder resultado = new StringBuilder(String.valueOf(quociente)); // obj para concatenar o resultado

        if (precisao > 0) {
            resultado.append("."); // adicionando ponto decimal ao final do StringBuilder
            int contador = 0; // controlando a quantidade de digitos apos o ponto decimal

            while (contador < precisao) { // laço para continuar adicionando digitos apos o ponto
                resto *= 10; // resultado * 10
                int digito = resto/divisor; // prox. digito apos o ponto
                resultado.append(digito); // concatena
                resto %= divisor; // resto%divisor
                contador++; // att o contador
            }
        }
        return resultado.toString();
    }
}
