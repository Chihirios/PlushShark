package io.github.chihirios.plushshark.blocks

import net.minecraft.core.BlockPos
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState

class EndermiteBlahajBlock(properties: Properties) : BlahajBlock(properties) {

    override fun animateTick(state: BlockState, level: Level, pos: BlockPos, random: RandomSource) {
        val j = random.nextInt(2) * 2 - 1
        val k = random.nextInt(2) * 2 - 1
        val d = pos.x.toDouble() + 0.5 + 0.25 * j.toDouble()
        val e = (pos.y.toFloat() + random.nextFloat()).toDouble()
        val f = pos.z.toDouble() + 0.5 + 0.25 * k.toDouble()
        val g = (random.nextFloat() * j.toFloat()).toDouble()
        val h = (random.nextFloat().toDouble() - 0.5) * 0.125
        val l = (random.nextFloat() * k.toFloat()).toDouble()
        level.addParticle(ParticleTypes.PORTAL, d, e, f, g, h, l)
    }
}