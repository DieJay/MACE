package org.trivetia.mace.config.ae2;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraftforge.common.config.Configuration;
import org.trivetia.mace.config.MaceConfigs;
import org.trivetia.mace.utils.LogHelper;

/**
 *
 * @author Dj
 */
public class ConfigAe2 
{
  
    private static final String CATEGORY_SPATIAL = "AE2 Spatial Configuration";

    // This values below you can access elsewhere in your mod:    
    public static boolean enbaleSpatialCompat = true;
    //public static String[] spatialMods = new String[] {"draconicevolution", "computercraft"};
    public static List<String> spatialMods = Lists.newArrayList("draconicevolution", "computercraft", "test");

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() 
    {
        Configuration cfg = MaceConfigs.ae2Cfg;
        try {
            cfg.load();
            initSpatialConfig(cfg);
        } catch (Exception e1) {
            LogHelper.error("Error while making Configuration!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
    
    public static void addSpatialEntry(String newEntry)
    {
        //Doesnt twork :c
    }
    
    private static void initSpatialConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_SPATIAL, "Here you can Configure which mods work in the AE2 Spatial Pylons");
        enbaleSpatialCompat = cfg.getBoolean("Enable Spatial Compat", CATEGORY_SPATIAL, enbaleSpatialCompat, "Set to false to disable Spatial Compat");
        String[] tempSpatialArray = spatialMods.toArray(new String[0]);
        tempSpatialArray = cfg.getStringList("Enabled mods", CATEGORY_SPATIAL, tempSpatialArray, "Put the modid's of the mods you want to be enabled here (Without \"\")");
        spatialMods = Lists.newArrayList(tempSpatialArray);
        tempSpatialArray = null;
    }
     
}
