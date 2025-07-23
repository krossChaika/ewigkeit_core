package com.example.examplemod.forestry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.forestry.bees.BeeRegistration;
import com.example.examplemod.forestry.bees.Taxonomy;
import com.example.examplemod.forestry.hives.HiveRegistration;
import com.noodlepfp.mobees.bee.MoreBeesTaxa;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.genetics.allele.MoreBeesAlleles;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;

public class ExampleForestryPlugin implements IForestryPlugin {
    public static final String AUTHORITY = "TestAuthority";
    
    @Override
    public ResourceLocation id() {
        return ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "forestry");
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
