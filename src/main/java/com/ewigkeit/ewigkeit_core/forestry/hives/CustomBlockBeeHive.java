package com.ewigkeit.ewigkeit_core.forestry.hives;

import com.ewigkeit.ewigkeit_core.forestry.feature.CustomApicultureTiles;
import forestry.apiculture.blocks.BlockBeeHive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class CustomBlockBeeHive extends BlockBeeHive {
    public CustomBlockBeeHive(CustomBlockHiveType type) {
        super(type.getSpeciesId());
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> actualType) {
        return actualType != CustomApicultureTiles.HIVE.tileType() ? null : (level1, pos, state1, t) -> ((CustomTileHive) t).tick(level1);
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CustomTileHive(pos, state);
    }
}
