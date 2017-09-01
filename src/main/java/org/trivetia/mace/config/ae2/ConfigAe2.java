package org.trivetia.mace.config.ae2;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import org.trivetia.mace.Mace;
import org.trivetia.mace.common.CommonProxy;
import org.trivetia.mace.config.MaceConfigs;

/**
 *
 * @author Dj
 */
public class ConfigAe2 
{
  
    private static final String CATEGORY_SPATIAL = "spatial";

    // This values below you can access elsewhere in your mod:    
    public static boolean enbaleSpatialCompat = true;
    public static String[] spatialMods = new String[] {""};

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() 
    {
        Configuration cfg = MaceConfigs.ae2Cfg;
        try {
            cfg.load();
            initSpatialConfig(cfg);
        } catch (Exception e1) {
            Mace.logger.log(Level.ERROR, "Error while making Configuration!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
    
    private static void initSpatialConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_SPATIAL, "Spatial Configuration");
        enbaleSpatialCompat = cfg.getBoolean("Enable Spatial Compat", CATEGORY_SPATIAL, enbaleSpatialCompat, "Set to false to disable Spatial Compat");
        spatialMods = cfg.getStringList("Enabled mods", CATEGORY_SPATIAL, spatialMods, "Put the modid's of the mods you want to be enabled here (Without \"\")");
    }
     
}
