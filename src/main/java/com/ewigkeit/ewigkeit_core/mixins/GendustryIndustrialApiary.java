package com.ewigkeit.ewigkeit_core.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import thedarkcolour.gendustry.blockentity.IndustrialApiaryBlockEntity;
// import thedarkcolour.gendustry.blockentity.IndustrialApiaryBeeModifier;

@Mixin(IndustrialApiaryBlockEntity.class)
public class GendustryIndustrialApiary {
    private static final int NEW_ENERGY_COST = 2048;
    
    // @Inject(method = "<init>", at = @At("RETURN"))
    // private void onConstructorReturn(BlockPos pos, BlockState state, CallbackInfo ci)
    //         throws NoSuchFieldException, IllegalAccessException {
    //
    //     ExampleMod.LOGGER.info("injected at ctor's return");
    //     IndustrialApiaryBlockEntity obj = ((IndustrialApiaryBlockEntity)(Object)this);
    //
    //     String fieldName = "energyConsumption";
    //     Field energyField = Arrays.stream(obj.getClass().getDeclaredFields())
    //             .filter(field -> field.getName().equals(fieldName))
    //             .findFirst().get();
    //
    //     energyField.setAccessible(true);
    //     // energyField.set(obj, 10000);
    //
    //     ExampleMod.LOGGER.info(energyField.get(obj).toString());
    // }
    
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 200))
    private int onConstructorEnergyConstantChange(int consumption) {
        return NEW_ENERGY_COST;
    }
    
    @ModifyConstant(method = "refreshUpgrades", constant = @Constant(intValue = 200), remap = false)
    private int onRefreshUpgrades(int consumption) {
        return NEW_ENERGY_COST;
    }
}
