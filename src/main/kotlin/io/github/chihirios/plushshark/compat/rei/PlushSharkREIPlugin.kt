package io.github.chihirios.plushshark.compat.rei

import io.github.chihirios.plushshark.PlushSharkMod
import io.github.chihirios.plushshark.mixins.InfestedBlockAccessor
import io.github.chihirios.plushshark.registry.ModItems
import me.shedaniel.rei.api.client.plugins.REIClientPlugin
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry
import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry
import me.shedaniel.rei.api.common.entry.EntryIngredient
import me.shedaniel.rei.api.common.util.EntryIngredients
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.InfestedBlock

@Environment(EnvType.CLIENT)
class PlushSharkREIPlugin : REIClientPlugin {
    companion object {
        val INFESTATION: CategoryIdentifier<InfestationDisplay> =
            CategoryIdentifier.of(PlushSharkMod.MODID, "plugins/infestation")
    }

    override fun registerCategories(registry: CategoryRegistry?) {
        registry!!.add(InfestationCategory())
        registry.configure(INFESTATION) { config -> config.isQuickCraftingEnabledByDefault = false }
    }

    override fun registerDisplays(registry: DisplayRegistry?) {
        registry!!.add(InfestationDisplay(
                mutableListOf(EntryIngredients.of(ModItems.BLAHAJ), EntryIngredients.of(Items.ENDERMITE_SPAWN_EGG)),
                mutableListOf(EntryIngredients.of(ModItems.ENDERMITE_BLAHAJ))
            ))

        for (entry in InfestedBlockAccessor.getHostBlocks()) {
            registry.add(InfestationDisplay(
                mutableListOf(EntryIngredients.of(entry.key), EntryIngredients.of(Items.SILVERFISH_SPAWN_EGG)),
                mutableListOf(EntryIngredients.of(entry.value))
            ))
        }
    }

    override fun registerDisplaySerializer(registry: DisplaySerializerRegistry?) {
        registry!!.register(INFESTATION, InfestationDisplay.serializer())
    }
}