package Types;

class List<T extends Type> extends CompositeType {
    private final Type subType;

    public List(T subType){
        this.subType = subType;
    }

    @Override
    public java.lang.String toString() {
        return "List<"+ subType +'>';
    }
}