package DartTypes;

public abstract class DartType {
	public Object value;

	public DartType(Object value){
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof DartType)
			return value.equals(((DartType) o).value);
		return false;
	}

	public boolean not_equals(Object o){
		return ! equals(o);
	}

	public abstract String getTypeName();
	public abstract int hashCode();
}
