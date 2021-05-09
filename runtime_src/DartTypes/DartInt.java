package DartTypes;

public class DartInt extends DartType{
	public DartInt() {
		super(0);
	}

	public DartInt(Integer value) {
		super(value);
	}

	public DartInt add(DartInt i){
		Integer newValue = (Integer)value + (Integer)i.value;
		return new DartInt(newValue);
	}

	public DartInt sub(DartInt i){
		Integer newValue = (Integer)value - (Integer)i.value;
		return new DartInt(newValue);
	}

	public DartInt mul(DartInt i){
		Integer newValue = (Integer)value * (Integer)i.value;
		return new DartInt(newValue);
	}

	public DartInt div(DartInt i){
		Integer newValue = (Integer)value / (Integer)i.value;
		return new DartInt(newValue);
	}

	@Override
	public String getTypeName() {
		return "int";
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof DartDouble)
			return value.equals(((DartDouble) o).value);
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
