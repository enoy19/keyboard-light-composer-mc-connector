package org.enoy.klc.minecraft.connector.values.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import org.enoy.klc.minecraft.connector.values.InternalTarget;

public interface PlayerTarget extends InternalTarget<EntityPlayerSP> {

	@Override
	default EntityPlayerSP getTargetInternal() {
		return Minecraft.getMinecraft().player;
	}

}
