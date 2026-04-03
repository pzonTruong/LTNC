
public class Main {

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        String input = "Hello world. This is a java program. Hello java, hello world.";

        counter.analyze(input);
        counter.displayResult();
    }
}
