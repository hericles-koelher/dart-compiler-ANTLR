import AST.AbstractNode;
import SymbolTable.StringTable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.nio.file.NoSuchFileException;
import Dart.DartLexer;
import Dart.DartParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {

        try {
            var lexer = new DartLexer(CharStreams.fromFileName(args[0]));
            var parser = new DartParser(new CommonTokenStream(lexer));
            var st = new StringTable();

            parser.setErrorHandler(new BailErrorStrategy());
            parser.addErrorListener(new ThrowingErrorListener());
            parser.addParseListener(new Listener(st));

            ParseTree parseTree = parser.start();
            st.printStringTable();

            AbstractNode node = new Visitor().visit(parseTree);
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
