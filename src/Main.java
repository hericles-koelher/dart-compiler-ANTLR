import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.nio.file.NoSuchFileException;

public class Main {
    public static void main(String[] args) {

        try {
            var lexer = new DartLexer(CharStreams.fromFileName(args[0]));
            var parser = new DartParser(new CommonTokenStream(lexer));

            parser.setErrorHandler(new BailErrorStrategy());
            parser.addErrorListener(new ThrowingErrorListener());

            DartSTListener dtListener = new DartSTListener();

            parser.addParseListener(dtListener);

            parser.start();

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please inform a filename!");
            return;
        } catch (NoSuchFileException e){
            System.out.println("File not found!");
            return;
        } catch (Exception e){
            // TODO: melhorar mensagem de erro.
            e.printStackTrace();
            System.out.println("Parse failed!");
            return;
        }

        System.out.println("Parse sucessful!");
    }
}

class ThrowingErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol, int line,
                            int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
