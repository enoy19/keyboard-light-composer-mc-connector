package org.enoy.klc.minecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.enoy.klc.minecraft.proxy.CommonProxy;

@Mod(modid = KlcMod.MODID, version = KlcMod.VERSION, name = KlcMod.NAME)
public class KlcMod
{
    public static final String MODID = "klcconnector";
    public static final String VERSION = "v.1.0-mc.1.10.2";
    public static final String NAME = "KLC Connector";

    @SidedProxy(clientSide = "org.enoy.klc.minecraft.proxy.ClientProxy", serverSide = "org.enoy.klc.minecraft.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static KlcMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
}
