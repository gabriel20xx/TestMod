package com.clasher.terrariamod.init;

import com.clasher.terrariamod.TerrariaMod;
import com.clasher.terrariamod.objects.items.SpecialItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TerrariaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TerrariaMod.MOD_ID)
public class ItemInit
{
    //Minerals
    public static final Item ruby = null;
    public static final Item sapphire = null;
    public static final Item copper_bar = null;
    public static final Item silver_bar = null;
    public static final Item special = null;

    //Tools
    public static final Item copper_shortsword = null;
    public static final Item copper_broadsword = null;
    public static final Item copper_pickaxe = null;
    public static final Item copper_axe = null;

    //Armor
    public static final Item copper_helmet = null;
    public static final Item copper_chainmail = null;
    public static final Item copper_leggings = null;
    public static final Item copper_greaves = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        //Materials
        event.getRegistry().register(new Item(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("ruby"));
        event.getRegistry().register(new Item(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("sapphire"));
        event.getRegistry().register(new Item(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("copper_bar"));
        event.getRegistry().register(new Item(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("silver_bar"));

        //Special
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("special_item"));

        //Food
        event.getRegistry().register(new Item(new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2f).setAlwaysEdible().effect(new EffectInstance(Effects.REGENERATION, 12000, 0), 1.0f).build())).setRegistryName("apple"));

        //Tools
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 4, 2.0F, new Item.Properties().group(TerrariaMod.TerrariaToolGroup.instance)).setRegistryName("copper_shortsword"));
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 5, 2.0F, new Item.Properties().group(TerrariaMod.TerrariaToolGroup.instance)).setRegistryName("copper_broadsword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 2, 2.0F, new Item.Properties().group(TerrariaMod.TerrariaToolGroup.instance)).setRegistryName("copper_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 2, 2.0F, new Item.Properties().group(TerrariaMod.TerrariaToolGroup.instance)).setRegistryName("copper_axe"));

        //Armor
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("copper_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("copper_chainmail"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("copper_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, new Item.Properties().group(TerrariaMod.TerrariaItemGroup.instance)).setRegistryName("copper_greaves"));

    }

    public enum ModItemTier implements IItemTier {
        EXAMPLE(2, 1500, 5.0F, 7.0F, 1, () -> {
           return Ingredient.fromItems(ItemInit.ruby);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

    public enum ModArmorMaterial implements IArmorMaterial {
        COPPER(TerrariaMod.MOD_ID + ":test", 5, new int[] {7, 9, 11, 8}, 420, SoundEvents.field_226142_fM_, 6.9F, () -> {
            return Ingredient.fromItems(ItemInit.copper_helmet);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModArmorMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}
