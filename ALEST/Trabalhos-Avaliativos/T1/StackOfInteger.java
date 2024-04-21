//  a) Apresente os métodos definidos a seguir para uma classe StackOfInterger que lida com números inteiros em um a
//  estrutura de pilha, considerando que os elementos da pilha devem ser armazenados em uma DoubleLinkedListOfInteger.
//  Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a pilha implementada, inclua
//  elementos e use o restante dos métodos implementados.

public class StackOfInteger 
{
    private DoubleLinkedListOfInteger pilha;

    public StackOfInteger() {
        pilha = new DoubleLinkedListOfInteger();
    }

    public Integer pop() {
        if (isEmpty())
            return null;
        return pilha.removeByIndex(pilha.size() - 1);
    }

    public Integer push(Integer element) {
        pilha.add(element);
        return element;
    }

    public Integer top() {
        if (isEmpty())
            return null;

        return pilha.get(pilha.size() - 1);
    }

    public int size() {
        return pilha.size();
    }

    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    public void clear() {
        pilha.clear();
    }

//    b) Construa o método estático abaixo seguindo as instruções dos comentários javadoc.
//    Este método recebe um arranjo de inteiros por parâmetro e utiliza uma instância da
//    pilha implementada para inverter o seu conteúdo. Chame este método main da classe App
//    para testar o seu funcionamento.

    public static void reverseArrayUsingStack(int[] array) {
        StackOfInteger stack = new StackOfInteger();

        // Empilha todos os elementos do array
        for (int num : array) {
            stack.push(num);
        }

        // Desempilha os elementos e bota de volta no array (inversão)
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static String stackToString(StackOfInteger pilha) {
        StringBuilder sb = new StringBuilder();
        StackOfInteger copia = new StackOfInteger();

        while (!pilha.isEmpty()) {
            Integer element = pilha.pop();
            sb.append(element).append(" | ");
            copia.push(element);
        }

        while (!copia.isEmpty()) {
            pilha.push(copia.pop());
        }
        return sb.toString();
    }
}
