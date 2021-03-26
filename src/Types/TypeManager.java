package Types;

import java.util.HashMap;

//TODO: fazer uma função de unificação...

public class TypeManager {
    private static final HashMap<String, Type> compositeTypes = new HashMap<>();

    // Permitindo somente variações de list e map...
    public static void addType(Type type) throws Exception{
        switch (type.toString()){
            case "int":
            case "double":
            case "bool":
            case "String":
            case "dynamic":
            case "Null":
                throw new Exception("Cannot add type " + ((_Type) type).name + " !");
            default:
                compositeTypes.put(type.toString(), type);
        }
    }

    public static boolean lookup(String typeName){
        switch (typeName){
            case "int":
            case "double":
            case "bool":
            case "String":
            case "dynamic":
            case "Null":
                return true;
            default:
                return compositeTypes.containsKey(typeName);
        }
    }

    public static Type getType(String typeName){
        switch (typeName){
            case "int":
                return _Type.TYPE_INT;
            case "double":
                return _Type.TYPE_DOUBLE;
            case "bool":
                return _Type.TYPE_BOOL;
            case "String":
                return _Type.TYPE_STRING;
            case "dynamic":
                return _Type.TYPE_DYNAMIC;
            case "Null":
                return _Type.TYPE_NULL;
            default:
                return compositeTypes.get(typeName);
        }
    }
}