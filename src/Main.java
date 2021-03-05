import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import AutoGeneratedCode.DartLexer;
import AutoGeneratedCode.DartParser;
import org.antlr.v4.runtime.RecognitionException;

public class Main {
    public static void main(String[] args) {
        DartLexer lexer = new DartLexer(CharStreams.fromString("1+2+5"));
        DartParser parser = new DartParser(new CommonTokenStream(lexer));

        try {
            parser.start();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

        System.out.println("My parser has executed Order 66");
    }
}
