package net.subthy.baersadditions.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.subthy.baersadditions.BaersAdditions;
import net.subthy.baersadditions.block.ModBlocks;
import net.subthy.baersadditions.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // Add items to be smelted to get platinum ingot
    private static final List<ItemLike> Platinum_Smeltables = List.of(
            ModBlocks.Platinum_Ore.get(),
            ModItems.Raw_Platinum.get(),
            ModBlocks.Deepslate_Platinum_Ore.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        // Shaped

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Platinum_Block.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Platinum_Ingot.get())
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Platinum_Ingot.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Raw_Platinum_Block.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Raw_Platinum.get())
                .unlockedBy("has_platinum", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Raw_Platinum.get()).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Iron_Coin.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Copper_Coin.get())
                .unlockedBy("has_copper_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Copper_Coin.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Gold_Coin.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Iron_Coin.get())
                .unlockedBy("has_iron_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Iron_Coin.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Diamond_Coin.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Gold_Coin.get())
                .unlockedBy("has_gold_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Gold_Coin.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Netherite_Coin.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Diamond_Coin.get())
                .unlockedBy("has_diamond_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Diamond_Coin.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Raw_Platinum.get(), 9)
                .requires(ModBlocks.Raw_Platinum_Block.get())
                .unlockedBy("has_raw_platinum", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.Raw_Platinum_Block.get()).build()))
                .save(pWriter);

        // Shapless

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Platinum_Ingot.get())
                .requires(ModItems.Platinum_Nugget.get(),9)
                .unlockedBy("has_platinum_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.Raw_Platinum_Block.get()).build()))
                .save(pWriter, new ResourceLocation(BaersAdditions.MOD_ID, "platinum_ingots_from_nuggets"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Platinum_Nugget.get(),9)
                .requires(ModItems.Platinum_Ingot.get())
                .unlockedBy("has_platinum_nugget", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.Raw_Platinum_Block.get()).build()))
                .save(pWriter, new ResourceLocation(BaersAdditions.MOD_ID, "platinum_nuggets_from_ingot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Platinum_Ingot.get(), 9)
                .requires(ModBlocks.Platinum_Block.get())
                .unlockedBy("has_platinum_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.Platinum_Block.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Copper_Coin.get(), 9)
                .requires(ModItems.Iron_Coin.get())
                .unlockedBy("has_iron_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Iron_Coin.get()).build()))
                .save(pWriter, "copper_coins_from_iron_coins");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Iron_Coin.get(), 9)
                .requires(ModItems.Gold_Coin.get())
                .unlockedBy("has_gold_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Gold_Coin.get()).build()))
                .save(pWriter, "iron_coins_from_gold_coins");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Gold_Coin.get(), 9)
                .requires(ModItems.Diamond_Coin.get())
                .unlockedBy("has_diamond_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Diamond_Coin.get()).build()))
                .save(pWriter, "gold_coins_from_diamond_coins");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Diamond_Coin.get(), 9)
                .requires(ModItems.Netherite_Coin.get())
                .unlockedBy("has_netherite_coin", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.Netherite_Coin.get()).build()))
                .save(pWriter, "diamond_coins_from_netherite_coins");

        // Smelting

        oreSmelting(pWriter, Platinum_Smeltables, RecipeCategory.MISC, ModItems.Platinum_Ingot.get(), 0.25F, 200, "platinum");
        oreBlasting(pWriter, Platinum_Smeltables, RecipeCategory.MISC, ModItems.Platinum_Ingot.get(), 0.30F, 100, "platinum");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, BaersAdditions.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
