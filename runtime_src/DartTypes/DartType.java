package DartTypes;

public abstract class DartType {
	public Object value;

	public DartType(Object value){
		this.value = value;
	}

	public String toString() {
		return value.toString();
	}

	public abstract String getTypeName();
	public abstract boolean equals(Object o);
	public abstract int hashCode();
}
