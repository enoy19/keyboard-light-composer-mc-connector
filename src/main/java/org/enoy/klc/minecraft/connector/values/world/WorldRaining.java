package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class WorldRaining extends KlcMinecraftBoolean<World> implements WorldTarget {

	public static final String IDENTIFIER = "raining";

	public WorldRaining() {
		super(IDENTIFIER, World::isRaining);
	}

}
