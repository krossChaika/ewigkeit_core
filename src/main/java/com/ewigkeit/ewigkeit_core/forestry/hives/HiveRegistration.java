package com.ewigkeit.ewigkeit_core.forestry.hives;

import com.ewigkeit.ewigkeit_core.forestry.bees.Species;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class HiveRegistration {
    public static void register(IApicultureRegistration apiculture) {
        var stone = ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("minecraft:stone"));
        ItemStack stack = new ItemStack(stone);
        var stoneList = List.of(stack);
        var b = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse("minecraft:stone"));
        
        apiculture.registerHive(Species.MOON, CustomHiveDefinition.MOON)
                .addDrop(1.0, Species.MOON, () -> stoneList, 0.3F);
    }
}
