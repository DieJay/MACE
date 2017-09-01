package org.trivetia.mace.common;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.trivetia.mace.config.MaceConfigs;

import org.trivetia.mace.config.ae2.ConfigAe2;

/**
 *
 * @author Dj
 */
@Mod.EventBusSubscriber
public class CommonProxy 
{
    // Config instance
    public static Configuration spatialConfigObj;
    public static MaceConfigs maceCfgs = null;
    
    public void preInit(FMLPreInitializationEvent e) 
    {
        /*File directory = e.getModConfigurationDirectory();
        spatialConfigObj = new Configuration(new File(directory.getPath(), "dunno.cfg"));
        ConfigAe2.readConfig();
        */
        maceCfgs = new MaceConfigs(e);
    }
    
    public void init(FMLInitializationEvent e) 
    {
        
    }
    
    public void postInit(FMLPostInitializationEvent e) 
    {
        if (spatialConfigObj.hasChanged()) {
            spatialConfigObj.save();
        }
    }
}
