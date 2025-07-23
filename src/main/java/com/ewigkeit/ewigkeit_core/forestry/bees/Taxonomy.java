package com.ewigkeit.ewigkeit_core.forestry.bees;

import forestry.api.genetics.ForestryTaxa;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.plugin.IGeneticRegistration;

public class Taxonomy {
    public static void registerTaxa(IGeneticRegistration genetics){
        genetics.defineTaxon(ForestryTaxa.CLASS_INSECTS, ForestryTaxa.ORDER_HYMNOPTERA, order -> {
            order.defineSubTaxon(ForestryTaxa.FAMILY_BEES, family -> {
                // Moon
                family.defineSubTaxon(Genus.MOON, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORTENED);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_CATHEMERAL);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_NORMAL);
                    // genus.setDefaultChromosome(BeeChromosomes.FLOWER_TYPE, MoreBeesAlleles.FLOWER_TYPE_ROCK);
                });
            });
        });
    }
}
