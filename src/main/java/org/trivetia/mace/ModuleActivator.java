package org.trivetia.mace;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.trivetia.mace.ae2.spatial.SpatialIO;

/**
 *
 * @author Dj
 */
public class ModuleActivator 
{
    
    public static void preInit(FMLPreInitializationEvent e)
    {
        
    }
    
    public static void init(FMLInitializationEvent e)
    {
        if( Loader.isModLoaded("appliedenergistics2") )
        {
            SpatialIO spatialMods = new SpatialIO();
            spatialMods.registerMods();
        }
    }
    
    public static void postInit(FMLPostInitializationEvent e)
    {
        
    }
}
