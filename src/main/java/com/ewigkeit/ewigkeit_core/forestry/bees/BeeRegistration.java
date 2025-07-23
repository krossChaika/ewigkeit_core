package com.ewigkeit.ewigkeit_core.forestry.bees;

import com.ewigkeit.ewigkeit_core.EwigkeitCore;
import com.ewigkeit.ewigkeit_core.forestry.ExampleForestryPlugin;
import com.noodlepfp.mobees.feature.MoreBeesApicultureItems;
import com.noodlepfp.mobees.item.MoreBeesEnumHoneyComb;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.network.chat.TextColor;

public class BeeRegistration {
    public static void registerApiculture(IApicultureRegistration apiculture) {
        EwigkeitCore.LOGGER.info("Registering Apiculture!");
        
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
