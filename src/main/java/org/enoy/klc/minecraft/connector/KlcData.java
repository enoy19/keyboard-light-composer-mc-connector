package org.enoy.klc.minecraft.connector;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class KlcData {

	public static final String SCOPE = "mc";

	private String identifier;
	private KlcDataType dataType;
	private Set<KlcDataValue> values;

	public KlcData(String identifier, KlcDataType dataType) {
		this(identifier, dataType, (KlcDataValue) null);
	}

	public KlcData(String identifier, KlcDataType dataType, KlcDataValue value) {
		this(identifier, dataType, Collections.singletonList(value));
	}

	public KlcData(String identifier, KlcDataType dataType, Collection<KlcDataValue> values) {
		this.identifier = identifier;
		this.dataType = dataType;
		if (values != null)
			this.values = new HashSet<>(values);
		else
			this.values = new HashSet<>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public KlcDataType getDataType() {
		return dataType;
	}

	public void setDataType(KlcDataType dataType) {
		this.dataType = dataType;
	}

	public void setValues(Collection<KlcDataValue> values) {
		this.values.clear();
		this.values.addAll(values);
	}

	public String format() {

		return
				values.stream()
						.map(klcDataValue -> String.format(SCOPE + ";%s;%s;%d;%s",
								identifier,
								klcDataValue.getParameter() == null ? "" : klcDataValue.getParameter().replaceAll(";", "_"),
								dataType.getId(),
								klcDataValue.getData()))

						.collect(Collectors.joining("\n"));
	}

	@Override
	public String toString() {
		return format();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		KlcData klcData = (KlcData) o;

		if (identifier != null ? !identifier.equals(klcData.identifier) : klcData.identifier != null) return false;
		return dataType == klcData.dataType;
	}

	@Override
	public int hashCode() {
		int result = identifier != null ? identifier.hashCode() : 0;
		result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
		return result;
	}

}
