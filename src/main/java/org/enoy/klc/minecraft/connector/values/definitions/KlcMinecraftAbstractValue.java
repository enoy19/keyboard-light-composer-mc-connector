package org.enoy.klc.minecraft.connector.values.definitions;

import org.enoy.klc.minecraft.connector.KlcConnector;
import org.enoy.klc.minecraft.connector.KlcData;
import org.enoy.klc.minecraft.connector.KlcDataType;
import org.enoy.klc.minecraft.connector.values.InternalTarget;

import java.util.concurrent.Callable;

public abstract class KlcMinecraftAbstractValue<T, V> {

	private static final KlcConnector CONNECTOR = KlcConnector.getInstance();

	private final String identifier;
	private KlcDataType dataType;
	private Callable<T> targetProvider;

	public KlcMinecraftAbstractValue(String identifier) {
		this.identifier = identifier;
		resetTargetProvider();
		this.dataType = KlcDataType.getByType(getValueClass());

		CONNECTOR.register(this);
	}

	public abstract KlcData getData();

	public String getIdentifier() {
		return identifier;
	}

	public KlcDataType getDataType() {
		return dataType;
	}

	protected T getTarget() {
		try {
			return targetProvider.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setTargetProvider(final Callable<T> targetProvider) {
		accessTargetProvider(() -> this.targetProvider = targetProvider);
	}

	@SuppressWarnings("unchecked")
	public void resetTargetProvider() {
		accessTargetProvider(() -> {
			if (this instanceof InternalTarget)
				setTargetProvider(((InternalTarget<T>) this)::getTargetInternal);
			else
				setTargetProvider(() -> null);
		});
	}

	@SuppressWarnings("SynchronizeOnNonFinalField")
	private void accessTargetProvider(Runnable r) {
		if (this.targetProvider == null) {
			r.run();
		} else {
			// keep in mind. If reference changes, this may run in parallel
			synchronized (this.targetProvider) {
				r.run();
			}
		}
	}

	protected abstract Class<V> getValueClass();

}
