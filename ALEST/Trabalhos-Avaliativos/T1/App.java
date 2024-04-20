public class App {
    public static void main(String[] args) {
        System.out.println(
                "/**************************************************\n" +
                        "/** NOMES | Alexya Ungaratti e Maria Rita Rodrigues \n" +
                        "/**************************************************\n"
        );

        DoubleLinkedListOfInteger dlist = new DoubleLinkedListOfInteger();
        dlist.add(10);
        dlist.add(20);
        dlist.add(30);
        dlist.add(40);
        dlist.add(50);
        dlist.add(60);
        dlist.add(70);
        dlist.add(80);

        System.out.println("Lista atual: " + dlist);
        System.out.println("Tamanho da lista: " + dlist.size());

        System.out.println("\nBusca valor na posição 2: " + dlist.get(2));
        System.out.println("Busca valor na posição 6: " + dlist.get(6));

        System.out.println("\nTrocou " + dlist.set(2, 35) + " por 35 na posicao 2.");

        System.out.println("Removeu 50? " + dlist.remove(50));
        System.out.println("Removeu 57? " + dlist.remove(57));

        System.out.println("\nLista atual: " + dlist);

        dlist.add(0, 0);
        dlist.add(dlist.size(), 90);
        dlist.add(4, 44);
        System.out.println("Lista atual: " + dlist);

        System.out.println("\nList de trás para frente: " + dlist.toStringBackToFront());

        System.out.println("\n/***************************************\n" + "/** T1 | PARTE 1: Implementação e testes\n" + "/***************************************\n");

        // Teste do método countOccurrences
        dlist.add(10);
        System.out.println("Lista após add(10): " + dlist);
        System.out.println("Número de ocorrências do n° 10: " + dlist.countOccurrences(10));

        // Teste do método removeEvenNumbers
        boolean removed = dlist.removeEvenNumbers();

        System.out.println("\nLista atual após a remoção dos números pares: " + dlist);
        System.out.println("Tamanho da lista: " + dlist.size());


        System.out.println("\n/***************************************\n" + "/** T1 | PARTE 2: Implementação da pilha\n" + "/***************************************\n");

        // Instanciando a pilha
        StackOfInteger pilha = new StackOfInteger();

        // Inserindo elementos na pilha (pegou a referência?! (๑˃ᴗ˂)ﻭ)
        pilha.push(0);
        pilha.push(10);
        pilha.push(20);
        pilha.push(35);
        pilha.push(44);
        pilha.push(40);
        pilha.push(60);
        pilha.push(70);
        pilha.push(80);
        pilha.push(90);
        pilha.push(10);

        // Mostrando todos os elementos da pilha
        System.out.println("Elementos da pilha: " + pilha.stackToString(pilha));
        System.out.println("Tamanho da pilha: " + pilha.size());

        // Mostrando o topo da pilha
        System.out.println("Top: " + pilha.top());

        // Removendo um elemento da pilha
        System.out.println("Pop: " + pilha.pop());

        // Verificando o tamanho da pilha
        System.out.println("Size: " + pilha.size());

        // Verificando se a pilha está vazia
        System.out.println("\nA pilha está vazia? " + pilha.isEmpty());

        // Limpando a pilha
        pilha.clear();

        // Verificando se a pilha está vazia após o clear
        System.out.println("A pilha está vazia após limpar? " + pilha.isEmpty());

        // Mostrando a pilha após o clear
        System.out.println("Elementos da pilha: " + pilha.stackToString(pilha));


        System.out.println("\n/******************************************\n" + "/** T1 | PARTE 2.1: Implementação da pilha\n" + "/******************************************\n");

        // Testando o método reverseArrayUsingStack()
        int[] array = {1, 2, 3, 4, 5};
        System.out.print("Array  original: ");
        for (int num : array) {
            System.out.print(num + " | ");
        }

        StackOfInteger.reverseArrayUsingStack(array);

        System.out.print("\nArray invertido: ");
        for (int num : array) {
            System.out.print(num + " | ");
        }


        System.out.println("\n\n/***************************************\n" + "/** T1 | PARTE 3: Implementação da fila\n" + "/***************************************\n");

        // Instanciando a fila
        QueueOfInterger fila = new QueueOfInterger();

        // Adicionando elementos à fila
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(35);
        fila.enqueue(44);
        fila.enqueue(40);
        fila.enqueue(60);
        fila.enqueue(70);
        fila.enqueue(80);
        fila.enqueue(90);
        fila.enqueue(11);
        fila.enqueue(77);

        // Elementos da fila
        System.out.println("Elementos da fila: " + fila.queueToString(fila));

        // Imprimindo o tamanho da fila
        System.out.println("Tamanho da fila: " + fila.size());

        // Imprimindo o elemento na frente da fila
        System.out.println("Head: " + fila.head());

        // Removendo elementos da fila
        System.out.println("\nDequeue: " + fila.dequeue());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Dequeue: " + fila.dequeue());

        System.out.println("\nElementos da fila: " + fila.queueToString(fila));
        System.out.println("Tamanho da fila: " + fila.size());

        // Verificando se a fila está vazia após a remoção
        System.out.println("\nA fila está vazia? " + fila.isEmpty());

//        // Testando o método enqueuePriority() com a lista atual como base para prioridades
//        int size = fila.size();
//        for (int i = 0; i < size; i++) {
//            Integer element = fila.dequeue();
//            fila.enqueuePriority(element);
//        }
//
//
//        // Imprimindo a fila de prioridade
//        System.out.println("Elementos da fila de prioridade: " + fila.queueToString(fila));
//        System.out.println("Tamanho da fila de prioridade: " + fila.size());
    }
}
