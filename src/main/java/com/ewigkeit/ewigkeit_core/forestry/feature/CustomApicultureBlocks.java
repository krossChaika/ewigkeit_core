package com.ewigkeit.ewigkeit_core.forestry.feature;

import com.ewigkeit.ewigkeit_core.EwigkeitCore;
import com.ewigkeit.ewigkeit_core.forestry.hives.CustomBlockBeeHive;
import com.ewigkeit.ewigkeit_core.forestry.hives.CustomBlockHiveType;
import forestry.core.items.ItemBlockForestry;
import forestry.modules.features.FeatureBlockGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;
import net.minecraft.world.item.Item;

@FeatureProvider
public class CustomApicultureBlocks {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(EwigkeitCore.getResourceLocation("forestry"));
    // public static final FeatureBlockGroup<MoreBeesBlockHoneyComb, MoreBeesEnumHoneyComb> BEE_COMB = REGISTRY.blockGroup(MoreBeesBlockHoneyComb::new, MoreBeesEnumHoneyComb.VALUES).item(MoreBeesItemBlockHoneyComb::new).identifier("block_bee_comb").create();
    public static final FeatureBlockGroup<CustomBlockBeeHive, CustomBlockHiveType> BEEHIVE
            = REGISTRY.blockGroup(CustomBlockBeeHive::new, CustomBlockHiveType.values()).itemWithType(
                    (block, type) ->
                            new ItemBlockForestry<>(block, new Item.Properties())).identifier("beehive").create();
}
