package com.plasmafox256.plasmacraft.toolmaterials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static com.plasmafox256.plasmacraft.Main.BRONZE_INGOT;
import static com.plasmafox256.plasmacraft.Main.STEEL_INGOT;

public class BronzeToolMaterial implements ToolMaterial {
    public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();
    @Override
    public int getDurability() {
        return 500;
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
        return Ingredient.ofItems(BRONZE_INGOT);
    }
}
