package io.github.jaminajar.jaminajarmod.datagen;

import io.github.jaminajar.jaminajarmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

import static io.github.jaminajar.jaminajarmod.items.ModItems.BOOM_TUBE;
import static io.github.jaminajar.jaminajarmod.items.ModItems.UNTREATED_SCISSOR_BLADE;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> FORGING_BLASTING = List.of(UNTREATED_SCISSOR_BLADE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COMFY_HANDLE,1)
                .pattern(" n ")
                .pattern("iwi")
                .pattern(" n ")
                .input('n', Items.NETHERITE_SCRAP)
                .input('i', Items.IRON_BARS)
                .input('w', Items.GRAY_WOOL)
                .criterion(hasItem(Items.NETHERITE_SCRAP),conditionsFromItem(Items.NETHERITE_SCRAP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COMFY_HANDLE)));

        offerBlasting(exporter, FORGING_BLASTING, RecipeCategory.MISC, ModItems.FORGED_BLADE,3000f,6000, "forged_blade");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MACHETE,1)
                .pattern("  i")
                .pattern("li ")
                .pattern("nl ")
                .input('n', Items.IRON_NUGGET)
                .input('i', Items.IRON_BLOCK)
                .input('l', Items.LIGHTNING_ROD)
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MACHETE)));

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.RAVAGER_SCREW, ModItems.RAVAGER_TOOTH,2);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SCISSOR_BLADE,1)
                .input(Items.BLUE_ICE,5)
                .input(Items.NETHERITE_INGOT,1)
                .input(Items.BLAZE_POWDER,2)
                .input(ModItems.FORGED_BLADE,1)
                .offerTo(exporter, new Identifier(getRecipeName((ModItems.SCISSOR_BLADE))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SOLBRAND,1)
                .pattern("gbg")
                .pattern("gng")
                .pattern("srs")
                .input('b',ModItems.SUN_BLADE)
                .input('g',Items.TINTED_GLASS)
                .input('n',Items.NETHERITE_INGOT)
                .input('s',Items.NETHERITE_SCRAP)
                .input('r',Items.BLAZE_ROD)
                .offerTo(exporter, new Identifier(getRecipeName((ModItems.SOLBRAND))));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UNTREATED_SCISSOR_BLADE,1)
                .pattern("  n")
                .pattern("di ")
                .pattern("bd ")
                .input('n', Items.NETHERITE_SCRAP)
                .input('d', Items.DIAMOND)
                .input('i', Items.NETHERITE_INGOT)
                .input('b', Items.BLAZE_ROD)
                .offerTo(exporter, new Identifier(getRecipeName(UNTREATED_SCISSOR_BLADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, BOOM_TUBE,1)
                .pattern("pnp")
                .pattern("pnp")
                .pattern("pnp")
                .input('n', Items.NETHERITE_SCRAP)
                .input('p', Items.PAPER)
                .offerTo(exporter, new Identifier(getRecipeName(BOOM_TUBE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, UNTREATED_SCISSOR_BLADE,1)
                .pattern("  n")
                .pattern("di ")
                .pattern("bd ")
                .input('n', Items.NETHERITE_SCRAP)
                .input('d', Items.DIAMOND)
                .input('i', Items.NETHERITE_INGOT)
                .input('b', Items.BLAZE_ROD)
                .offerTo(exporter, new Identifier(getRecipeName(UNTREATED_SCISSOR_BLADE)));

}}
