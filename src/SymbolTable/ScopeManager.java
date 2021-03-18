package SymbolTable;

import java.util.Stack;

// A ideia é que como durante a visitação a construção da AST
// é feita das folhas até a raiz, então durante a descida
// criamos os escopos, que são passados para os nós de função
// e declaração de variaveis.

public class ScopeManager {
    private static final Stack<Integer> scopeStack = new Stack<Integer>();
    private static Integer id = 0;

    public static Integer getScopeId(){
        return scopeStack.peek();
    }

    public static void createScope(){
        scopeStack.push(id++);
    }

    public static void removeScope(){
        scopeStack.pop();
    }

}
