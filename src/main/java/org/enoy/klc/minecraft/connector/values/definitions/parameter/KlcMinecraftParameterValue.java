package org.enoy.klc.minecraft.connector.values.definitions.parameter;

import org.enoy.klc.minecraft.connector.KlcConnector;
import org.enoy.klc.minecraft.connector.KlcData;
import org.enoy.klc.minecraft.connector.KlcDataValue;
import org.enoy.klc.minecraft.connector.values.definitions.KlcMinecraftAbstractValue;
import org.enoy.klc.minecraft.util.Function2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public abstract class KlcMinecraftParameterValue<T, P, V> extends KlcMinecraftAbstractValue<T, V> {

	private static final KlcConnector CONNECTOR = KlcConnector.getInstance();

	private Function<T, P> parameterProvider;
	private Function2<T, P, Map<String, V>> parameterValueProvider;

	public KlcMinecraftParameterValue(String identifier, Function<T, P> parameterProvider, Function2<T, P, Map<String, V>> parameterValueProvider) {
		super(identifier);
		this.parameterProvider = parameterProvider;
		this.parameterValueProvider = parameterValueProvider;
	}

	@Override
	public KlcData getData() {
		T target = getTarget();
		if (Objects.nonNull(target)) {
			P parameterData = parameterProvider.apply(target);

			if (Objects.nonNull(parameterData)) {
				Map<String, V> values = parameterValueProvider.apply(target, parameterData);
				List<KlcDataValue> klcDataValues = new ArrayList<>(values.size());

				values.forEach((parameter, data) -> {
					KlcDataValue value = new KlcDataValue(parameter, data);
					klcDataValues.add(value);
				});

				return new KlcData(getIdentifier(), getDataType(), klcDataValues);

			}
		}

		return null;
	}

	protected abstract Class<V> getValueClass();

}
