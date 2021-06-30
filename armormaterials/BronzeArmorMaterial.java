package com.plasmafox256.plasmacraft.armormaterials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static com.plasmafox256.plasmacraft.Main.*;

public class BronzeArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {150, 200, 200, 100};
    private static final int[] PROTECTION_VALUES = new int[] {2, 4, 5, 2};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 2;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BRONZE_INGOT);
    }

    @Override
    public String getName() {
        return "bronze";
    }

    @Override
    public float getToughness() {
        return 0.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0F;
}}
