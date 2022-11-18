package io.github.chihirios.plushshark.compat.rei

import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.display.basic.BasicDisplay
import me.shedaniel.rei.api.common.entry.EntryIngredient

class InfestationDisplay(
    inputs: MutableList<EntryIngredient>,
    outputs: MutableList<EntryIngredient>
) : BasicDisplay(inputs, outputs) {
    companion object {
        fun serializer(): Serializer<InfestationDisplay> = Serializer.ofSimpleRecipeLess(::InfestationDisplay)
    }

    fun getBlock(): EntryIngredient {
        return inputEntries[0]
    }

    fun getInfestor(): EntryIngredient {
        return inputEntries[1]
    }

    fun getOut(): EntryIngredient {
        return outputEntries[0]
    }

    override fun getCategoryIdentifier(): CategoryIdentifier<*> {
        return PlushSharkREIPlugin.INFESTATION
    }
}