package net.cameronos.cookingwithcameron;

import net.cameronos.cookingwithcameron.block.ModBlocks;
import net.cameronos.cookingwithcameron.block.entity.ModBlockEntities;
import net.cameronos.cookingwithcameron.entity.ModEntities;
import net.cameronos.cookingwithcameron.entity.client.CrabRenderer;
import net.cameronos.cookingwithcameron.entity.custom.CrabEntity;
import net.cameronos.cookingwithcameron.item.ModItems;
import net.cameronos.cookingwithcameron.particle.ModParticles;
import net.cameronos.cookingwithcameron.particle.custom.WineParticle;
import net.cameronos.cookingwithcameron.recipe.ModRecipes;
import net.cameronos.cookingwithcameron.screen.DistilleryScreen;
import net.cameronos.cookingwithcameron.screen.ModScreenHandlers;
import net.cameronos.cookingwithcameron.util.ModLootTableModifiers;
import net.cameronos.cookingwithcameron.world.dimension.ModDimensions;
import net.cameronos.cookingwithcameron.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookingWithCameron implements ModInitializer {

	/*Don't touch*/
	public static final String MOD_ID = "cookingwithcameron";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/*Sound stuff */
	public static final Identifier TAPESOUND = new Identifier("cookingwithcameron:tapesound");
	public static SoundEvent TAPESOUNDEVENT = new SoundEvent(TAPESOUND);
	public static final Identifier BEERSOUND = new Identifier("cookingwithcameron:beersound");
	public static SoundEvent BEERSOUNDEVENT = new SoundEvent(BEERSOUND);
	public static final Identifier PLATESOUND = new Identifier("cookingwithcameron:platesound");
	public static SoundEvent PLATESOUNDEVENT = new SoundEvent(PLATESOUND);
	public static final Identifier DISTILLERSOUND = new Identifier("cookingwithcameron:distillersound");
	public static SoundEvent DISTILLERSOUNDEVENT = new SoundEvent(DISTILLERSOUND);

	/*/crabsounds/*/
	public static final Identifier CRABAMBIENT = new Identifier("cookingwithcameron:crabambient");
	public static SoundEvent CRABAMBIENTSOUNDEVENT = new SoundEvent(CRABAMBIENT);
	public static final Identifier CRABHURT = new Identifier("cookingwithcameron:crabhurt");
	public static SoundEvent CRABHURTSOUNDEVENT = new SoundEvent(CRABHURT);
	public static final Identifier CRABDEATH = new Identifier("cookingwithcameron:crabdeath");
	public static SoundEvent CRABDEATHSOUNDEVENT = new SoundEvent(CRABDEATH);
	/*/backtonormal/*/
	private static void registerAttributes(){
		FabricDefaultAttributeRegistry.register(ModEntities.CRAB, CrabEntity.setAttributes());
	}

	@Override
	public void onInitialize() {
		/*Blocks, items*/
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		registerAttributes();
		/*Transparency*/
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAPERECORDER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OVEN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_VINE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_TREE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINEAPPLE_SHRUB, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putItem(ModItems.WINE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINE_RACK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DISTILLERY, RenderLayer.getCutout());
		/*Sounds*/
		Registry.register(Registry.SOUND_EVENT, CookingWithCameron.TAPESOUND, TAPESOUNDEVENT);
		Registry.register(Registry.SOUND_EVENT, CookingWithCameron.BEERSOUND, BEERSOUNDEVENT);
		Registry.register(Registry.SOUND_EVENT, CookingWithCameron.PLATESOUND, PLATESOUNDEVENT);
		Registry.register(Registry.SOUND_EVENT, CookingWithCameron.DISTILLERSOUND, DISTILLERSOUNDEVENT);
		/*Loottables, particles*/
		ModLootTableModifiers.modifyLootTables();
		ModParticles.registerParticles();
		ParticleFactoryRegistry.getInstance().register(ModParticles.WINE_PARTICLE, WineParticle.Factory::new);
		/*Dimensions, GUI*/
		ModDimensions.register();
		ModBlockEntities.registerAllBlockEntities();
		ModWorldGen.generateModWorldGen();
		ModRecipes.registerRecipes();
		/*/Entity/*/
		EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
		/*/Screenhandlers/*/
		ModScreenHandlers.registerAllScreenHandlers();
		ScreenRegistry.register(ModScreenHandlers.DISTILLERY_SCREENHANDLER, DistilleryScreen::new);
	}
}
