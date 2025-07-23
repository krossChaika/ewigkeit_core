package com.example.examplemod.forestry.feature;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.forestry.hives.CustomBlockBeeHive;
import com.example.examplemod.forestry.hives.CustomBlockHiveType;
import forestry.core.items.ItemBlockForestry;
import forestry.modules.features.FeatureBlockGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.Item;

@FeatureProvider
public class CustomApicultureBlocks {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(ExampleMod.getResourceLocation("forestry"));
    // public static final FeatureBlockGroup<MoreBeesBlockHoneyComb, MoreBeesEnumHoneyComb> BEE_COMB = REGISTRY.blockGroup(MoreBeesBlockHoneyComb::new, MoreBeesEnumHoneyComb.VALUES).item(MoreBeesItemBlockHoneyComb::new).identifier("block_bee_comb").create();
    public static final FeatureBlockGroup<CustomBlockBeeHive, CustomBlockHiveType> BEEHIVE
            = REGISTRY.blockGroup(CustomBlockBeeHive::new, CustomBlockHiveType.values()).itemWithType(
                    (block, type) ->
                            new ItemBlockForestry<>(block, new Item.Properties())).identifier("beehive").create();
}
