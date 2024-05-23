public class Main {
    public static void main(String[] args) {
        MeuDeque<Pessoa> deque = new DequeLinked<>();
        App app = new App(deque);
        app.executar();
    }
}
