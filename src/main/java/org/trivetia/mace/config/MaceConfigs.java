package org.trivetia.mace.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.trivetia.mace.Mace;
import org.trivetia.mace.config.ae2.ConfigAe2;

/**
 *
 * @author Dj
 */
public class MaceConfigs 
{
    
    public File configDirectory = null;
    public static Configuration ae2Cfg = null;
    
    public MaceConfigs(FMLPreInitializationEvent e) 
    {
        configDirectory = new File(e.getModConfigurationDirectory(), Mace.MODID);
        makeConfigs();
    }
    
    private void makeConfigs()
    {
        if(Loader.isModLoaded("appliedenergistics2"))
        {
            ae2Cfg = new Configuration(new File(configDirectory.getPath(), "ae2.cfg"));
            ConfigAe2.readConfig();
        }
    }

    public void saveAll() {
        if (ae2Cfg.hasChanged()) {
            ae2Cfg.save();
        }
    }
    
}
