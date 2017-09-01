package org.trivetia.mace.config.ae2;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import org.trivetia.mace.Mace;
import org.trivetia.mace.common.CommonProxy;

/**
 *
 * @author Dj
 */
public class ConfigAe2 
{
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";
    private static final String CATEGORY_SPATIAL = "spatial";

    // This values below you can access elsewhere in your mod:
    public static boolean isThisAGoodTutorial = true;
    public static String yourRealName = "Steve";
    
    public static boolean enbaleSpatialCompat = true;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() 
    {
        Configuration cfg = CommonProxy.spatialConfigObj;
        try {
            cfg.load();
            initSpatialConfig(cfg);
            //initGeneralConfig(cfg);
            //initDimensionConfig(cfg);
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
    }

    private static void initGeneralConfig(Configuration cfg) 
    {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        isThisAGoodTutorial = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, isThisAGoodTutorial, "Set to false if you don't like this tutorial");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    private static void initDimensionConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
    }
}
