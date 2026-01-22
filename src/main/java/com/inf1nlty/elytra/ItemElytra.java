package com.inf1nlty.elytra;

import api.item.items.ArmorItem;
import net.minecraft.src.*;

public class ItemElytra extends ArmorItem {
    public ItemElytra(int id) {
        super(id, EnumArmorMaterial.CLOTH, 0, 1, 0);
        this.maxStackSize = 1;
        this.setMaxDamage(432);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setTextureName("elytra:elytra");
        this.setUnlocalizedName("elytra");
        this.damageReduceAmount = 0;
    }

    public static final DamageSource flyIntoWall = DamageSource.inWall;

    public static boolean isBroken(ItemStack stack) {
        return stack.getItemDamage() >= stack.getMaxDamage() - 1;
    }

    @Override
    public boolean getIsRepairable(ItemStack stack, ItemStack material) {
        return material.itemID == Item.leather.itemID;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        int slot = 2;
        ItemStack equipped = player.inventory.armorItemInSlot(slot);
        if (equipped == null) {
            player.inventory.setInventorySlotContents(36 + slot, stack.copy());
            stack.stackSize = 0;
        }
        return stack;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int renderPass) {
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, java.util.List list, boolean advanced) {
        if (stack.isItemDamaged()) {
            int remaining = stack.getMaxDamage() - stack.getItemDamage();
            int max = stack.getMaxDamage();
            list.add(StatCollector.translateToLocalFormatted("item.elytra.tooltip", remaining, max));
        }
    }
}