package org.trivetia.mace;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.trivetia.mace.common.CommonProxy;
import org.trivetia.mace.ae2.spatial.SpatialIO;
import org.trivetia.mace.commands.CommandSpatialAdd;

@Mod(modid = Mace.MODID, version = Mace.VERSION, name = Mace.NAME)
public class Mace {
    public static final String MODID = "mace";
    public static final String VERSION = "0.1";
    public static final String NAME = "Minecraft Advanced Compatibility Extension";
    
    @SidedProxy(clientSide = "org.trivetia.mace.client.ClientProxy", serverSide = "org.trivetia.mace.server.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    void preInit( FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }
    
    @EventHandler
    void init( FMLInitializationEvent event )
    {
        proxy.init(event);
        if( Loader.isModLoaded("appliedenergistics2") )
        {
            SpatialIO spatialMods = new SpatialIO();
            spatialMods.registerMods();
        }
    }   
    
    @EventHandler
    void postInit( FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        if( Loader.isModLoaded("appliedenergistics2") )
        {
            event.registerServerCommand(new CommandSpatialAdd());
        }
    }
    
}
