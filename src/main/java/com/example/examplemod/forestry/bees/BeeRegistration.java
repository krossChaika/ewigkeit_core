package com.example.examplemod.forestry.bees;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.forestry.ExampleForestryPlugin;
import com.noodlepfp.mobees.bee.MoreBeesTaxa;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.genetics.allele.MoreBeesAlleles;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;

public class BeeRegistration {
    public static void registerApiculture(IApicultureRegistration apiculture) {
        ExampleMod.LOGGER.info("Registering Apiculture!");
        
        TextColor baseColor = TextColor.fromRgb(0x9F9F9F);
        
        // Species - Bee identifier
        // Genus   - Stats
        // s1      - Formatted name or smth
        // b       - Is dominant?
        
        // Moon bee
        apiculture.registerSpecies(Species.MOON, Genus.MOON, "Moon", true, baseColor)
                .setBody(TextColor.fromRgb(0xaab7bf))
                .addProduct(MoreBeesApicultureItems.BEE_COMBS.stack(MoreBeesEnumHoneyComb.ROCKY), 0.3f)
                // .setTemperature(TemperatureType.ICY)
                // .setHumidity(HumidityType.NORMAL)
                .setAuthority(ExampleForestryPlugin.AUTHORITY);
    }
}
