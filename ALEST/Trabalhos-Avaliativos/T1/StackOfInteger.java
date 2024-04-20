//  a) Apresente os métodos definidos a seguir para uma classe StackOfInterger que lida com números inteiros em um a
//  estrutura de pilha, considerando que os elementos da pilha devem ser armazenados em uma DoubleLinkedListOfInteger.
//  Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a pilha implementada, inclua
//  elementos e use o restante dos métodos implementados.

public class StackOfInteger {
    private DoubleLinkedListOfInteger list;

    public StackOfInteger() {
        list = new DoubleLinkedListOfInteger();
    }

    /**
     * Remove e retorna o elemento no topo da pilha.
     *
     * @return o elemento no topo da pilha, ou null se a pilha estiver vazia.
     */

    public Integer pop() {
        if (isEmpty())
            return null;
        return list.removeByIndex(list.size() - 1);
    }

    /**
     * Insere um elemento no topo da pilha.
     *
     * @param element o elemento a ser inserido na pilha.
     * @return o elemento inserido na pilha.
     */

    public Integer push(Integer element) {
        list.add(element);
        return element;
    }

    /**
     * Retorna o elemento no topo da pilha sem removê-lo.
     *
     * @return o elemento no topo da pilha, ou null se a pilha estiver vazia.
     */

    public Integer top() {
        if (isEmpty())
            return null;
        return list.get(list.size() - 1);
    }

    /**
     * Retorna o número de elementos na pilha.
     *
     * @return o número de elementos na pilha.
     */
    public int size() {
        return list.size();
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha estiver vazia, false caso contrário.
     */

    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Remove todos os elementos da pilha.
    public void clear() {
        list.clear();
    }

    /**
     * Método reverseArrayUsingStack()
     * Método estático que recebe um arranjo de inteiros e utiliza uma pilha implementada para inverter seu conteúdo
     *
     * @param array um arranjo de inteiros
     */


//    b) Construa o método estático abaixo seguindo as instruções dos comentários javadoc.
//    Este método recebe um arranjo de inteiros por parâmetro e utiliza uma instância da
//    pilha implementada para inverter o seu conteúdo. Chame este método main da classe App
//    para testar o seu funcionamento.

    /**
     * Método reverseArrayUsingStack()
     * Método estático que recebe um arranjo de inteiros e utiliza uma pilha implementada para inverter seu conteúdo
     * @param array arranjo inteiros
     * @return o arranjo de inteiros com os dados invertidos
     */

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

    // Método para converter a pilha em uma string (pra mostrar pro usuário)
    public static String stackToString(StackOfInteger stack) {
        StringBuilder sb = new StringBuilder();
        StackOfInteger tempStack = new StackOfInteger();

        // Copiando os elementos da pilha original para uma pilha temporária
        while (!stack.isEmpty()) {
            Integer element = stack.pop();
            sb.append(element).append(" | ");
            tempStack.push(element);
        }

        // Restaurando os elementos para a pilha original
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return sb.toString();
    }
}
