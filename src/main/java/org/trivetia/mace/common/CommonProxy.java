package org.trivetia.mace.common;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.trivetia.mace.config.MaceConfigs;

/**
 *
 * @author Dj
 */
@Mod.EventBusSubscriber
public class CommonProxy 
{
    // Config instance
    public static MaceConfigs maceCfgs = null;
    
    public void preInit(FMLPreInitializationEvent e) 
    {
        maceCfgs = new MaceConfigs(e);
    }
    
    public void init(FMLInitializationEvent e) 
    {
        
    }
    
    public void postInit(FMLPostInitializationEvent e) 
    {
        maceCfgs.saveAll();
    }
}
