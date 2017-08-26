package org.enoy.klc.minecraft.connector.values.definitions.normal;

import java.util.function.Function;

public abstract class KlcMinecraftBoolean<T> extends KlcMinecraftValue<T, Boolean> {

	public KlcMinecraftBoolean(String identifier, Function<T, Boolean> valueProvider) {
		super(identifier, valueProvider);
	}

	@Override
	protected Class<Boolean> getValueClass() {
		return Boolean.class;
	}
}
