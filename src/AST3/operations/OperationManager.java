package AST3.operations;

public abstract class OperationManager {
    public static Operation getOperation(String symbol) {
        switch (symbol) {
            case "+":
                return Operation.Addition;
            case "-":
                return Operation.Subtraction;
            case "print":
                return Operation.Print;
            default:
                throw new OperationNotSupportedException();
        }
    }
}
