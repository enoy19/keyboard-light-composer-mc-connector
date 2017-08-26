package org.enoy.klc.minecraft.connector;

public class KlcDataValue {

	private String parameter;
	private String data;

	public KlcDataValue() {

	}

	public KlcDataValue(Object data) {
		this(null, data);
	}

	public KlcDataValue(String parameter, Object data) {
		this.parameter = parameter;
		this.data = data == null ? null : data.toString();
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		KlcDataValue value = (KlcDataValue) o;

		return parameter != null ? parameter.equals(value.parameter) : value.parameter == null;
	}

	@Override
	public int hashCode() {
		return parameter != null ? parameter.hashCode() : 0;
	}

}
