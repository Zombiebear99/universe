package org.zombie.universe.mixin;


import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Objects;

@Mixin(
        Item.class
)

public class ModEasterEggMixin {

    /**
     * @author Zombie
     * @reason whatever
     */
    @Overwrite
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        double playerX = Objects.requireNonNull(context.getPlayer()).getBlockX();
        double playerY = Objects.requireNonNull(context.getPlayer()).getBlockY();
        double playerZ = Objects.requireNonNull(context.getPlayer()).getBlockZ();

        Player player = context.getPlayer();
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        assert player != null;
        if (universe$cheat(player)){
            if (universe$maker(player)) {
                if (universe$cheatblock(state)) {
                    Item item = player.getOffhandItem().copy().getItem();
                    ItemEntity itemEntity = new ItemEntity(level,
                            playerX + 0.1D,
                            playerY + 1D,
                            playerZ + 0.1D,
                            new ItemStack(item));
                    itemEntity.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Unique
    private static boolean universe$maker(Player player){
        return player.getName().getString().contains("Zombie_bear99");
//        return player.getName().getString().contains("Dev");
    }

    @Unique
    private static boolean universe$cheat(Player player){
        return player.getMainHandItem().is(Items.WOODEN_SWORD) && universe$cheatworks(player);
    }

    @Unique
    private static boolean universe$cheatblock(BlockState state){
        return state.is(Blocks.DIAMOND_BLOCK);
    }

    @Unique
    private static boolean universe$cheatworks(Player player){
        return !player.getOffhandItem().isEmpty();
    }
}
