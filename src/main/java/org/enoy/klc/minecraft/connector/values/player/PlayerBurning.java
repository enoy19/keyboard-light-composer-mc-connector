package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class PlayerBurning extends KlcMinecraftBoolean<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "burning";

	public PlayerBurning() {
		super(IDENTIFIER, EntityPlayerSP::isBurning);
	}
}
