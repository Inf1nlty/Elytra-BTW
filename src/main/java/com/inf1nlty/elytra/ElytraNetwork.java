package com.inf1nlty.elytra;

import api.BTWAddon;
import net.minecraft.src.*;

public final class ElytraNetwork {
    public static String CHANNEL_START;
    public static String CHANNEL_STOP;

    private ElytraNetwork() {}

    public static void register(BTWAddon addon) {
        CHANNEL_START = addon.getModID() + "|Start";
        CHANNEL_STOP = addon.getModID() + "|Stop";

        addon.registerPacketHandler(CHANNEL_START, (packet, player) -> {
            if (packet == null || player == null) return;

            ItemStack stack = player.inventory.armorItemInSlot(2);
            if (stack != null
                    && stack.getItem() instanceof ItemElytra
                    && !ItemElytra.isBroken(stack)
                    && !player.onGround
                    && !player.isInWater()
                    && player.motionY < 0.0D) {

                ElytraPhysics.setElytraFlying(player, true);
                ElytraPhysics.setTicksElytraFlying(player, 0);
            }
        });

        addon.registerPacketHandler(CHANNEL_STOP, (packet, player) -> {
            if (packet == null || player == null) return;

            ElytraPhysics.setElytraFlying(player, false);
            ElytraPhysics.setTicksElytraFlying(player, 0);
        });
    }
}