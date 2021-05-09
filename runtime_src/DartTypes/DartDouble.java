package DartTypes;

public class DartDouble extends DartType{
	public DartDouble() {
		super(0.0);
	}

	public DartDouble(Double value) {
		super(value);
	}

	public DartDouble add(DartDouble i){
		Double newValue = (Double)value + (Double)i.value;
		return new DartDouble(newValue);
	}

	public DartDouble sub(DartDouble i){
		Double newValue = (Double)value - (Double)i.value;
		return new DartDouble(newValue);
	}

	public DartDouble mul(DartDouble i){
		Double newValue = (Double)value * (Double)i.value;
		return new DartDouble(newValue);
	}

	public DartDouble div(DartDouble i){
		Double newValue = (Double)value / (Double)i.value;
		return new DartDouble(newValue);
	}

	@Override
	public String getTypeName() {
		return "double";
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