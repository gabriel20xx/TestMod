package com.clasher.terrariamod;

import com.clasher.terrariamod.init.BlockInit;
import com.clasher.terrariamod.init.ItemInit;
import com.clasher.terrariamod.world.gen.TerrariaOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("terrariamod")
public class TerrariaMod
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "terrariamod";
    public static TerrariaMod instance;

    public TerrariaMod()
    {
        final IEventBus modEventbus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventbus.addListener(this::setup);
        modEventbus.addListener(this::doClientStuff);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
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

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        TerrariaOreGen.generateRubyOre();
    }

    public static class TerrariaItemGroup extends ItemGroup {
        public static final TerrariaItemGroup instance = new TerrariaItemGroup(ItemGroup.GROUPS.length, "terrariaitemtab");
        private TerrariaItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.ruby);
        }

    }

    public static class TerrariaBlockGroup extends ItemGroup {
        public static final TerrariaBlockGroup instance = new TerrariaBlockGroup(ItemGroup.GROUPS.length, "terrariablocktab");
        private TerrariaBlockGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.ruby_ore);
        }
    }

    public static class TerrariaToolGroup extends ItemGroup {
        public static final TerrariaToolGroup instance = new TerrariaToolGroup(ItemGroup.GROUPS.length, "terrariatooltab");
        private TerrariaToolGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.copper_broadsword);
        }
    }
}
