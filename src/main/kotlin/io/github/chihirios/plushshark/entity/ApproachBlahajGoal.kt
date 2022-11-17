package io.github.chihirios.plushshark.entity

import io.github.chihirios.plushshark.registry.ModBlocks
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal
import net.minecraft.world.level.LevelReader

class ApproachBlahajGoal(pathfinderMob: PathfinderMob) :
    MoveToBlockGoal(pathfinderMob, 1.5, 32, 32) {
    override fun isValidTarget(level: LevelReader, pos: BlockPos): Boolean {
        return level.getBlockState(pos).`is`(ModBlocks.ENDERMITE_BLAHAJ)
    }
}