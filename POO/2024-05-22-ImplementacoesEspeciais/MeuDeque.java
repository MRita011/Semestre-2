public interface MeuDeque<T> {
    boolean inserirInicio(T valor);
    boolean inserirFim(T valor);
    T removerInicio();
    T removerFim();
    T consultarInicio();
    T consultarFim();
    int tamanho();
}
