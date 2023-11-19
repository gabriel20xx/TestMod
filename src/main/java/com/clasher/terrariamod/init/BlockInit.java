package com.clasher.terrariamod.init;

import com.clasher.terrariamod.TerrariaMod;
import com.clasher.terrariamod.objects.blocks.Table;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TerrariaMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    //Ore Blocks
    public static final Block ruby_ore = null;
    public static final Block sapphire_ore = null;
    public static final Block amethyst_ore = null;
    public static final Block topaz_ore = null;
    public static final Block copper_ore_block = null;
    public static final Block ebonstone_block = null;

    //Custom Blocks
    public static final Block table = null;

    //Other Blocks
    public static final Block quarry = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {

        //Ore Blocks
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sapphire_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("amethyst_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("topaz_ore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("copper_ore_block"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ebonstone_block"));

        //Custom Blocks
        event.getRegistry().register(new Table(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                .sound(SoundType.GLASS).lightValue(4).slipperiness(1.2f).speedFactor(0.7f).noDrops()).setRegistryName("table"));

        //Other Blocks
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("quarry"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {

        //Ore Blocks
        event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("ruby_ore"));
        event.getRegistry().register(new BlockItem(sapphire_ore, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("sapphire_ore"));
        event.getRegistry().register(new BlockItem(amethyst_ore, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("amethyst_ore"));
        event.getRegistry().register(new BlockItem(topaz_ore, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("topaz_ore"));
        event.getRegistry().register(new BlockItem(copper_ore_block, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("copper_ore_block"));
        event.getRegistry().register(new BlockItem(ebonstone_block, new Item.Properties().group(TerrariaMod.TerrariaBlockGroup.instance)).setRegistryName("ebonstone_block"));

        //Custom Blocks
        event.getRegistry().register(new BlockItem(table, new Item.Properties().group(TerrariaMod.TerrariaOtherGroup.instance)).setRegistryName("table"));

        //Other Blocks
        event.getRegistry().register(new BlockItem(quarry, new Item.Properties().group(TerrariaMod.TerrariaOtherGroup.instance)).setRegistryName("quarry"));
    }
}
