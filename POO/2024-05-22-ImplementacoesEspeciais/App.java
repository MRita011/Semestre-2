class App {
    private MeuDeque<Pessoa> deque;

    public App(MeuDeque<Pessoa> deque) {
        this.deque = deque;
    }

    public void executar() {
        var p1 = new Pessoa("James", new Nascimento(27, 03, 1960));
        var p2 = new Pessoa("Arthur", new Nascimento(03, 11, 1959));
        var p3 = new Pessoa("John", new Nascimento(10, 03, 1960));

        deque.inserirInicio(p1);
        deque.inserirFim(p2);
        deque.inserirInicio(p3);

        System.out.println(
                "\n/*****************************" +
                        "\n/** APP | Deque após inserções" +
                        "\n/*****************************");

        System.out.println("\nInicio: " + deque.consultarInicio());
        System.out.println("\nFim: " + deque.consultarFim());
        System.out.println("\nTamanho: " + deque.tamanho());

        deque.removerInicio();
        deque.removerFim();

        System.out.println(
                "\n/*****************************" +
                        "\n/** APP | Deque após remoções" +
                        "\n/*****************************");

        System.out.println("\nInicio: " + deque.consultarInicio());
        System.out.println("\nFim: " + deque.consultarFim());
        System.out.println("\nTamanho: " + deque.tamanho());
    }
}
