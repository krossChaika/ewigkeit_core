package com.example.examplemod.forestry.feature;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.forestry.hives.CustomTileHive;
import com.noodlepfp.mobees.hive.MoreBeesTileHive;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class CustomApicultureTiles {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(ExampleMod.getResourceLocation("forestry"));
    
    public static final FeatureTileType<CustomTileHive> HIVE
            = REGISTRY.tile(CustomTileHive::new, "hive", () -> CustomApicultureBlocks.BEEHIVE.getBlocks());
}
