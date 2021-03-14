package Types;

import java.util.HashMap;

// Não sei se é a melhor abordagem, mas é unica adotada até o momento.
class Null extends Type{
    @Override
    public java.lang.String toString() {
        return "Null";
    }
}

// Utilizado para Map e List
abstract class CompositeType extends Null {
}

class Int extends Null{
    @Override
    public java.lang.String toString() {
        return "int";
    }
}

class Double extends Null{
    @Override
    public java.lang.String toString() {
        return "double";
    }
}

class Bool extends Null{
    @Override
    public java.lang.String toString() {
        return "bool";
    }
}

class String extends Null{
    @Override
    public java.lang.String toString() {
        return "String";
    }
}

//TODO: fazer uma função de unificação...

public class Types{
    private static final Int typeInt = new Int();
    private static final Double typeDouble = new Double();
    private static final Bool typeBool = new Bool();
    private static final String typeString = new String();
    private static final Null typeNull = new Null();

    private static final HashMap<java.lang.String, Type> compositeTypes = new HashMap<>();

    // Fiz a classe abstrata CompositeType só pra poder limitar o tipo
    // utilizado nessa função. Se acharem um exagero dá pra tirar...
    public static void addCompositeType(CompositeType type){
        compositeTypes.put(type.toString(), type);
    }

    // Parando pra pensar getType indiretamente faz a mesma coisa que lookup...
    public static Boolean lookup(java.lang.String typeName){
        return switch (typeName) {
            case "int", "double", "bool", "String" -> true;
            default -> compositeTypes.containsKey(typeName);
        };
    }

    public static Type getType(java.lang.String typeName){
        return switch (typeName) {
            case "int" -> typeInt;
            case "double" -> typeDouble;
            case "bool" -> typeBool;
            case "String" -> typeString;
            case "Null" -> typeNull;
            default -> compositeTypes.get(typeName);
        };
    }
}