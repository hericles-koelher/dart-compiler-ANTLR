package Types;

final public class List<T extends _Type> extends _Type {
    //vai ser util quando tiver de comparar com o tipo dos elementos da lista
    public final _Type subType;

    public List(T subType){
        super("List<"+ subType +'>');
        this.subType = subType;
    }
}