package Types;

import java.util.HashMap;

//TODO: fazer uma função de unificação...

public class TypeManager {
    private static final HashMap<String, Type> compositeTypes = new HashMap<>();

    // Permitindo somente variações de list e map...
    public static void addType(Type type) throws Exception{
        switch (((_Type) type).name) {
            case "int", "double", "bool", "String", "dynamic", "Null"
                    -> throw new Exception("Cannot add type " + ((_Type) type).name + " !");
            default -> compositeTypes.put(type.toString(), type);
        }
    }

    public static boolean lookup(String typeName){
        return switch (typeName) {
            case "int", "double", "bool", "String", "dynamic", "Null" -> true;
            default -> compositeTypes.containsKey(typeName);
        };
    }

    public static Type getType(String typeName){
        return switch (typeName) {
            case "int" -> _Type.TYPE_INT;
            case "double" -> _Type.TYPE_DOUBLE;
            case "bool" -> _Type.TYPE_BOOL;
            case "String" -> _Type.TYPE_STRING;
            case "Null" -> _Type.TYPE_NULL;
            case "dynamic" -> _Type.TYPE_DYNAMIC;
            default -> compositeTypes.get(typeName);
        };
    }
}