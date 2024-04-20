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
        StackOfInteger stack = new StackOfInteger();

        // Inserindo elementos na pilha (pegou a referência?! (๑˃ᴗ˂)ﻭ)
        stack.push(0);
        stack.push(10);
        stack.push(20);
        stack.push(35);
        stack.push(44);
        stack.push(40);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(10);

        // Mostrando todos os elementos da pilha
        System.out.println("Elementos da pilha: " + stack.stackToString(stack));
        System.out.println("Tamanho da pilha: " + stack.size());

        // Mostrando o topo da pilha
        System.out.println("Top: " + stack.top());

        // Removendo um elemento da pilha
        System.out.println("Pop: " + stack.pop());

        // Verificando o tamanho da pilha
        System.out.println("Size: " + stack.size());

        // Verificando se a pilha está vazia
        System.out.println("\nA pilha está vazia? " + stack.isEmpty());

        // Limpando a pilha
        stack.clear();

        // Verificando se a pilha está vazia após o clear
        System.out.println("A pilha está vazia após limpar? " + stack.isEmpty());

        // Mostrando a pilha após o clear
        System.out.println("Elementos da pilha: " + stack.stackToString(stack));


        System.out.println("\n/******************************************\n" + "/** T1 | PARTE 2.1: Implementação da pilha\n" + "/******************************************\n");

        // Testando o método reverseArrayUsingStack()
        int[] array = {1, 2, 3, 4, 5};
        System.out.print("Array  original: ");
        for (int num : array) { System.out.print(num + " | "); }

        StackOfInteger.reverseArrayUsingStack(array);

        System.out.print("\nArray invertido: ");
        for (int num : array) { System.out.print(num + " | "); }
    }
}
