package com.inf1nlty.elytra;

import btw.item.BTWItems;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Item;
import net.minecraft.src.CraftingManager;

public class ElytraRecipes {
    public static void registerRecipes() {
        CraftingManager.getInstance().addRecipe(
                new ItemStack(ElytraItems.elytra),
                "LSL",
                "LEL",
                " F ",
                'L', Item.leather,
                'F', Item.feather,
                'S', Item.silk,
                'E', BTWItems.enderSlag
        );
    }
}