package org.zombie.universe.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.zombie.universe.Config;

import java.util.List;

public class UniverseDrops {
    private static int bonus = Config.bonus + 1;
    public static void spawn(Level level, List<Item> items, Player player, BlockPos pos){
        if (!level.isClientSide()) {
            int size = items.size();
            for (Item value : items) {
                ItemEntity item = new ItemEntity(level,
                        pos.getX() + 0.5,
                        pos.getY() + 0.8,
                        pos.getZ() + 0.5,
                        new ItemStack(value));
                for (int j = 1; j <= bonus; j++) {
                    item.setDefaultPickUpDelay();
                    level.addFreshEntity(item);
                }
            }
        }
    }
}
