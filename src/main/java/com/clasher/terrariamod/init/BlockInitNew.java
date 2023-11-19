package com.clasher.terrariamod.init;

import com.clasher.terrariamod.TerrariaMod;
import com.clasher.terrariamod.objects.blocks.ModWoodButtonBlock;
import com.clasher.terrariamod.objects.blocks.ModWoodPressurePlateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInitNew {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TerrariaMod.MOD_ID);

    public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> EXAMPLE_STAIRS = BLOCKS.register("example_stairs", () -> new StairsBlock(() -> BlockInitNew.DEF_BLOCK.get().getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
    public static final RegistryObject<Block> EXAMPLE_FENCE = BLOCKS.register("example_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
    public static final RegistryObject<Block> EXAMPLE_BUTTON = BLOCKS.register("example_button", () -> new ModWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
    public static final RegistryObject<Block> EXAMPLE_PRESSURE_PLATE = BLOCKS.register("example_pressure_plate", () -> new ModWoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
}
