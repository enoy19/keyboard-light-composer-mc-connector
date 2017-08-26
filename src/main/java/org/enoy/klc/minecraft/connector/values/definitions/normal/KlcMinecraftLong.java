package org.enoy.klc.minecraft.connector.values.definitions.normal;

import java.util.function.Function;

public abstract class KlcMinecraftLong<T> extends KlcMinecraftValue<T, Long> {

	public KlcMinecraftLong(String identifier, Function<T, Long> valueProvider) {
		super(identifier, valueProvider);
	}

	@Override
	protected Class<Long> getValueClass() {
		return Long.class;
	}
}
