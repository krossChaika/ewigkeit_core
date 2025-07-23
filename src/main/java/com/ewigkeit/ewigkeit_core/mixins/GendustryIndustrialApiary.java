package com.ewigkeit.ewigkeit_core.mixins;

import com.ewigkeit.ewigkeit_core.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import thedarkcolour.gendustry.blockentity.IndustrialApiaryBlockEntity;

@Mixin(IndustrialApiaryBlockEntity.class)
public class GendustryIndustrialApiary {
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 200))
    private int onConstructorEnergyConstantChange(int consumption) {
        return Config.gendustryIndustrialApiaryEnergyConsumption;
    }
    
    @ModifyConstant(method = "refreshUpgrades", constant = @Constant(intValue = 200), remap = false)
    private int onRefreshUpgrades(int consumption) {
        return Config.gendustryIndustrialApiaryEnergyConsumption;
    }
}
