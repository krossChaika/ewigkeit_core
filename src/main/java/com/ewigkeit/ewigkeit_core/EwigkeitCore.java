package com.ewigkeit.ewigkeit_core;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EwigkeitCore.MOD_ID)
public class EwigkeitCore
{
    public static final String MOD_ID = "ewigkeit_core";
    
    public static ServiceLocator Services;

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    // public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () ->
    //         new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    //
    // public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () ->
    //         new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
    //
    // public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
    //         new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    // public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
    //         .withTabsBefore(CreativeModeTabs.COMBAT)
    //         .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
    //         .displayItems((parameters, output) -> {
    //             output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
    //         }).build());

    public EwigkeitCore(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
        // modEventBus.addListener(this::addCreative); // Register the item to a creative tab

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
        new GendustryTweaks(LOGGER).Run();
        // Dictionary<Class<?>, Supplier<?>> dictionary = new Hashtable<>();
        // dictionary.put(Logger.class, () -> LOGGER);
        // Services = new ServiceLocator(new ServiceLocatorBindings(dictionary));
        LOGGER.info("EwigkeitCore loaded");
        CreativeModeTabs.allTabs().forEach(x -> LOGGER.info(x.getDisplayName().getString()));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // LOGGER.info("HELLO FROM COMMON SETUP");
        //
        // if (Config.logDirtBlock)
        //     LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        //
        // LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        //
        // Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            // event.accept(EXAMPLE_BLOCK_ITEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
    
    public static ResourceLocation getResourceLocation(String path){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
