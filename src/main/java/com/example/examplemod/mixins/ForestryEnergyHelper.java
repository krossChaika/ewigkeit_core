package com.example.examplemod.mixins;

import forestry.energy.EnergyHelper;
import forestry.energy.ForestryEnergyStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnergyHelper.class)
public class ForestryEnergyHelper {
    @Inject(method = "consumeEnergyToDoWork", at = @At("RETURN"), remap = false)
    private static void onConsumeEnergyToDoWork(ForestryEnergyStorage energyStorage, int ticksPerWorkCycle, int energyPerWorkCycle, CallbackInfoReturnable<Boolean> cir){
        if (cir.getReturnValue()) return;
        
        energyStorage.drainEnergy(energyStorage.getEnergyStored());
    }
}
