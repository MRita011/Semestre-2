public class DoubleLinkedListOfInteger {
    // Referência para o sentinela de início da lista encadeada.
    private Node header;

    // Referência para o sentinela de fim da lista encadeada.
    private Node trailer;

    // Referência para a posição corrente.
    private Node current;

    // Contador do número de elementos da lista.
    private int count;

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /***************************************************************************
     /*** CREATE | Operações de inserção de dados na lista duplamente encadeada
     /**************************************************************************

     /**
     * Método add() padrão
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */

    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;
    }

    /**
     * Método add() em posição específica
     * Insere um elemento em uma determinada posicao da lista
     *
     * @param index   a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */

    public void add(int index, Integer element) {
        // Primeiro verifica se index é válido
        if (index < 0 || index > count)
            throw new IndexOutOfBoundsException();

        if (index == count) // se inserção no final
            this.add(element);

        else {
            // Primeiro cria o nodo
            Node n = new Node(element);

            // "Caminha" até a posição index
            Node aux = this.getNodeIndex(index);

            // "Encadear" o nodo na lista
            n.next = aux;
            n.prev = aux.prev;
            aux.prev.next = n;
            aux.prev = n;

            // Atualiza o count
            count++;
        }
    }

    /***********************************************************
     /** READ | Operações de leitura de dados na lista encadeada
     /***********************************************************

     /**
     * Método get()
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    public Integer get(int index) {
        // Primeiro verifica se o indice eh valido
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        Node aux = getNodeIndex(index);
        return aux.element;
    }

    /**
     * Método getNodeIndex()
     * Retorna a referencia para o nodo da posicao index
     *
     * @param index índice para busca do nodo
     * @return aux retorna node do índice requerido
     */

    private Node getNodeIndex(int index) {
        Node aux = null;

        if (index < count / 2) { // caminha do inicio para o meio
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else { // caminha do fim para o meio
            aux = trailer.prev;

            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }

    /*******************************************************************
     /** UPDATE | Operações de substituição de dados na lista encadeada
     /******************************************************************

     /**
     * Método set()
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    public Integer set(int index, Integer element) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        Node aux = getNodeIndex(index);
        Integer elem = aux.element;
        aux.element = element;
        return elem;
    }

    /*************************************************************
     /** DELETE | Operações de remoção de dados na lista encadeada
     /*************************************************************

     /*
     * Método remove()
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */

    public boolean remove(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Método removeByIndex()
     * Remove o elemento de uma determinada posicao da lista
     *
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        // "Caminha" ate a posicao index
        Node aux = getNodeIndex(index);

        // Faz a remocao
        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;

        // Atualiza count
        count--;

        // Retorna o elemento removido
        return aux.element;
    }

    /*********************
     /*** OUTRAS OPERAÇÕES
     /*********************

     /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */

    public boolean contains(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element))
                return true;

            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     *
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */

    public int indexOf(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element))
                return i;

            aux = aux.next;
        }
        return -1;
    }

//    Esvazia a lista

    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista
     *
     * @return o numero de elementos da lista
     */

    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista não contem elementos
     *
     * @return true se a lista não contem elementos
     */

    public boolean isEmpty() {
        return (count == 0);
    }

//    Inicializa o current na primeira posicao (para percorrer do inicio para o fim).

    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     *
     * @return elemento da posicao corrente
     */

    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }

    /* ***************************** T1 ***************************** */

    /**
        * Método que conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor
        * @param element elemento a ser inserido
        * @return valor inteiro relativo ao número de ocorrências encontradas
    */

    public int countOccurrences(Integer element) {
        // Variável para contar o número de ocorrências
        int occurrences = 0;

        // Inicializa aux apontando para o primeiro nodo apos o head
        Node aux = header.next;

        // Caminha pela lista encadeada comparando os elementos com o parametro
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element))
                occurrences++;

            // Avança para o proximo nodo
            aux = aux.next;
        }
        return occurrences;
    }

    /**
        * Método que percorre a lista removendo todos os elementos pares.
        * Defina os atributos necessários para este algoritmo, pois nenhum método já implementado pode ser chamado
        * @return true se houver alguma remoção, e false caso não tenham elementos pares e não seja feita remoção
    */

    public boolean removeEvenNumbers() {
        // Verifica se a lista está vazia
        if (isEmpty())
            return false;

        // Inicializa o retorno como false
        boolean removed = false;

        // Inicializa os ponteiros para percorrer a lista
        Node prev = header;
        Node current = header.next;

        // Percorre a lista
        while (current != trailer) {
            // Verifica se o elemento atual é par
            if (current.element % 2 == 0) {
                // Remove o elemento par ajustando os ponteiros
                prev.next = current.next;
                current.next.prev = prev;

                current = current.next; // Avança o ponteiro sem avançar o anterior

                count--; // Decrementa o contador de elementos
                removed = true; // Indica que houve remoção
            }

            else {
                // Avança os ponteiros
                prev = current;
                current = current.next;
            }
        }

        return removed;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.next;
        }
        return s.toString();
    }

    public String toStringBackToFront() {
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.prev;
        }
        return s.toString();
    }
}
