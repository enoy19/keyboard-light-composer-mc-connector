package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerXP extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "xp";

	public PlayerXP() {
		super(IDENTIFIER, e -> e.experience);
	}

}
