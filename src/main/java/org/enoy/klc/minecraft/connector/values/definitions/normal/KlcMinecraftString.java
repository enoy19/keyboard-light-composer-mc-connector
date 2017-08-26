package org.enoy.klc.minecraft.connector.values.definitions.normal;

import java.util.function.Function;

public abstract class KlcMinecraftString<T> extends KlcMinecraftValue<T, String> {

	public KlcMinecraftString(String identifier, Function<T, String> valueProvider) {
		super(identifier, valueProvider);
	}

	@Override
	protected Class<String> getValueClass() {
		return String.class;
	}
}
