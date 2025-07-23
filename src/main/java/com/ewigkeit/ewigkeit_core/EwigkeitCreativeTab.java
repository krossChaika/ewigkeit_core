package com.ewigkeit.ewigkeit_core;

import com.ewigkeit.ewigkeit_core.forestry.feature.CustomApicultureBlocks;
import com.ewigkeit.ewigkeit_core.forestry.feature.Frames;
import com.ewigkeit.ewigkeit_core.forestry.hives.CustomBlockHiveType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class EwigkeitCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EwigkeitCore.MOD_ID);
    
    public static RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("ewigkeit_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("creativetab.ewigkeit"))
                    .icon(() -> ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("minecraft:iron_ingot")).getDefaultInstance())
                    .displayItems(EwigkeitCreativeTab::addDisplayItems).build());
    
    private static void addDisplayItems(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        // Hives
        for (CustomBlockHiveType type : CustomBlockHiveType.values()) {
            if (type.getSpeciesId().toString().contains(EwigkeitCore.MOD_ID)) {
                output.accept(CustomApicultureBlocks.BEEHIVE.get(type).item());
            }
        }
        
        // Frames
        output.accept(Frames.FRAME_OBLIVION.item());
    }
}
