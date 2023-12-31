package net.subthy.baersadditions.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.subthy.baersadditions.BaersAdditions;
import net.subthy.baersadditions.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> completableFuture,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, completableFuture, BaersAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Item tags here
        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.Rainbow_Road.get());
        this.tag(ItemTags.ARROWS)
                .add(ModItems.Arrow_Test.get());

    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
