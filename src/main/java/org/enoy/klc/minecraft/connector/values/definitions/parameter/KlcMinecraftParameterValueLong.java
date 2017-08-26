package org.enoy.klc.minecraft.connector.values.definitions.parameter;

import org.enoy.klc.minecraft.util.Function2;

import java.util.Map;
import java.util.function.Function;

public class KlcMinecraftParameterValueLong<T, P> extends KlcMinecraftParameterValue<T, P, Long> {

	public KlcMinecraftParameterValueLong(String identifier, Function<T, P> parameterProvider, Function2<T, P, Map<String, Long>> parameterValueProvider) {
		super(identifier, parameterProvider, parameterValueProvider);
	}

	@Override
	protected Class<Long> getValueClass() {
		return Long.class;
	}

}
