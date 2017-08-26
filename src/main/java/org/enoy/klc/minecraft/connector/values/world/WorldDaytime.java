package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class WorldDaytime extends KlcMinecraftBoolean<World> implements WorldTarget {

	public static final String IDENTIFIER = "day_time";

	public WorldDaytime() {
		super(IDENTIFIER, World::isDaytime);
	}

}
