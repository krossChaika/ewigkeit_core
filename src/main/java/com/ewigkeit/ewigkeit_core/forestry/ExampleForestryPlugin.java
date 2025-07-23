package com.ewigkeit.ewigkeit_core.forestry;

import com.ewigkeit.ewigkeit_core.EwigkeitCore;
import com.ewigkeit.ewigkeit_core.forestry.bees.BeeRegistration;
import com.ewigkeit.ewigkeit_core.forestry.bees.Taxonomy;
import com.ewigkeit.ewigkeit_core.forestry.hives.HiveRegistration;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import net.minecraft.resources.ResourceLocation;

public class ExampleForestryPlugin implements IForestryPlugin {
    public static final String AUTHORITY = "TestAuthority";
    
    @Override
    public ResourceLocation id() {
        return ResourceLocation.fromNamespaceAndPath(EwigkeitCore.MOD_ID, "forestry");
    }
    
    @Override
    public void registerApiculture(IApicultureRegistration apiculture){
        BeeRegistration.registerApiculture(apiculture);
        HiveRegistration.register(apiculture);
    }
    
    @Override
    public void registerGenetics(IGeneticRegistration genetics){
        Taxonomy.registerTaxa(genetics);
    }
}
