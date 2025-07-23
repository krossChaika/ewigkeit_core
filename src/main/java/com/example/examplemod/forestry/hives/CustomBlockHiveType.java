package com.example.examplemod.forestry.hives;

import com.example.examplemod.forestry.bees.Species;
import forestry.api.core.IBlockSubtype;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

public enum CustomBlockHiveType implements IBlockSubtype {
    MOON(Species.MOON),;
    
    private final ResourceLocation speciesUid;
    
    CustomBlockHiveType(ResourceLocation speciesUid) {
        this.speciesUid = speciesUid;
    }
    
    public ResourceLocation getSpeciesId() {
        return this.speciesUid;
    }
    
    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
