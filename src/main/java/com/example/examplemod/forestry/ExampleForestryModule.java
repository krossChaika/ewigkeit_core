package com.example.examplemod.forestry;

import com.example.examplemod.ExampleMod;
import forestry.api.client.IClientModuleHandler;
import forestry.api.modules.IForestryModule;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class ExampleForestryModule implements IForestryModule {
    @Override
    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "forestry");
    }
    
    @Override
    public void registerClientHandler(Consumer<IClientModuleHandler> registrar) {
        ExampleMod.LOGGER.info("Registering ClientModuleHandler");
        //registrar.accept(new CoreClientHandler());
    }
}
