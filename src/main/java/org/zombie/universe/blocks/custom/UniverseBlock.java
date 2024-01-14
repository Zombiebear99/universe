package org.zombie.universe.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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

public class UniverseBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public UniverseBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState p_60550_) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        Block inferium = Modblocks.INFERIUM_UNIVERSE.get();
        Block prudentium = Modblocks.PRUDENTIUM_UNIVERSE.get();
        Block tertium = Modblocks.TERTIUM_UNIVERSE.get();
        Block imperium = Modblocks.IMPERIUM_UNIVERSE.get();
        Block supremium = Modblocks.SUPREMIUM_UNIVERSE.get();
        Block insanium = Modblocks.INSANIUM_UNIVERSE.get();
        Block creative = Modblocks.CREATIVE_UNIVERSE.get();
        if (!level.isClientSide) {
            Block block = blockState.getBlock();
            if (block.equals(inferium)) {
                inferium_universe(level, player, pos);
            } else if (block.equals(prudentium)) {
                prudentium_universe(level, player, pos);
            } else if (block.equals(tertium)) {
                tertium_universe(level, player, pos);
            } else if (block.equals(imperium)) {
                imperium_universe(level, player, pos);
            } else if (block.equals(supremium)) {
                supremium_universe(level, player, pos);
            } else if (block.equals(insanium)) {
                insanium_universe(level, player, pos);
            } else if (block.equals(creative)) {
                creative_universe(level, player, pos);
            }
        }
        return InteractionResult.SUCCESS;
    }

    private static void inferium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.inferium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }
    private static void prudentium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.prudentium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

    private static void tertium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.tertium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

    private static void imperium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.imperium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

    private static void supremium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.supremium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

    private static void insanium_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.insanium.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

    private static void creative_universe(Level level, Player player, BlockPos pos){
        List<Item> items = Config.creative.stream().toList();
        UniverseDrops.spawn(level,items,player,pos);
    }

}
