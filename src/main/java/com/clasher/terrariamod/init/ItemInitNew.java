package com.clasher.terrariamod.init;

import com.clasher.terrariamod.TerrariaMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TerrariaMod.MOD_ID);

    public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new Item(new Item.Properties().group(TerrariaMod.TerrariaOtherGroup.instance)));
}
