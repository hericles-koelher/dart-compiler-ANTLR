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

	public DartBool lt(DartInt i){
		return new DartBool((Integer) i.value < (Integer) this.value);
	}

	public DartBool gt(DartInt i){
		return new DartBool((Integer) i.value > (Integer) this.value);
	}

	public DartBool lte(DartInt i){
		return new DartBool((Integer) i.value <= (Integer) this.value);
	}

	public DartBool gte(DartInt i){
		return new DartBool((Integer) i.value >= (Integer) this.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
