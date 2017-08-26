package org.enoy.klc.minecraft.connector.values.definitions.parameter;

import org.enoy.klc.minecraft.util.Function2;

import java.util.Map;
import java.util.function.Function;

public class KlcMinecraftParameterValueFloat<T, P> extends KlcMinecraftParameterValue<T, P, Float> {

	public KlcMinecraftParameterValueFloat(String identifier, Function<T, P> parameterProvider, Function2<T, P, Map<String, Float>> parameterValueProvider) {
		super(identifier, parameterProvider, parameterValueProvider);
	}

	@Override
	protected Class<Float> getValueClass() {
		return Float.class;
	}

}
