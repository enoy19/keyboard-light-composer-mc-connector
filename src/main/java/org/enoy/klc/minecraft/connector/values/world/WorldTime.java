package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftLong;

public class WorldTime extends KlcMinecraftLong<World> implements WorldTarget {

	public static final String IDENTIFIER = "time";

	public WorldTime() {
		super(IDENTIFIER, World::getWorldTime);
	}

}
