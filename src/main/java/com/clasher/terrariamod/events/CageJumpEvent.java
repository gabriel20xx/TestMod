package com.clasher.terrariamod.events;

import com.clasher.terrariamod.TerrariaMod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CageJumpEvent {

    @SubscribeEvent
    public static void CageJumpEvent(LivingEvent.LivingUpdateEvent event) {
        //      TerrariaMod.LOGGER.info("");
    }
}