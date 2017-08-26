package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class PlayerMaxHealth extends KlcMinecraftFloat<EntityPlayerSP> implements PlayerTarget {

	private static final String IDENTIFIER = "health_max";

	public PlayerMaxHealth() {
		super(IDENTIFIER, EntityLivingBase::getMaxHealth /*TODO: player name*/);
	}

}
