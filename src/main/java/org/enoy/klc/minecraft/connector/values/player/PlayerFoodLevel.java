package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.FoodStats;
import org.enoy.klc.minecraft.connector.values.ValueUtil;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerFoodLevel extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "food_level";

	public PlayerFoodLevel() {
		super(IDENTIFIER, ValueUtil.getValue(EntityPlayerSP::getFoodStats, FoodStats::getFoodLevel, fl->(float) fl));
	}

}
