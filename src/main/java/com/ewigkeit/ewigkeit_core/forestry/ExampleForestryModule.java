package com.ewigkeit.ewigkeit_core.forestry;

import com.ewigkeit.ewigkeit_core.EwigkeitCore;
import forestry.api.client.IClientModuleHandler;
import forestry.api.modules.IForestryModule;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class ExampleForestryModule implements IForestryModule {
    @Override
    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(EwigkeitCore.MOD_ID, "forestry");
    }
    
    @Override
    public void registerClientHandler(Consumer<IClientModuleHandler> registrar) {
        EwigkeitCore.LOGGER.info("Registering ClientModuleHandler");
        //registrar.accept(new CoreClientHandler());
    }
}
