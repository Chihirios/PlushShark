package io.github.chihirios.plushshark.registry

import io.github.chihirios.plushshark.PlushSharkMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item

object ModItems {
    val BLAHAJ: Item = BlockItem(ModBlocks.BLAHAJ, FabricItemSettings())
    val ENDERMITE_BLAHAJ: Item = BlockItem(ModBlocks.ENDERMITE_BLAHAJ, FabricItemSettings())

    fun register() {
        Registry.register(Registry.ITEM, PlushSharkMod.id("blahaj"), BLAHAJ)
        Registry.register(Registry.ITEM, PlushSharkMod.id("endermite_blahaj"), ENDERMITE_BLAHAJ)
    }
}