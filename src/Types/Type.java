package Types;

public sealed abstract class Type permits _Type {
    public abstract String toString();
}

sealed class _Type extends Type permits List, Map {
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
}
