package Types;

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
    _Type type;
    Conv lc;  // Left conversion.
    Conv rc;  // Right conversion.

    TypeUnify(_Type type, Conv lc, Conv rc) {
        this.type = type;
        this.lc = lc;
        this.rc = rc;
    }

    static TypeEnum typeToEnum(_Type type) {
        if (type.equals(_Type.TYPE_INT)) {
            return TypeEnum.INT_TYPE;
        } else if (type.equals(_Type.TYPE_DOUBLE)) {
            return TypeEnum.REAL_TYPE;
        } else if (type.equals(_Type.TYPE_BOOL)) {
            return TypeEnum.BOOL_TYPE;
        } else if (type.equals(_Type.TYPE_STRING)) {
            return TypeEnum.STR_TYPE;
        }
        return TypeEnum.NO_TYPE;
    }

    static TypeUnify[][] PlusRelation = {
            {new TypeUnify(_Type.TYPE_INT, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_DOUBLE, Conv.I2R, Conv.NONE), new TypeUnify(_Type.TYPE_INT, Conv.NONE, Conv.B2I), new TypeUnify(_Type.TYPE_STRING, Conv.I2S, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_DOUBLE, Conv.NONE, Conv.I2R), new TypeUnify(_Type.TYPE_DOUBLE, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_DOUBLE, Conv.NONE, Conv.B2R), new TypeUnify(_Type.TYPE_STRING, Conv.R2S, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_INT, Conv.B2I, Conv.NONE), new TypeUnify(_Type.TYPE_DOUBLE, Conv.B2R, Conv.NONE), new TypeUnify(_Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_STRING, Conv.B2S, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_STRING, Conv.NONE, Conv.I2S), new TypeUnify(_Type.TYPE_STRING, Conv.NONE, Conv.R2S), new TypeUnify(_Type.TYPE_STRING, Conv.NONE, Conv.B2S), new TypeUnify(_Type.TYPE_STRING, Conv.NONE, Conv.NONE)}
    };

    static TypeUnify UnifyPlus(_Type lt, _Type rt) {
        return PlusRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

    static TypeUnify[][] OtherRelation = {
            {new TypeUnify(_Type.TYPE_INT, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_DOUBLE, Conv.I2R, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_DOUBLE, Conv.NONE, Conv.I2R), new TypeUnify(_Type.TYPE_DOUBLE, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)}
    };

    static TypeUnify UnifyOther(_Type lt, _Type rt) {
       return  OtherRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

    static TypeUnify[][] ComparisonRelation = {
            {new TypeUnify(_Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_BOOL, Conv.I2R, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_BOOL, Conv.NONE, Conv.I2R), new TypeUnify(_Type.TYPE_BOOL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE)},
            {new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_NULL, Conv.NONE, Conv.NONE), new TypeUnify(_Type.TYPE_BOOL, Conv.NONE, Conv.NONE)}
    };

    TypeUnify UnifyComparison(_Type lt, _Type rt) {
        return ComparisonRelation[typeToEnum(lt).ordinal()][typeToEnum(rt).ordinal()];
    }

}
