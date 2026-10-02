package com.pathetictry.dragonskull.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.SkullBlock;

@Mixin(AbstractSkullBlock.class)
public abstract class AbstractSkullBlockMixin {
    @Inject(method = "getType", at = @At("RETURN"), cancellable = true)
    private void dragonskull$swapType(CallbackInfoReturnable<SkullBlock.Type> cir) {
        if (cir.getReturnValue() == SkullBlock.Types.WITHER_SKELETON && Minecraft.getInstance().isSameThread()) {
            cir.setReturnValue(SkullBlock.Types.DRAGON);
        }
    }
}
