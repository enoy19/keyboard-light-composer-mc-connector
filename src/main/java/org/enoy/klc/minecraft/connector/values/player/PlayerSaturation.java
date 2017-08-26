package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.FoodStats;
import org.enoy.klc.minecraft.connector.values.ValueUtil;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerSaturation extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "saturation";

	public PlayerSaturation() {
		super(IDENTIFIER, ValueUtil.getValue(EntityPlayerSP::getFoodStats, FoodStats::getSaturationLevel));
	}

}
