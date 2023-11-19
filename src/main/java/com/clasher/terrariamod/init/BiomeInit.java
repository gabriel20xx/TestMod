package com.clasher.terrariamod.init;

import com.clasher.terrariamod.TerrariaMod;
import com.clasher.terrariamod.world.biomes.CorruptionBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TerrariaMod.MOD_ID);


    //Register new Biome here
    public static final RegistryObject<Biome> CORRUPTION_BIOME = BIOMES.register("corruption_biome", () -> new CorruptionBiome(new Biome.Builder().precipitation(Biome.RainType.SNOW)
            .scale(1.2f)
            .temperature(0.5f)
            .waterColor(16724639)
            .waterFogColor(0xFFFFFF)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), BlockInit.ebonstone_block.getDefaultState(), BlockInit.ebonstone_block.getDefaultState()))
            .category(Biome.Category.PLAINS)
            .downfall(0.5f)
            .depth(0.05f)
            .parent(null)));


    //Register new Biome here
    public static void registerBiomes() {
        registerBiome(CORRUPTION_BIOME.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
