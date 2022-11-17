package io.github.chihirios.plushshark.entity

import io.github.chihirios.plushshark.registry.ModBlocks
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal
import net.minecraft.world.level.LevelReader

class InfestBlahajGoal(pathfinderMob: PathfinderMob) :
    MoveToBlockGoal(pathfinderMob, 1.0, 8, 8) {

    var ticksSinceReachedTarget = 0

    override fun isValidTarget(level: LevelReader, pos: BlockPos): Boolean {
        return level.getBlockState(pos).`is`(ModBlocks.BLAHAJ)
    }

    override fun getMoveToTarget(): BlockPos {
        return this.blockPos
    }

    override fun tick() {
        super.tick()
        if (this.isReachedTarget) {
            ticksSinceReachedTarget++

            if (ticksSinceReachedTarget == 60) {
                val level = this.mob.level
                val oldState = level.getBlockState(this.blockPos)
                val newState = ModBlocks.ENDERMITE_BLAHAJ.defaultBlockState()
                // change rotation to stay the same here
                level.setBlock(this.blockPos, newState, 3)
                this.mob.spawnAnim()
                this.mob.discard()
            }
        }
    }

    override fun start() {
        super.start()
        this.ticksSinceReachedTarget = 0
    }
}