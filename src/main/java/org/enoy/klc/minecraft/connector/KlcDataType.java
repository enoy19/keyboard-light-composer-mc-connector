package org.enoy.klc.minecraft.connector;

import java.util.HashMap;
import java.util.Map;

public enum KlcDataType {
	BOOLEAN(0, Boolean.class),
	FLOAT(1, Float.class),
	LONG(2, Long.class),
	STRING(3, String.class);

	private static final Map<String, KlcDataType> dataTypeMap;

	static {
		dataTypeMap = new HashMap<>();
		for (KlcDataType dataType : values())
			dataTypeMap.put(dataType.getType().getName(), dataType);
	}

	private int id;
	private Class<?> type;

	KlcDataType(int id, Class<?> type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public Class<?> getType() {
		return type;
	}

	public static KlcDataType getByType(Class<?> type) {
		return dataTypeMap.get(type.getName());
	}

}