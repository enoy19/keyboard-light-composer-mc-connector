package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.enoy.klc.minecraft.connector.values.definitions.parameter.KlcMinecraftParameterValueBoolean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PlayerPotionEffects extends KlcMinecraftParameterValueBoolean<EntityPlayerSP, Collection<Potion>> implements PlayerTarget {

	public static final String IDENTIFIER = "potion_effect";

	private static final Collection<Potion> POTIONS;

	static {
		POTIONS = new ArrayList<>();
		Potion.REGISTRY.forEach(POTIONS::add);
	}

	public PlayerPotionEffects() {
		super(IDENTIFIER, PlayerPotionEffects::parameterProvider, PlayerPotionEffects::parameterValueProvider);
	}

	private static Map<String, Boolean> parameterValueProvider(EntityPlayerSP playerSP, Collection<Potion> potions) {
		Map<String, Boolean> potionEffects = new HashMap<>();
		potions.forEach(p -> {
			PotionEffect effect = playerSP.getActivePotionEffect(p);
			if (effect == null) {
				potionEffects.put(p.getName(), false);
			} else {
				potionEffects.put(p.getName(), true);
			}
		});

		return potionEffects;
	}

	private static Collection<Potion> parameterProvider(EntityPlayerSP playerSP) {
		return POTIONS;
	}

}
