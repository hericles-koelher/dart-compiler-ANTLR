import AST.Node;
import Dart.DartLexer;
import Dart.DartParser;
import SymbolTable.FunctionSymbolTable;
import SymbolTable.StringTable;
import SymbolTable.VarSymbolTable;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.NoSuchFileException;

public class Main {
    public static void main(String[] args) {


        try {
            FileWriter writer = new FileWriter("ast1.dot");

            var lexer = new DartLexer(CharStreams.fromFileName(args[0]));
            var parser = new DartParser(new CommonTokenStream(lexer));

            parser.setErrorHandler(new BailErrorStrategy());
            parser.addErrorListener(new ThrowingErrorListener());

            var st = new StringTable();
            var vt = new VarSymbolTable();
            var ft = new FunctionSymbolTable();
//            parser.addParseListener(new Listener(st, vt));

            ParseTree parseTree = parser.start();

//            st.print();
//            System.out.println();
//            vt.print();

            Node node = new ParseTreeVisitor(st, vt, ft).visit(parseTree);
            node.print(writer);

            FileOutputStream out = new FileOutputStream("Out.class");
            AstVisitor astVisitor = new AstVisitor();

            astVisitor.visit(node);
            astVisitor.write(out);

            System.out.println();

            writer.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please inform a filename!");
            return;
        } catch (NoSuchFileException e) {
            System.out.println("File not found!");
            return;
        } catch (Exception e) {
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
