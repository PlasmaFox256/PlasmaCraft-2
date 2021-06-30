package com.plasmafox256.plasmacraft.toolmaterials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FlintToolMaterial implements ToolMaterial {
    public static final FlintToolMaterial INSTANCE = new FlintToolMaterial();
    @Override
    public int getDurability() {
        return 150;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 4;
    }
    @Override
    public float getAttackDamage() {
        return 1.0F;
    }
    @Override
    public int getMiningLevel() {
        return 1;
    }
    @Override
    public int getEnchantability() {
        return 5;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.FLINT);
    }
}
