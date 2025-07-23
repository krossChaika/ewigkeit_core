package com.example.examplemod.mixins;

import org.apache.commons.lang3.reflect.FieldUtils;
import forestry.core.fluids.FilteredTank;
import forestry.core.fluids.TankManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import thedarkcolour.gendustry.blockentity.AbstractMutatronBlockEntity;
import java.util.Set;

@Mixin(AbstractMutatronBlockEntity.class)
public class GendustryMutatron {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstruct(CallbackInfo ci) throws IllegalAccessException {
        AbstractMutatronBlockEntity self = ((AbstractMutatronBlockEntity)(Object)this);
        
        Fluid gtMutagenFluid = ForgeRegistries.FLUIDS.getValue(ResourceLocation.parse("gtceu:mutagen"));
        FilteredTank newTank = new FilteredTank(10000).setFilters(Set.of(gtMutagenFluid));
        TankManager newTankManager = new TankManager(self);
        newTankManager.add(newTank);
        
        FieldUtils.writeField(self, "tankManager", newTankManager, true);
        FieldUtils.writeField(self, "mutagenTank", newTank, true);
    }
}
