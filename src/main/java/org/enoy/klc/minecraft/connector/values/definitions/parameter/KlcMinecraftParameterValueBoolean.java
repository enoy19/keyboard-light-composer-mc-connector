package org.enoy.klc.minecraft.connector.values.definitions.parameter;

import org.enoy.klc.minecraft.util.Function2;

import java.util.Map;
import java.util.function.Function;

public class KlcMinecraftParameterValueBoolean<T, P> extends KlcMinecraftParameterValue<T, P, Boolean> {

	public KlcMinecraftParameterValueBoolean(String identifier, Function<T, P> parameterProvider, Function2<T, P, Map<String, Boolean>> parameterValueProvider) {
		super(identifier, parameterProvider, parameterValueProvider);
	}

	@Override
	protected Class<Boolean> getValueClass() {
		return Boolean.class;
	}

}
