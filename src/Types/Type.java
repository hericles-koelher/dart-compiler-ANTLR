package Types;

import java.util.Objects;

public class Type {
    public static final Type TYPE_INT = new Type("int");
    public static final Type TYPE_DOUBLE = new Type("double");
    public static final Type TYPE_BOOL = new Type("bool");
    public static final Type TYPE_STRING = new Type("String");
    public static final Type TYPE_DYNAMIC = new Type("dynamic");
    public static final Type TYPE_NULL = new Type("Null");
    public String name;

    protected Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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
