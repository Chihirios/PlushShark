package io.github.chihirios.plushshark.compat.rei

import me.shedaniel.math.Point
import me.shedaniel.math.Rectangle
import me.shedaniel.rei.api.client.gui.Renderer
import me.shedaniel.rei.api.client.gui.widgets.Widget
import me.shedaniel.rei.api.client.gui.widgets.Widgets
import me.shedaniel.rei.api.client.registry.display.DisplayCategory
import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.util.EntryStacks
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Items

class InfestationCategory : DisplayCategory<InfestationDisplay> {
    override fun getCategoryIdentifier(): CategoryIdentifier<out InfestationDisplay> = PlushSharkREIPlugin.INFESTATION

    override fun getTitle(): Component = Component.translatable("plushshark.rei_category.infestation")

    override fun getIcon(): Renderer = EntryStacks.of(Items.CRACKED_STONE_BRICKS)

    override fun setupDisplay(display: InfestationDisplay, bounds: Rectangle): MutableList<Widget> {
        val startPoint = Point(bounds.centerX - 46, bounds.centerY - 13)
        val widgets = mutableListOf<Widget>()
        widgets.add(Widgets.createRecipeBase(bounds))
        widgets.add(Widgets.createArrow(Point(startPoint.x + 24, startPoint.y + 4)))
        widgets.add(Widgets.createArrow(Point(startPoint.x + 40, startPoint.y + 4)))
        val blockPoint = Point(startPoint.x + 4, startPoint.y + 5)
        widgets.add(Widgets.createSlot(blockPoint).entries(display.getBlock()).markInput())
        val mobPoint = Point(startPoint.x + 35, startPoint.y + 5)
        widgets.add(Widgets.createSlot(mobPoint).entries(display.getInfestor()).markInput())
        val outputPoint = Point(startPoint.x + 71, startPoint.y + 5)
        widgets.add(Widgets.createResultSlotBackground(outputPoint))
        widgets.add(Widgets.createSlot(outputPoint).entries(display.getOut()).disableBackground().markOutput())
        return widgets
    }
}