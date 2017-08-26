package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftBoolean;

public class WorldThundering extends KlcMinecraftBoolean<World> implements WorldTarget {

	public static final String IDENTIFIER = "thundering";

	public WorldThundering() {
		super(IDENTIFIER, World::isThundering);
	}

}
