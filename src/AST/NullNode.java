package AST;

import Types.Type;
import Types.TypeManager;

public class NullNode extends AbstractExpressionNode{
    @Override
    public String toString() {
        return "NullNode{}";
    }

    // Será que isso é aceitavel? ehueueheuhueheuheu
    @Override
    public Type getType() {
        return TypeManager.getType("Null");
    }
}