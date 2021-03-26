package Types;

import java.util.Objects;

public abstract class Type {
    public abstract String toString();
}

class _Type extends Type{
    public String name;

    public static final _Type TYPE_INT = new _Type("int");
    public static final _Type TYPE_DOUBLE = new _Type("double");
    public static final _Type TYPE_BOOL = new _Type("bool");
    public static final _Type TYPE_STRING = new _Type("String");
    public static final _Type TYPE_DYNAMIC = new _Type("dynamic");
    public static final _Type TYPE_NULL = new _Type("Null");

    protected _Type(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof _Type)) return false;
        _Type type = (_Type) o;
        return name.equals(type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
