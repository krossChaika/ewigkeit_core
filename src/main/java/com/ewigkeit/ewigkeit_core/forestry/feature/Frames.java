package com.ewigkeit.ewigkeit_core.forestry.feature;
import com.noodlepfp.mobees.MoBeesModule;
import com.noodlepfp.mobees.item.*;
import forestry.modules.features.*;
import forestry.modules.features.ModFeatureRegistry;

@FeatureProvider
public class Frames {
    public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(MoBeesModule.mobees("core"));
    public static final FeatureItem<MoreBeesItemHiveFrame> FRAME_OBLIVION
            = REGISTRY.item(() -> new MoreBeesItemHiveFrame
            .MoreBeesItemHiveFrameBuilder(64)
            .setAgeMult(100000f)
            .setSpeedMult(1f)
            .setMutationMult(1.25f)
            .setDecayMult(1f)
            .build(), "frame_oblivion");
}
