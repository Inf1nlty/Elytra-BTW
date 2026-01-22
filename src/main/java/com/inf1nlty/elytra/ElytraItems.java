package com.inf1nlty.elytra;

import net.minecraft.src.Item;

public class ElytraItems {
    public static Item elytra;

    public static void registerItems() {
        elytra = new ItemElytra(23603);
        Item.itemsList[elytra.itemID] = elytra;
    }
}