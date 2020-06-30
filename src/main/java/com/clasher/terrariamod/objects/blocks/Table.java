package com.clasher.terrariamod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.stream.Stream;


public class Table extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 2, 14, 2),
            Block.makeCuboidShape(0, 0, 14, 2, 14, 16),
            Block.makeCuboidShape(14, 0, 0, 16, 14, 2),
            Block.makeCuboidShape(14, 0, 14, 16, 14, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 2, 14, 2),
            Block.makeCuboidShape(0, 0, 14, 2, 14, 16),
            Block.makeCuboidShape(14, 0, 0, 16, 14, 2),
            Block.makeCuboidShape(14, 0, 14, 16, 14, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E= Stream.of(
            Block.makeCuboidShape(0, 0, 0, 2, 14, 2),
            Block.makeCuboidShape(0, 0, 14, 2, 14, 16),
            Block.makeCuboidShape(14, 0, 0, 16, 14, 2),
            Block.makeCuboidShape(14, 0, 14, 16, 14, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 2, 14, 2),
            Block.makeCuboidShape(0, 0, 14, 2, 14, 16),
            Block.makeCuboidShape(14, 0, 0, 16, 14, 2),
            Block.makeCuboidShape(14, 0, 14, 16, 14, 16),
            Block.makeCuboidShape(0, 14, 0, 16, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Table(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            ServerWorld serverWorld = (ServerWorld)worldIn;
            LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
            serverWorld.addLightningBolt(entity);
        }
        return ActionResultType.SUCCESS;
    }
}

