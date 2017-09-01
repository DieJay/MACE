package org.trivetia.mace.common;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.trivetia.mace.ae2.spatial.config.SpatialConfig;

/**
 *
 * @author Dj
 */
@Mod.EventBusSubscriber
public class CommonProxy 
{
    // Config instance
    public static Configuration config;
    
    public void preInit(FMLPreInitializationEvent e) 
    {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "dunno.cfg"));
        SpatialConfig.readConfig();
        
    }
    
    public void postInit(FMLPostInitializationEvent e) 
    {
        if (config.hasChanged()) {
            config.save();
        }
    }
}
