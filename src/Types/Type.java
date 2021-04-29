package Types;

import java.util.Objects;

public class Type {

    // "Constante"
    public enum Name{
        INT("int"),
        DOUBLE("double"),
        BOOL("bool"),
        STRING("String"),
        DYNAMIC("dynamic"),
        NULL("Null")
        ;

        private String _name;

        private Name(String name) {
            this._name = name;
        }

        @Override
        public String toString() {
            return _name;
        }
    }

    public static final Type TYPE_INT = new Type(Name.INT);
    public static final Type TYPE_DOUBLE = new Type(Name.DOUBLE);
    public static final Type TYPE_BOOL = new Type(Name.BOOL);
    public static final Type TYPE_STRING = new Type(Name.STRING);
    public static final Type TYPE_DYNAMIC = new Type(Name.DYNAMIC);
    public static final Type TYPE_NULL = new Type(Name.NULL);
    public Name name;

    protected Type(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type = (Type) o;
        return name.equals(type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
