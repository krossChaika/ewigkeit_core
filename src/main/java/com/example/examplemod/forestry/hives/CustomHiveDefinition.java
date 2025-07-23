package com.example.examplemod.forestry.hives;

import com.example.examplemod.forestry.bees.Species;
import com.example.examplemod.forestry.feature.CustomApicultureBlocks;
import com.noodlepfp.mobees.core.data.tag.MoreBeesTags;
import forestry.api.ForestryTags;
import forestry.api.apiculture.genetics.IBeeSpecies;
import forestry.api.apiculture.hives.IHiveDefinition;
import forestry.api.apiculture.hives.IHiveGen;
import forestry.api.core.HumidityType;
import forestry.api.core.TemperatureType;
import forestry.api.core.ToleranceType;
import forestry.api.genetics.ClimateHelper;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.apiculture.blocks.BlockHiveType;
import forestry.apiculture.features.ApicultureBlocks;
import forestry.apiculture.hives.HiveDefinition;
import forestry.apiculture.hives.HiveGenGround;
import forestry.core.utils.SpeciesUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

import static forestry.api.ForestryTags.*;

public enum CustomHiveDefinition implements IHiveDefinition {
    MOON(CustomApicultureBlocks.BEEHIVE.get(CustomBlockHiveType.MOON).defaultState(), 2.0f, Species.MOON,
            new HiveGenGround(MoreBeesTags.Blocks.ALPINE_HIVE_GROUNDS)) {
        @Override
        public boolean isGoodBiome(Holder<Biome> biome) {
            return biome.is(BiomeTags.IS_MOUNTAIN);
        }
        
        @Override
        public boolean isGoodHumidity(HumidityType humidity) {
            return true;
        }
        
        @Override
        public boolean isGoodTemperature(TemperatureType temperature) {
            return true;
        }
    };
    
    private final BlockState blockState;
    private final float genChance;
    private final ResourceLocation speciesId;
    private final IHiveGen hiveGen;
    
    CustomHiveDefinition(BlockState blockState, float genChance, ResourceLocation speciesId, IHiveGen hiveGen) {
        this.blockState = blockState;
        this.genChance = genChance;
        this.speciesId = speciesId;
        this.hiveGen = hiveGen;
    }
    
    @Override
    public IHiveGen getHiveGen() {
        return this.hiveGen;
    }
    
    @Override
    public BlockState getBlockState() {
        return this.blockState;
    }
    
    @Override
    public boolean isGoodBiome(Holder<Biome> biome) {
        return !biome.is(BiomeTags.IS_NETHER);
    }
    
    @Override
    public boolean isGoodHumidity(HumidityType humidity) {
        IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
        HumidityType idealHumidity = species.getHumidity();
        ToleranceType humidityTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.HUMIDITY_TOLERANCE);
        return ClimateHelper.isWithinLimits(humidity, idealHumidity, humidityTolerance);
    }
    
    @Override
    public boolean isGoodTemperature(TemperatureType temperature) {
        IBeeSpecies species = SpeciesUtil.getBeeSpecies(this.speciesId);
        TemperatureType idealTemperature = species.getTemperature();
        ToleranceType temperatureTolerance = species.getDefaultGenome().getActiveValue(BeeChromosomes.TEMPERATURE_TOLERANCE);
        return ClimateHelper.isWithinLimits(temperature, idealTemperature, temperatureTolerance);
    }
    
    @Override
    public float getGenChance() {
        return this.genChance;
    }
    
    @Override
    public void postGen(WorldGenLevel level, RandomSource rand, BlockPos pos) {
    }
}
