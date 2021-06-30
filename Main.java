package com.plasmafox256.plasmacraft;

import com.plasmafox256.plasmacraft.armormaterials.BronzeArmorMaterial;
import com.plasmafox256.plasmacraft.armormaterials.SteelArmorMaterial;
import com.plasmafox256.plasmacraft.blocks.storage.bronze_box.BronzeBoxBlock;
import com.plasmafox256.plasmacraft.blocks.storage.bronze_box.BronzeBoxBlockEntity;
import com.plasmafox256.plasmacraft.blocks.storage.bronze_box.BronzeBoxScreenHandler;
import com.plasmafox256.plasmacraft.blocks.storage.stainless_steel_box.StainlessSteelBoxBlock;
import com.plasmafox256.plasmacraft.blocks.storage.stainless_steel_box.StainlessSteelBoxBlockEntity;
import com.plasmafox256.plasmacraft.blocks.storage.stainless_steel_box.StainlessSteelBoxScreenHandler;
import com.plasmafox256.plasmacraft.blocks.storage.steel_box.SteelBoxBlock;
import com.plasmafox256.plasmacraft.blocks.storage.steel_box.SteelBoxBlockEntity;
import com.plasmafox256.plasmacraft.blocks.storage.steel_box.SteelBoxScreenHandler;
import com.plasmafox256.plasmacraft.blocks.storage.stone_box.StoneBoxBlock;
import com.plasmafox256.plasmacraft.blocks.storage.stone_box.StoneBoxBlockEntity;
import com.plasmafox256.plasmacraft.blocks.storage.stone_box.StoneBoxScreenHandler;
import com.plasmafox256.plasmacraft.blocks.storage.wooden_box.WoodenBoxBlock;
import com.plasmafox256.plasmacraft.blocks.storage.wooden_box.WoodenBoxBlockEntity;
import com.plasmafox256.plasmacraft.blocks.storage.wooden_box.WoodenBoxScreenHandler;
import com.plasmafox256.plasmacraft.toolmaterials.BronzeToolMaterial;
import com.plasmafox256.plasmacraft.toolmaterials.FlintToolMaterial;
import com.plasmafox256.plasmacraft.toolmaterials.SteelToolMaterial;
import com.plasmafox256.plasmacraft.tools.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class Main implements ModInitializer {
	public static final Block WOODEN_BOX_BLOCK;
	public static final BlockItem WOODEN_BOX_BLOCK_ITEM;
	public static final BlockEntityType<WoodenBoxBlockEntity> WOODEN_BOX_BLOCK_ENTITY;
	public static final Block STONE_BOX_BLOCK;
	public static final BlockItem STONE_BOX_BLOCK_ITEM;
	public static final BlockEntityType<StoneBoxBlockEntity> STONE_BOX_BLOCK_ENTITY;
	public static final Block BRONZE_BOX_BLOCK;
	public static final BlockItem BRONZE_BOX_BLOCK_ITEM;
	public static final BlockEntityType<BronzeBoxBlockEntity> BRONZE_BOX_BLOCK_ENTITY;
	public static final Block STEEL_BOX_BLOCK;
	public static final BlockItem STEEL_BOX_BLOCK_ITEM;
	public static final BlockEntityType<SteelBoxBlockEntity> STEEL_BOX_BLOCK_ENTITY;
	public static final Block STAINLESS_STEEL_BOX_BLOCK;
	public static final BlockItem STAINLESS_STEEL_BOX_BLOCK_ITEM;
	public static final BlockEntityType<StainlessSteelBoxBlockEntity> STAINLESS_STEEL_BOX_BLOCK_ENTITY;
	public static final String MOD_ID = "plasmacraft";
	// a public identifier for multiple parts of our bigger chest
	public static final Identifier WOODEN_BOX = new Identifier(MOD_ID, "wooden_box_block");
	public static final ScreenHandlerType<WoodenBoxScreenHandler> WOODEN_BOX_SCREEN_HANDLER;
	public static final Identifier STONE_BOX = new Identifier(MOD_ID, "stone_box_block");
	public static final ScreenHandlerType<StoneBoxScreenHandler> STONE_BOX_SCREEN_HANDLER;
	public static final Identifier BRONZE_BOX = new Identifier(MOD_ID, "bronze_box_block");
	public static final ScreenHandlerType<BronzeBoxScreenHandler> BRONZE_BOX_SCREEN_HANDLER;
	public static final Identifier STEEL_BOX = new Identifier(MOD_ID, "steel_box_block");
	public static final ScreenHandlerType<SteelBoxScreenHandler> STEEL_BOX_SCREEN_HANDLER;
	public static final Identifier STAINLESS_STEEL_BOX = new Identifier(MOD_ID, "stainless_steel_box_block");
	public static final ScreenHandlerType<StainlessSteelBoxScreenHandler> STAINLESS_STEEL_BOX_SCREEN_HANDLER;
	public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new SteelArmorMaterial();
	public static final ArmorMaterial BRONZE_ARMOR_MATERIAL = new BronzeArmorMaterial();
	public static final Item STEEL_HELMET = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
	public static final Item STEEL_CHESTPLATE = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
	public static final Item STEEL_LEGGINGS = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
	public static final Item STEEL_BOOTS = new ArmorItem(STEEL_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());
	public static final Item BRONZE_HELMET = new ArmorItem(BRONZE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
	public static final Item BRONZE_CHESTPLATE = new ArmorItem(BRONZE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
	public static final Item BRONZE_LEGGINGS = new ArmorItem(BRONZE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
	public static final Item BRONZE_BOOTS = new ArmorItem(BRONZE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());
	public static final Block STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3).resistance(3).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES,1).requiresTool());
	public static final Block TIN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	public static final Block RAW_TIN_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).hardness(5).resistance(6).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool());
	public static ToolItem FLINT_SWORD = new FlintSword(FlintToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings());
	public static ToolItem FLINT_AXE = new FlintAxe(FlintToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings());
	public static ToolItem FLINT_HOE = new FlintHoe(FlintToolMaterial.INSTANCE, -1, -2.0F, new Item.Settings());
	public static ToolItem FLINT_SHOVEL = new FlintShovel(FlintToolMaterial.INSTANCE, 2, -3F, new Item.Settings());
	public static ToolItem FLINT_PICKAXE = new FlintPickaxe(FlintToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
	public static ToolItem BRONZE_SWORD = new BronzeSword(BronzeToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings());
	public static ToolItem BRONZE_AXE = new BronzeAxe(BronzeToolMaterial.INSTANCE, 6, -3.1F, new Item.Settings());
	public static ToolItem BRONZE_HOE = new BronzeHoe(BronzeToolMaterial.INSTANCE, -2, -1.0F, new Item.Settings());
	public static ToolItem BRONZE_SHOVEL = new BronzeShovel(BronzeToolMaterial.INSTANCE, 2, -3F, new Item.Settings());
	public static ToolItem BRONZE_PICKAXE = new BronzePickaxe(BronzeToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
	public static ToolItem STEEL_SWORD = new SteelSword(SteelToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings());
	public static ToolItem STEEL_AXE = new SteelAxe(SteelToolMaterial.INSTANCE, 6, -3.1F, new Item.Settings());
	public static ToolItem STEEL_HOE = new SteelHoe(SteelToolMaterial.INSTANCE, -2, -1.0F, new Item.Settings());
	public static ToolItem STEEL_SHOVEL = new SteelShovel(SteelToolMaterial.INSTANCE, 2, -3F, new Item.Settings());
	public static ToolItem STEEL_PICKAXE = new SteelPickaxe(SteelToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
	public static final Item BRONZE_INGOT = new Item(new FabricItemSettings());
	public static final Item TIN_INGOT = new Item(new FabricItemSettings());
	public static final Item STAINLESS_STEEL_INGOT = new Item(new FabricItemSettings());
	public static final Item TIN_NUGGET = new Item(new FabricItemSettings());
	public static final Item COPPER_NUGGET = new Item(new FabricItemSettings());
	public static final Item BRONZE_NUGGET = new Item(new FabricItemSettings());
	public static final Item STEEL_INGOT = new Item(new FabricItemSettings());
	public static final Item STEEL_NUGGET = new Item(new FabricItemSettings());
	public static final Item RAW_TIN = new Item(new FabricItemSettings());
	public static final Item STEEL_PLATE = new Item(new FabricItemSettings());
	public static final Item STAINLESS_STEEL_PLATE = new Item(new FabricItemSettings());
	public static final Item BRONZE_PLATE = new Item(new FabricItemSettings());
	public static final Item STONE_PLATE = new Item(new FabricItemSettings());
	public static final Item WOODEN_PLATE = new Item(new FabricItemSettings());
	static {
		//We use registerSimple here because our Entity is not an ExtendedScreenHandlerFactory
		//but a NamedScreenHandlerFactory.
		//In a later Tutorial you will see what ExtendedScreenHandlerFactory can do!
		WOODEN_BOX_BLOCK = Registry.register(Registry.BLOCK, WOODEN_BOX, new WoodenBoxBlock(FabricBlockSettings.of(Material.WOOD).hardness(2).resistance(3).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 0)));
		WOODEN_BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, WOODEN_BOX, new BlockItem(WOODEN_BOX_BLOCK, new Item.Settings()));
		STONE_BOX_BLOCK = Registry.register(Registry.BLOCK, STONE_BOX, new StoneBoxBlock(FabricBlockSettings.of(Material.STONE).hardness(1.5F).resistance(6).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool()));
		STONE_BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, STONE_BOX, new BlockItem(STONE_BOX_BLOCK, new Item.Settings()));
		BRONZE_BOX_BLOCK = Registry.register(Registry.BLOCK, BRONZE_BOX, new BronzeBoxBlock(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool()));
		BRONZE_BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, BRONZE_BOX, new BlockItem(BRONZE_BOX_BLOCK, new Item.Settings()));
		STEEL_BOX_BLOCK = Registry.register(Registry.BLOCK, STEEL_BOX, new SteelBoxBlock(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool()));
		STEEL_BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, STEEL_BOX, new BlockItem(STEEL_BOX_BLOCK, new Item.Settings()));
		STAINLESS_STEEL_BOX_BLOCK = Registry.register(Registry.BLOCK, STAINLESS_STEEL_BOX, new StainlessSteelBoxBlock(FabricBlockSettings.of(Material.METAL).hardness(5).resistance(6).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool()));
		STAINLESS_STEEL_BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, STAINLESS_STEEL_BOX, new BlockItem(STAINLESS_STEEL_BOX_BLOCK, new Item.Settings()));
		//The parameter of build at the very end is always null, do not worry about it
		WOODEN_BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, WOODEN_BOX, FabricBlockEntityTypeBuilder.create(WoodenBoxBlockEntity::new, WOODEN_BOX_BLOCK).build(null));
		WOODEN_BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WOODEN_BOX, WoodenBoxScreenHandler::new);
		STONE_BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, STONE_BOX, FabricBlockEntityTypeBuilder.create(StoneBoxBlockEntity::new, STONE_BOX_BLOCK).build(null));
		STONE_BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(STONE_BOX, StoneBoxScreenHandler::new);
		BRONZE_BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BRONZE_BOX, FabricBlockEntityTypeBuilder.create(BronzeBoxBlockEntity::new, BRONZE_BOX_BLOCK).build(null));
		BRONZE_BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BRONZE_BOX, BronzeBoxScreenHandler::new);
		STEEL_BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, STEEL_BOX, FabricBlockEntityTypeBuilder.create(SteelBoxBlockEntity::new, STEEL_BOX_BLOCK).build(null));
		STEEL_BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(STEEL_BOX, SteelBoxScreenHandler::new);
		STAINLESS_STEEL_BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, STAINLESS_STEEL_BOX, FabricBlockEntityTypeBuilder.create(StainlessSteelBoxBlockEntity::new, STAINLESS_STEEL_BOX_BLOCK).build(null));
		STAINLESS_STEEL_BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(STAINLESS_STEEL_BOX, StainlessSteelBoxScreenHandler::new);
	}
	public static final ItemGroup PLASMACRAFT_TAB = FabricItemGroupBuilder.create(
			new Identifier("plasmacraft", "plasmacraft_tab"))
			.icon(() -> new ItemStack(FLINT_SWORD))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(FLINT_AXE));
				stacks.add(new ItemStack(FLINT_HOE));
				stacks.add(new ItemStack(FLINT_PICKAXE));
				stacks.add(new ItemStack(FLINT_SHOVEL));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(FLINT_SWORD));
				stacks.add(new ItemStack(STEEL_BLOCK));
				stacks.add(new ItemStack(BRONZE_BLOCK));
				stacks.add(new ItemStack(TIN_ORE));
			})
			.build();
		private static ConfiguredFeature<?, ?> TIN_ORE_OVERWORLD = Feature.ORE
				.configure(new OreFeatureConfig(
						OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
						TIN_ORE.getDefaultState(),
						6)) // vein size
				.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
						UniformHeightProvider.create(
								YOffset.fixed(20),
								YOffset.fixed(90)))))
				.spreadHorizontally()
				.repeat(20); // number of veins per chunk
	@Override
	public void onInitialize() {
		RegistryKey<ConfiguredFeature<?, ?>> tinOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("plasmacraft", "tin_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOreOverworld.getValue(), TIN_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, tinOreOverworld);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_helmet"), STEEL_HELMET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_chestplate"), STEEL_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_leggings"), STEEL_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_boots"), STEEL_BOOTS);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_helmet"), BRONZE_HELMET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_chestplate"), BRONZE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_leggings"), BRONZE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_boots"), BRONZE_BOOTS);
		Registry.register(Registry.BLOCK, new Identifier("plasmacraft", "steel_block"), STEEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("plasmacraft", "bronze_block"), BRONZE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("plasmacraft", "tin_ore"), TIN_ORE);
		Registry.register(Registry.BLOCK, new Identifier("plasmacraft", "tin_block"), TIN_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("plasmacraft", "raw_tin_block"), RAW_TIN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_block"), new BlockItem(STEEL_BLOCK, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_block"), new BlockItem(BRONZE_BLOCK, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "tin_block"), new BlockItem(TIN_BLOCK, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "raw_tin_block"), new BlockItem(RAW_TIN_BLOCK, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "flint_sword"), FLINT_SWORD);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "flint_shovel"), FLINT_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "flint_pickaxe"), FLINT_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "flint_hoe"), FLINT_HOE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "flint_axe"), FLINT_AXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_sword"), BRONZE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_shovel"), BRONZE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_pickaxe"), BRONZE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_hoe"), BRONZE_HOE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_axe"), BRONZE_AXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_sword"), STEEL_SWORD);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_shovel"), STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_pickaxe"), STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_hoe"), STEEL_HOE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_axe"), STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_ingot"), BRONZE_INGOT);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_nugget"), BRONZE_NUGGET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_ingot"), STEEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_nugget"), STEEL_NUGGET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "tin_ingot"), TIN_INGOT);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "stainless_steel_ingot"), STAINLESS_STEEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "tin_nugget"), TIN_NUGGET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "copper_nugget"), COPPER_NUGGET);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "raw_tin"), RAW_TIN);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "wooden_plate"), WOODEN_PLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "stone_plate"), STONE_PLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "bronze_plate"), BRONZE_PLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "steel_plate"), STEEL_PLATE);
		Registry.register(Registry.ITEM, new Identifier("plasmacraft", "stainless_steel_plate"), STAINLESS_STEEL_PLATE);
	}
}
