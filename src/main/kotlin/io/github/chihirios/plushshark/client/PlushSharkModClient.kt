package io.github.chihirios.plushshark.client

import io.github.chihirios.plushshark.registry.ModBlocks
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType

@Environment(EnvType.CLIENT)
object PlushSharkModClient : ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLAHAJ, RenderType.cutout())
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERMITE_BLAHAJ, RenderType.cutout())
    }
}