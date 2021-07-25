package gregtech.common.tools;

import gregtech.api.item.toolitem.ToolItem;
import gregtech.api.item.toolitem.ToolItemSettings;
import gregtech.api.item.toolitem.ToolItemType;
import gregtech.api.unification.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

public class MiningToolItem extends ToolItem {

    public MiningToolItem(ToolItemSettings settings, ToolItemType toolItemType, Material material) {
        super(settings, toolItemType, material);
    }

    @Override
    public boolean canApplyEnchantment(Enchantment enchantment) {
        return enchantment.type == EnchantmentTarget.DIGGER ||
                enchantment.type.isAcceptableItem(this);
    }
}
