package org.enoy.klc.minecraft.connector.values.definitions.normal;

import org.enoy.klc.minecraft.connector.KlcData;
import org.enoy.klc.minecraft.connector.KlcDataValue;
import org.enoy.klc.minecraft.connector.values.definitions.KlcMinecraftAbstractValue;

import java.util.Objects;
import java.util.function.Function;

public abstract class KlcMinecraftValue<T, V> extends KlcMinecraftAbstractValue<T, V> {

	private Function<T, V> valueProvider;

	public KlcMinecraftValue(String identifier, Function<T, V> valueProvider) {
		super(identifier);
		this.valueProvider = valueProvider;
	}

	public KlcData getData() {
		T target = getTarget();
		if (Objects.nonNull(target)) {
			V value = valueProvider.apply(target);
			KlcDataValue klcDataValue = new KlcDataValue(value);

			return new KlcData(getIdentifier(), getDataType(), klcDataValue);

		}

		return null;
	}

}
