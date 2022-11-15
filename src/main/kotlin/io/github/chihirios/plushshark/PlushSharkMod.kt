package io.github.chihirios.plushshark

import io.github.chihirios.plushshark.registry.ModBlocks
import io.github.chihirios.plushshark.registry.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object PlushSharkMod : ModInitializer {
    val LOGGER: Logger = LogManager.getLogger("Plush Shark")

    override fun onInitialize() {
        LOGGER.info("Plush shark mod version ${FabricLoader.getInstance().getModContainer("plushshark").get().metadata.version.friendlyString} loading")

        ModItems.register()
        ModBlocks.register()
    }
}