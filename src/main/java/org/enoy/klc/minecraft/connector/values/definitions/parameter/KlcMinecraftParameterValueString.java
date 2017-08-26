package org.enoy.klc.minecraft.connector.values.definitions.parameter;

import org.enoy.klc.minecraft.util.Function2;

import java.util.Map;
import java.util.function.Function;

public class KlcMinecraftParameterValueString<T, P> extends KlcMinecraftParameterValue<T, P, String> {

	public KlcMinecraftParameterValueString(String identifier, Function<T, P> parameterProvider, Function2<T, P, Map<String, String>> parameterValueProvider) {
		super(identifier, parameterProvider, parameterValueProvider);
	}

	@Override
	protected Class<String> getValueClass() {
		return String.class;
	}

}
