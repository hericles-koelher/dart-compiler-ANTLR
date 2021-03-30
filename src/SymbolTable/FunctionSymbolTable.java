package SymbolTable;

import java.util.HashMap;
import java.util.Objects;

public class FunctionSymbolTable {
    private static final HashMap<Integer, Function> ft = new HashMap<>();

    public static boolean lookup(String name, Integer scopeId){
        return ft.containsKey(Objects.hash(name, scopeId));
    }

    public static void addFunction(Function f) throws Exception{
        if(lookup(f.name, f.scopeId))
            throw new Exception("Function "+f.name+" already declared");

        ft.put(f.hashCode(), f);
    }

    public static void print(){
        System.out.println("---Function Symbol Table---");
        System.out.println(ft);
    }
}