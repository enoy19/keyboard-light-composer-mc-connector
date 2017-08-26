package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftFloat;

public class WorldPrevThunderStrength extends KlcMinecraftFloat<World> implements WorldTarget {

	public static final String IDENTIFIER = "prev_thunder_strength";

	public WorldPrevThunderStrength() {
		super(IDENTIFIER, w -> w.prevThunderingStrength);
	}

}
