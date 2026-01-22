package com.inf1nlty.elytra.mixin.item;

import com.inf1nlty.elytra.ElytraPhysics;
import com.inf1nlty.elytra.IEntityFireworkRocket;

import net.minecraft.src.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {

    @Inject(method = "onItemRightClick", at = @At("HEAD"), cancellable = true)
    private void elytra$onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, CallbackInfoReturnable<ItemStack> cir) {

        if (itemStack == null) return;

        if (!(itemStack.getItem() instanceof ItemFirework)) return;

        if (!ElytraPhysics.getElytraFlying(player)) return;

        double x = player.posX;
        double y = player.posY + player.getEyeHeight();
        double z = player.posZ;

        EntityFireworkRocket rocket = new EntityFireworkRocket(world, x, y, z, itemStack.copy());
        world.spawnEntityInWorld(rocket);

        ((IEntityFireworkRocket) rocket).elytra$setAttachedPlayerId(player.entityId);

        if (!world.isRemote && !player.capabilities.isCreativeMode) {
            itemStack.stackSize--;
        }

        cir.setReturnValue(itemStack);
    }
}
