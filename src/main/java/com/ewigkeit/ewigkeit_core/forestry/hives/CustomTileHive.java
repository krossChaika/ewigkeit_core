package com.ewigkeit.ewigkeit_core.forestry.hives;

import com.ewigkeit.ewigkeit_core.forestry.feature.CustomApicultureTiles;
import forestry.apiculture.tiles.TileHive;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CustomTileHive extends TileHive {
    public CustomTileHive(BlockPos pos, BlockState state) {
        super(CustomApicultureTiles.HIVE.tileType(), pos, state);
    }
    
    @Override
    public void tick(Level level) {
        super.tick(level);
    }
}
