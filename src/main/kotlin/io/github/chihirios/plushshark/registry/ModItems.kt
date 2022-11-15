package io.github.chihirios.plushshark.registry

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item


object ModItems {
    val BLAHAJ: Item = BlockItem(ModBlocks.BLAHAJ, FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS))

    fun register() {
        Registry.register(Registry.ITEM, ResourceLocation("plushshark", "blahaj"), BLAHAJ)
    }
}