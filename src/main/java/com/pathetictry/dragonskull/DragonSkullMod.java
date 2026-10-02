package com.pathetictry.dragonskull;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

/**
 * Client-side look: the Wither Skeleton Skull item is drawn with the game's own Dragon Head
 * item model and shows the Dragon Head's epic (light-purple) name. Uses Fabric API's official
 * default-component hook, so no risky hooks into game classes.
 */
public class DragonSkullMod implements ModInitializer {
    @Override
    public void onInitialize() {
        DefaultItemComponentEvents.MODIFY.register(context ->
            context.modify(Items.WITHER_SKELETON_SKULL, builder -> {
                builder.set(DataComponents.ITEM_MODEL, Identifier.withDefaultNamespace("dragon_head"));
                builder.set(DataComponents.RARITY, Rarity.EPIC);
            }));
    }
}
