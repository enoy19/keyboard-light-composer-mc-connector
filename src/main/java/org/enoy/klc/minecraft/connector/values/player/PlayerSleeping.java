package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class PlayerSleeping extends KlcMinecraftBoolean<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "sleeping";

	public PlayerSleeping() {
		super(IDENTIFIER, EntityPlayer::isPlayerSleeping);
	}
}
