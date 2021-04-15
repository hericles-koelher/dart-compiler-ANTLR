import Dart.DartBaseListener;
import Dart.DartParser;
import SymbolTable.StringTable;

public class Listener extends DartBaseListener {

    private final StringTable st;

    public Listener(StringTable st) {
        this.st = st;
    }

    @Override
    public void exitStringLiteral(DartParser.StringLiteralContext ctx) {
        st.addString(ctx.getText());
    }
}
