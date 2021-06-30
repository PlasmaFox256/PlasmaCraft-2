package com.plasmafox256.plasmacraft.toolmaterials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static com.plasmafox256.plasmacraft.Main.STEEL_INGOT;

public class SteelToolMaterial implements ToolMaterial {
    public static final SteelToolMaterial INSTANCE = new SteelToolMaterial();
    @Override
    public int getDurability() {
        return 1000;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 6F;
    }
    @Override
    public float getAttackDamage() {
        return 2.0F;
    }
    @Override
    public int getMiningLevel() {
        return 2;
    }
    @Override
    public int getEnchantability() {
        return 14;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(STEEL_INGOT);
    }
}
