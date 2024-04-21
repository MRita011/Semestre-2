//  a) Apresente os métodos definidos a seguir para uma classe QueueOfInterger que lida com números inteiros
//  em um estrutura de fila, considerando que os elementos da fila devem ser armazenados em uma DoubleLinkedListOfInteger.
//  Crie uma classe App e inclua nela o método main. Dentro deste método main instancie a fila implementada, inclua elementos
//  e use o restante dos métodos implementados.

public class QueueOfInterger 
{
    private DoubleLinkedListOfInteger fila;

    public QueueOfInterger() {
        fila = new DoubleLinkedListOfInteger();
    }

    public void enqueue(Integer element) {
        fila.add(element);
    }

    public Integer dequeue() {
        if (isEmpty())
            return null;

        Integer front = fila.get(0);
        fila.removeByIndex(0);
        return front;
    }

    public Integer head() {
        if (isEmpty())
            return null;

        return fila.get(0);
    }

    public int size() {
        return fila.size();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public void clear() {
        fila.clear();
    }

    public void enqueuePriority(Integer element) {
        int index = 0;
        while (index < fila.size() && element <= fila.get(index)) {
            index++;
        }
        fila.add(index, element);
    }


    public static String queueToString(QueueOfInterger fila) {
        StringBuilder sb = new StringBuilder();
        int tamanhoOriginal = fila.size();

        for (int i = 0; i < tamanhoOriginal; i++) {
            Integer element = fila.dequeue();
            sb.append(element).append(" | ");
            fila.enqueue(element);
        }
        return sb.toString();
    }
}
