//  a) Apresente os métodos definidos a seguir para uma classe QueueOfInterger que lida com números inteiros
//  em um estrutura de fila, considerando que os elementos da fila devem ser armazenados em uma DoubleLinkedListOfInteger.
//  Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a fila implementada, inclua elementos
//  e use o restante dos métodos implementados.

public class QueueOfInterger {
    private DoubleLinkedListOfInteger fila;

    public QueueOfInterger() {
        fila = new DoubleLinkedListOfInteger();
    }

    // Adiciona um elemento à fila
    public void enqueue(Integer element) {
        fila.addLast(element);
    }

    // Remove e retorna o elemento na frente da fila
    public Integer dequeue() {
        if (isEmpty()) {
            return null; // Se a fila estiver vazia, retorna null
        }
        return fila.removeFirst();
    }

    // Retorna o elemento na frente da fila sem removê-lo
    public Integer head() {
        if (isEmpty()) {
            return null; // Se a fila estiver vazia, retorna null
        }
        return fila.getFirst();
    }

    // Retorna o tamanho da fila
    public int size() {
        return fila.size();
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    // Remove todos os elementos da fila
    public void clear() {
        fila.clear();
    }

    public static String queueToString(QueueOfInterger queue) {
        StringBuilder sb = new StringBuilder();
        QueueOfInterger temp = new QueueOfInterger();

        // Copiando os elementos da fila original para uma fila temporária
        while (!queue.isEmpty()) {
            Integer element = queue.dequeue();
            sb.append(element).append(" | ");
            temp.enqueue(element);
        }

        // Restaurando os elementos para a fila original
        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }

        return sb.toString();
    }

//  b) Implemente um método que transforma que usa a lógica de fila de prioridades,
//  onde um elemento inserido na filadeve ser posicionado de acordo com o seu valor. A ordem deve ser

    /**
     * Método enqueuePriority()
     * Recebe como parâmetro um elemento que deve ser inserido na fila de acordo com a sua prioridade
     *
     * @param element elemento a ser inserido
     */

//   ---------------------------------------------------------- NÃO FUNFOU
//    public void enqueuePriority(Integer element) {
//        // Se a fila estiver vazia ou se o novo elemento for maior/igual ao último elemento da fila, adiciona no fim
//        if (isEmpty() || element >= fila.getLast())
//            fila.addLast(element);
//        else {
//            // Percorre a fila até achar a posição correta para inserir o novo elemento
//            int i = 0;
//            while (i < fila.size() && element < fila.get(i)) {
//                i++;
//            }
//            // Insere o novo elemento na posição correta
//            fila.add(i, element);
//        }
//    }

}
