package org.enoy.klc.minecraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.enoy.klc.minecraft.KlcEventHandler;
import org.enoy.klc.minecraft.connector.KlcConnector;
import org.enoy.klc.minecraft.connector.values.player.*;
import org.enoy.klc.minecraft.connector.values.world.*;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		new PlayerAir();
		new PlayerBiome();
		new PlayerBurning();
		new PlayerDead();
		new PlayerFoodLevel();
		new PlayerHealth();
		new PlayerInLava();
		new PlayerInWater();
		new PlayerMaxHealth();
		new PlayerSaturation();
		new PlayerSleeping();
		new PlayerSneaking();
		new PlayerXP();
		new PlayerPotionEffects();

		new WorldDaytime();
		new WorldMoonPhase();
		new WorldPrevThunderStrength();
		new WorldRaining();
		new WorldThundering();
		new WorldTime();

		KlcConnector.start();
		KlcEventHandler eventHandler = new KlcEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}
}
