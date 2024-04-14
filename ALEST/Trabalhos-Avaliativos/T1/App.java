// Trabalho 1: ALEST
// Alexya Ungaratti e Maria Rita Rodrigues

public class App {

    public static void main(String[] args) {

        DoubleLinkedListOfInteger dlist = new DoubleLinkedListOfInteger();
        dlist.add(10);
        dlist.add(20);
        dlist.add(30);
        dlist.add(40);
        dlist.add(50);
        dlist.add(60);
        dlist.add(70);
        dlist.add(80);

        System.out.println("\nLista atual: " + dlist);
        System.out.println("\nTamanho da lista: " + dlist.size());

        System.out.println("\nBusca valor na posição 2: " + dlist.get(2));
        System.out.println("\nBusca valor na posição 6: " + dlist.get(6));

        System.out.println("\nTrocou " + dlist.set(2, 35) + " por 35 na posicao 2.");

        System.out.println("\nRemoveu 50? " + dlist.remove(50));
        System.out.println("\nRemoveu 57? " + dlist.remove(57));

        System.out.println("\nLista atual: " + dlist);

        dlist.add(0, 0);
        dlist.add(dlist.size(), 90);
        dlist.add(4, 44);
        System.out.println("\nLista atual: " + dlist);

        System.out.println("\nList de trás para frente: " + dlist.toStringBackToFront());

        System.out.println("\n\n**************************** T1 ******************************");

        // Teste do método countOccurrences
        dlist.add(10);
        System.out.println("\nLista atual: " + dlist);
        System.out.println("\nNúmero de ocorrências de 10: " + dlist.countOccurrences(10));

        // Teste do método removeEvenNumbers
        System.out.println("\nLista atual: " + dlist);

        boolean removed = dlist.removeEvenNumbers();

        System.out.println("\nLista atual após remover pares: " + dlist);
        System.out.println("\nTamanho da lista após remover pares: " + dlist.size());
    }
}
