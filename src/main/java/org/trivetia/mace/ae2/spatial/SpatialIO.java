package org.trivetia.mace.ae2.spatial;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import org.trivetia.mace.config.ae2.ConfigAe2;
import org.trivetia.mace.utils.LogHelper;

public class SpatialIO 
{    
        
    private final List<String> modsToAdd = new ArrayList<>(); //  Contains Mods which will be loaded
    
    public SpatialIO()
    {
        this.modsToAdd.addAll(ConfigAe2.spatialMods);        
    }
    
    public void addMod(String mod)
    {
        this.modsToAdd.add(mod);
    }
    
    public void registerMods()
    {        
        try
            {
                Field field = TileEntity.class.getDeclaredField("REGISTRY");
                field.setAccessible(true);
                RegistryNamespaced<ResourceLocation, Class<? extends TileEntity>> reg = (RegistryNamespaced) field.get(null);
                for(ResourceLocation location : reg.getKeys())
                {
                    System.out.println(location.getResourcePath());
                    if(modsToAdd.contains(location.getResourceDomain()))
                    {
                        FMLInterModComms.sendMessage( "appliedenergistics2", "whitelist-spatial", reg.getObject(location).getName());
                    }
                }
            } 
            catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex)
            {
                LogHelper.error("An unexpected error occured ", ex);
            }        
    }
}
