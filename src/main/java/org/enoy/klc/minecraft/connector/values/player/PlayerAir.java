package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import org.enoy.klc.minecraft.connector.values.ValueUtil;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerAir extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "air";

	public PlayerAir() {
		super(IDENTIFIER, ValueUtil.getValue(EntityPlayerSP::getAir, air -> (float) air));
	}

}
