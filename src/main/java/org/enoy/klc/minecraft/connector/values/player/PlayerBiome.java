package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import org.enoy.klc.minecraft.connector.values.definitions.normal.KlcMinecraftString;

public class PlayerBiome extends KlcMinecraftString<EntityPlayerSP> implements PlayerTarget {

	public static final String IDENTIFIER = "biome";

	public PlayerBiome() {
		super(IDENTIFIER, p -> {
					BlockPos position = p.getPosition();
					WorldClient world = Minecraft.getMinecraft().world;
					if (world != null) {
						return world.getBiome(position).getBiomeName();
					}

					return "none";
				}
		);
	}

}
