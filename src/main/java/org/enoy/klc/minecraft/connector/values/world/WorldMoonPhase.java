package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftLong;

public class WorldMoonPhase extends KlcMinecraftLong<World> implements WorldTarget {

	public static final String IDENTIFIER = "moon_phase";

	public WorldMoonPhase() {
		super(IDENTIFIER, w -> (long) w.getMoonPhase());
	}

}
