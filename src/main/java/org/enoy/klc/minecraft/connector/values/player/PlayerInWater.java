package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class PlayerInWater extends KlcMinecraftBoolean<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "in_water";

	public PlayerInWater() {
		super(IDENTIFIER, EntityPlayerSP::isInWater);
		
	}
}
