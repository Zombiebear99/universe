package org.zombie.universe.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.zombie.universe.Config;
import org.zombie.universe.blocks.Modblocks;

import java.util.List;
import java.util.Objects;

public class InferiumUniverseBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public InferiumUniverseBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState p_60550_) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide) {
            if (player.getMainHandItem().is(Items.WOODEN_SWORD) && player.getOffhandItem().is(Objects::nonNull)) {
                ItemEntity item = new ItemEntity(level,
                        pos.getX() + 0.5,
                        pos.getY() + 16 / 16D + 0.2,
                        pos.getZ() + 0.5,
                        player.getOffhandItem().copy());
                item.setDefaultPickUpDelay();
                level.addFreshEntity(item);
            } else {
                List<Item> items = Config.inferium.stream().toList();
                int size = items.size();
                int bonus = Config.bonus + 1;

                for (Item value : items) {
                    ItemEntity item = new ItemEntity(level,
                            pos.getX() + 0.5,
                            pos.getY() + 16 / 16D + 0.2,
                            pos.getZ() + 0.5,
                            new ItemStack(value));
                    for (int j = 1; j <= bonus; j++) {
                        item.setDefaultPickUpDelay();
                        level.addFreshEntity(item);
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }


//        if(!level.isClientSide) {
////            ItemEntity item = new ItemEntity(level,
////                    pos.getX() + 0.5,
////                    pos.getY() + 16 / 16D + 0.2,
////                    pos.getZ() + 0.5,
////                    new ItemStack(Modblocks.CREATIVE_UNIVERSE.get()));
////            item.setDefaultPickUpDelay();
////            level.addFreshEntity(item);
//            List<Item> items = Config.inferium.stream().toList();
//            int size = items.size();
//            int bonus = Config.bonus+1;
//
//            for (Item value : items) {
//                ItemEntity item = new ItemEntity(level,
//                        pos.getX() + 0.5,
//                        pos.getY() + 16 / 16D + 0.2,
//                        pos.getZ() + 0.5,
//                        new ItemStack(value));
//                for (int j = 1; j <= bonus; j++) {
//                    item.setDefaultPickUpDelay();
//                    level.addFreshEntity(item);
//                }
//            }

}

