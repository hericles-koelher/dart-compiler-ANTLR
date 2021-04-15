package Types;

import Types.Type;

enum TypeEnum {
    INT_TYPE,
    REAL_TYPE,
    BOOL_TYPE,
    STR_TYPE,
    NO_TYPE, // Used when we need to pass a non-existing type to a function.
}

enum Conv {  // Basic conversions between types.
    B2I,
    B2R,
    B2S,
    I2R,
    I2S,
    R2S,
    NONE,
}

public class TypeUnify {
    public Type type;
    public Conv lc;  // Left conversion.
    public Conv rc;  // Right conversion.

    TypeUnify(Type type, Conv lc, Conv rc) {
        this.type = type;
        this.lc = lc;
        this.rc = rc;
    }

    static TypeEnum typeToEnum(Type type) {
        if (type.equals(Type.TYPE_INT)) {
            return TypeEnum.INT_TYPE;
        } else if (type.equals(Type.TYPE_DOUBLE)) {
            return TypeEnum.REAL_TYPE;
        } else if (type.equals(Type.TYPE_BOOL)) {
            return TypeEnum.BOOL_TYPE;
        } else if (type.equals(Type.TYPE_STRING)) {
            return TypeEnum.STR_TYPE;
        }
        return TypeEnum.NO_TYPE;
    }


    static TypeUnify[][] PlusRelation = {
            {new TypeUnify(Type.TYPE_INT, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_DOUBLE, Conv.I2R, Conv.NONE), new TypeUnify(Type.TYPE_INT, Conv.NONE, Conv.B2I), new TypeUnify(Type.TYPE_STRING, Conv.I2S, Conv.NONE)},
            {new TypeUnify(Type.TYPE_DOUBLE, Conv.NONE, Conv.I2R), new TypeUnify(Type.TYPE_DOUBLE, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_DOUBLE, Conv.NONE, Conv.B2R), new TypeUnify(Type.TYPE_STRING, Conv.R2S, Conv.NONE)},
            {new TypeUnify(Type.TYPE_INT, Conv.B2I, Conv.NONE), new TypeUnify(Type.TYPE_DOUBLE, Conv.B2R, Conv.NONE), new TypeUnify(Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_STRING, Conv.B2S, Conv.NONE)},
            {new TypeUnify(Type.TYPE_STRING, Conv.NONE, Conv.I2S), new TypeUnify(Type.TYPE_STRING, Conv.NONE, Conv.R2S), new TypeUnify(Type.TYPE_STRING, Conv.NONE, Conv.B2S), new TypeUnify(Type.TYPE_STRING, Conv.NONE, Conv.NONE)}
    };

    public static TypeUnify UnifyPlus(Type lt, Type rt) {
        return PlusRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

    static TypeUnify[][] OtherRelation = {
            {new TypeUnify(Type.TYPE_INT, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_DOUBLE, Conv.I2R, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_DOUBLE, Conv.NONE, Conv.I2R), new TypeUnify(Type.TYPE_DOUBLE, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)}
    };

    public static TypeUnify UnifyOther(Type lt, Type rt) {
       return  OtherRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

    static TypeUnify[][] ComparisonRelation = {
            {new TypeUnify(Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_BOOL, Conv.I2R, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_BOOL, Conv.NONE, Conv.I2R), new TypeUnify(Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(Type.TYPE_BOOL, Conv.NONE, Conv.NONE)}
    };

    public static TypeUnify UnifyComparison(Type lt, Type rt) {
        return ComparisonRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

}
