package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerHealth extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	private static final String IDENTIFIER = "health";

	public PlayerHealth() {
		super(IDENTIFIER, EntityLivingBase::getHealth /*TODO: player name*/);
	}

}
