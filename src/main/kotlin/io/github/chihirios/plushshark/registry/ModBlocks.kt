package io.github.chihirios.plushshark.registry

import io.github.chihirios.plushshark.blocks.BlahajBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.material.Material

object ModBlocks {
    val BLAHAJ = BlahajBlock(FabricBlockSettings.of(Material.WOOL).strength(0.5f).nonOpaque().sound(SoundType.WOOL))

    fun register() {
        Registry.register(Registry.BLOCK, ResourceLocation("plushshark", "blahaj"), BLAHAJ)
    }
}