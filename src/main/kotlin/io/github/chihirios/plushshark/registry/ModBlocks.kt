package io.github.chihirios.plushshark.registry

import io.github.chihirios.plushshark.PlushSharkMod
import io.github.chihirios.plushshark.blocks.BlahajBlock
import io.github.chihirios.plushshark.blocks.EndermiteBlahajBlock
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.material.Material

object ModBlocks {
    val BLAHAJ = BlahajBlock(FabricBlockSettings.of(Material.WOOL).strength(0.5f).nonOpaque().sound(SoundType.WOOL))
    val ENDERMITE_BLAHAJ = EndermiteBlahajBlock(FabricBlockSettings.copy(BLAHAJ))

    fun register() {
        Registry.register(Registry.BLOCK, PlushSharkMod.id("blahaj"), BLAHAJ)
        Registry.register(Registry.BLOCK, PlushSharkMod.id("endermite_blahaj"), ENDERMITE_BLAHAJ)
    }
}