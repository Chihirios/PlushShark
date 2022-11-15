package io.github.chihirios.plushshark.registry

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material

object ModBlocks {
    val BLAHAJ = Block(FabricBlockSettings.of(Material.WOOL).strength(0.5f))
    val BLAHAJ_BLUE = Block(FabricBlockSettings.of(Material.WOOL).strength(0.5f))

    fun register() {
        Registry.register(Registry.BLOCK, ResourceLocation("plushshark", "blahaj"), BLAHAJ)
        Registry.register(Registry.BLOCK, ResourceLocation("plushshark", "blahaj_blue"), BLAHAJ_BLUE)
    }
}