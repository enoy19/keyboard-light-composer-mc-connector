package org.enoy.klc.minecraft;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.enoy.klc.minecraft.connector.KlcConnector;

public class KlcEventHandler {

	private static final KlcConnector CONNECTOR = KlcConnector.getInstance();

	private int counter;

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		counter++;
		if (counter >= 5) {
			tick();
			counter = 0;
		}
	}

	private void tick() {
		CONNECTOR.send();
	}

	/*private boolean isPlayer(LivingEvent event) {
		return event.getEntityLiving().equals(getThePlayer());
	}*/

}
