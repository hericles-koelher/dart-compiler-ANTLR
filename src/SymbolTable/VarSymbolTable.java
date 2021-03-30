package SymbolTable;

import java.util.HashMap;
import java.util.Objects;

public class VarSymbolTable {
    private static final HashMap<Integer,Variable> vt = new HashMap<>();

    public static void addVar(Variable v) throws Exception{
        //Nem testei se tem alguma coisa nula...
        // Melhorar isso aqui
        if(lookup(v.name, v.scopeId))
            throw new Exception("Variable " + v.name + " already declared.");

        vt.put(v.hashCode(), v);
    }

    public static boolean lookup(String varName, Integer scopeId){
        return vt.containsKey(Objects.hash(varName, scopeId));
    }

    public static void print(){
        System.out.println("---Variable Symbol Table---\n");
        System.out.println(vt.toString());
    }
}