package com.clasher.terrariamod;

import com.clasher.terrariamod.init.*;
import com.clasher.terrariamod.world.gen.TerrariaOreGen;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("terrariamod")
@Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerrariaMod
{
    public static final String MOD_ID = "terrariamod";
    public static final Logger LOGGER = LogManager.getLogger();
    public static TerrariaMod instance;

    public TerrariaMod()
    {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventbus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventbus.addListener(this::setup);
        modEventbus.addListener(this::doClientStuff);

        ItemInitNew.ITEMS.register(modEventbus);
        BlockInitNew.BLOCKS.register(modEventbus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventbus);
        BiomeInit.BIOMES.register(modEventbus);


        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    //New Deferred Registry
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(TerrariaOtherGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("Registered BlockItems!");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    }

    //Ore Generation
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        TerrariaOreGen.generateRubyOre();
        TerrariaOreGen.generateCopperOre();
    }

    //Creative Tabs
    public static class TerrariaItemGroup extends ItemGroup {
        public static final TerrariaItemGroup instance = new TerrariaItemGroup(ItemGroup.GROUPS.length, "terrariaitemtab");
        private TerrariaItemGroup(int index, String label) {
            super(12, label);
        }

        @Override
        public ItemStack createIcon() { return new ItemStack(ItemInit.sapphire); }
    }

    public static class TerrariaBlockGroup extends ItemGroup {
        public static final TerrariaBlockGroup instance = new TerrariaBlockGroup(ItemGroup.GROUPS.length, "terrariablocktab");
        private TerrariaBlockGroup(int index, String label) {
            super(13, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.ruby_ore);
        }
    }

    public static class TerrariaToolGroup extends ItemGroup {
        public static final TerrariaToolGroup instance = new TerrariaToolGroup(ItemGroup.GROUPS.length, "terrariatooltab");
        private TerrariaToolGroup(int index, String label) {
            super(14, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.copper_pickaxe);
        }
    }

    public static class TerrariaCombatGroup extends ItemGroup {
        public static final TerrariaCombatGroup instance = new TerrariaCombatGroup(ItemGroup.GROUPS.length, "terrariacombattab");
        private TerrariaCombatGroup(int index, String label) {
            super(15, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.copper_chainmail);
        }
    }

    public static class TerrariaOtherGroup extends ItemGroup {
        public static final TerrariaOtherGroup instance = new TerrariaOtherGroup(ItemGroup.GROUPS.length, "terrariaothertab");
        private TerrariaOtherGroup(int index, String label) {
            super(16, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.table);
        }
    }
}
