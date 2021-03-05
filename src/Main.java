import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import Interpreter.DartParser;
import Interpreter.DartLexer;

public class Main {
    public static void main(String[] args) {
        DartLexer lexer = new DartLexer(CharStreams.fromString("1+2+5"));
        DartParser parser = new DartParser(new CommonTokenStream(lexer));

        parser.start();
        System.out.println("My parser has executed Order 66");
    }
}
