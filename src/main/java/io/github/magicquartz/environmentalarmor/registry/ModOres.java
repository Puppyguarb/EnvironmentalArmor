package io.github.magicquartz.environmentalarmor.registry;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.OreFeatureConfig;

//Mod ID, used for registering the ore.
import static io.github.magicquartz.environmentalarmor.Main.MOD_ID;


public class ModOres {
    private static final ConfiguredFeature<?, ?> TITANIUM_ORE_END = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.TITANIUM_ORE.getDefaultState(), 9));
    private static final PlacedFeature TITANIUM_ORE_PLACE = TITANIUM_ORE_END.withPlacement(CountPlacementModifier.of(10), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));


    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "titanium_ore"), TITANIUM_ORE_END);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MOD_ID, "titanium_ore"), TITANIUM_ORE_PLACE);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MOD_ID, "titanium_ore")));
    }
}
