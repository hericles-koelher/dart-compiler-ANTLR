package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class StringTable {

    private final List<String> st = new ArrayList<>();

    public int addString(String s) {
        int index = this.st.indexOf(s);
        if (index >= 0) {
            return index;
        }

        int indexAdded = this.st.size();
        this.st.add(s);

        return indexAdded;
    }

    public String getString(int i) {
        return this.st.get(i);
    }

    public void print() {
        System.out.println("String table:");
        for (int i = 0; i < this.st.size(); i++) {
            System.out.printf("Entry %d -- %s%n", i, this.st.get(i));
        }
    }
}
