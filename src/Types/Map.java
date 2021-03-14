package Types;

class Map<T1 extends Type, T2 extends Type> extends CompositeType {
    private final Type subType1;
    private final Type subType2;

    public Map(T1 subType1, T2 subType2){
        this.subType1 = subType1;
        this.subType2 = subType2;
    }

    @Override
    public java.lang.String toString() {
        return "Map<" + subType1 + ", " + subType2 + '>';
    }
}