package org.enoy.klc.minecraft.connector.values.world;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.enoy.klc.minecraft.connector.values.InternalTarget;

public interface WorldTarget extends InternalTarget<World> {

	@Override
	default World getTargetInternal() {
		return Minecraft.getMinecraft().world;
	}

}
