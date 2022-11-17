package io.github.chihirios.plushshark

import io.github.chihirios.plushshark.registry.ModBlocks
import io.github.chihirios.plushshark.registry.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object PlushSharkMod : ModInitializer {
    val LOGGER: Logger = LogManager.getLogger("Plush Shark")
    val MODID = "plushshark"
    fun id(path: String) = ResourceLocation(MODID, path)

    val BLAHAJ_GROUP = FabricItemGroupBuilder.create(id("general"))
        .icon { ItemStack(ModBlocks.BLAHAJ) }
        .appendItems { stacks ->
            stacks.add(ItemStack(ModItems.BLAHAJ))
            stacks.add(ItemStack(ModItems.ENDERMITE_BLAHAJ))
        }
        .build()

    override fun onInitialize() {
        LOGGER.info(
            "Plush shark mod version ${
                FabricLoader.getInstance().getModContainer(MODID).get().metadata.version.friendlyString
            } loading"
        )

        ModItems.register()
        ModBlocks.register()


    }
}