package org.enoy.klc.minecraft.connector.values.definitions.normal;

import java.util.function.Function;

public abstract class KlcMinecraftFloat<T> extends KlcMinecraftValue<T, Float> {

	public KlcMinecraftFloat(String identifier, Function<T, Float> valueProvider) {
		super(identifier, valueProvider);
	}

	@Override
	protected Class<Float> getValueClass() {
		return Float.class;
	}

}
