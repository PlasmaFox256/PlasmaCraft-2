package com.plasmafox256.plasmacraft.tools;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class FlintAxe extends AxeItem {
    public FlintAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, net.minecraft.entity.LivingEntity target, net.minecraft.entity.LivingEntity attacker) {
        stack.damage(1, attacker, (p) -> {
            p.sendToolBreakStatus(attacker.preferredHand);
        });
        if( Math.random() <= 0.3 ) {
            target.setFireTicks(80);
        }
        return true;
    }
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("item.plasmacraft.flint_sword.tooltip").formatted(Formatting.RED) );
    }
}
