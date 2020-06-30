package com.clasher.terrariamod.events;

import com.clasher.terrariamod.TerrariaMod;
import com.clasher.terrariamod.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ScaffoldWalkEvent {

    @SubscribeEvent
    public static void ScaffoldWalkEvent(LivingEvent.LivingUpdateEvent event) {
  //      TerrariaMod.LOGGER.info("");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        world.setBlockState(livingEntity.getPosition().add(0, 0, 0), Blocks.AIR.getDefaultState());
        livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 2));
        livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 600, 4));
    }
}
