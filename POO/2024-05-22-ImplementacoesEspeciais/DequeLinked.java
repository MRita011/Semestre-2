//  O sistema utilizará MeuDeque de objetos Pessoa.
//  A implementação da interface MeuDeque pode ser realizada de diversas maneiras:
//      - com array: classe DequeArray.
//      - com ArrayList: classe DequeArrayList.
//      - com encadeamento: classe DequeLinked.

public class DequeLinked<T> implements MeuDeque<T> {
    private Nodo inicio = null;
    private Nodo fim = null;

    class Nodo {
        T dado;
        Nodo anterior, proximo;

        public Nodo(T dado, Nodo anterior, Nodo proximo) {
            this.dado = dado;
            this.anterior = anterior;
            this.proximo = proximo;
        }

        // GETTERS
        public T getDado() {
            return dado;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public Nodo getProximo() {
            return proximo;
        }

        // SETTERS
        public void setDado(T dado) {
            this.dado = dado;
        }

        public void setAnterior(Nodo anterior) {
            this.anterior = anterior;
        }

        public void setProximo(Nodo proximo) {
            this.proximo = proximo;
        }
    }

    @Override
    public boolean inserirInicio(T valor) {
        // Cria o nodo 'n' com: valor, sem anterior, apontando para o início
        Nodo n = new Nodo(valor, null, inicio);

        // Se tiver início, seta o nodo 'n' como "anterior ao início"
        if (inicio != null)
            inicio.setAnterior(n);

        inicio = n; // Atualiza o início

        // Se estiver vazia, define o fim como o novo início
        if (fim == null)
            fim = inicio;

        return true;
    }

    @Override
    public boolean inserirFim(T valor) {
        // Cria o nodo 'n' com: valor, apontando para o fim (atual), sem próximo
        Nodo n = new Nodo(valor, fim, null);

        // Se não está vazia, ajusta o ponteiro 'próximo' do atual fim para o n
        if (fim != null)
            fim.setProximo(n);

        fim = n; // Atualiza o fim da lista

        // Se estiver vazia, ajusta o início para ser o novo fim
        if (inicio == null)
            inicio = fim;

        return true;
    }

    @Override
    public T removerInicio() {
        // Se a lista estiver vazia, retorna null
        if (inicio == null)
            return null;

        // Armazena o valor do n (início)
        T valor = inicio.getDado();

        // Ajusta o início para ser o próximo nodo da lista
        inicio = inicio.getProximo();

        // Se a lista não está vazia (após remoção), atualiza o ponteiro 'anterior' do novo 'início' para null
        if (inicio != null)
            inicio.setAnterior(null);
        else
            fim = null; // Se a lista ficar vazia, atualiza o fim para null

        return valor; // Retorna o valor do nodo removido
    }

    @Override
    public T removerFim() {
        // Se a lista estiver vazia, retorna null
        if (fim == null)
            return null;

        // Armazena o último nodo (valor)
        T valor = fim.getDado();

        // Atualiza o fim como o nodo anterior na lista
        fim = fim.getAnterior();

        // Se a lista não está vazia (após a remoção), atualiza o ponteiro 'próximo' do 'novo fim' para null
        if (fim != null)
            fim.setProximo(null);
        else
            inicio = null; // Se a lista ficar vazia, atualiza o início para null

        return valor;
    }

    @Override
    public T consultarInicio() {
        // Se a lista estiver vazia, retorna null
        if (inicio == null)
            return null;

        return inicio.getDado();
    }

    @Override
    public T consultarFim() {
        // Se a lista estiver vazia, retorna null
        if (fim == null)
            return null;

        return fim.getDado();
    }

    @Override
    public int tamanho() {
        int contador = 0;
        Nodo aux = inicio;

        // Percorre a lista contando os nodos
        while (aux != null) {
            contador++;
            aux = aux.getProximo();
        }

        return contador;
    }
}
