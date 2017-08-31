package org.trivetia.mace;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.trivetia.mace.common.CommonProxy;

@Mod(modid = Mace.MODID, version = Mace.VERSION, name = Mace.NAME)
public class Mace {
    public static final String MODID = "mace";
    public static final String VERSION = "0.1";
    public static final String NAME = "Minecraft Advanced Compatibility Extension";
    
    @SidedProxy(clientSide = "org.trivetia.mace.client.ClientProxy", serverSide = "org.trivetia.mace.server.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    void preInitialization( FMLPreInitializationEvent event)
    {
        
    }
    
    @EventHandler
    void initialization( FMLInitializationEvent event )
    {
        
    }   
    
    @EventHandler
    void postInitialization( FMLPostInitializationEvent event)
    {
        
    }
    
}
