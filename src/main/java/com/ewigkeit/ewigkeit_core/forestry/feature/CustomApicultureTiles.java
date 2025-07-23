package com.ewigkeit.ewigkeit_core.forestry.feature;

import com.ewigkeit.ewigkeit_core.EwigkeitCore;
import com.ewigkeit.ewigkeit_core.forestry.hives.CustomTileHive;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.FeatureTileType;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class CustomApicultureTiles {
    private static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(EwigkeitCore.getResourceLocation("forestry"));
    
    public static final FeatureTileType<CustomTileHive> HIVE
            = REGISTRY.tile(CustomTileHive::new, "hive", () -> CustomApicultureBlocks.BEEHIVE.getBlocks());
}
