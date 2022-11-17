package io.github.chihirios.plushshark.mixins;

import io.github.chihirios.plushshark.entity.ApproachBlahajGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderMan.class)
public abstract class EnderManMixin extends Monster {
    protected EnderManMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals()V", at = @At("HEAD"))
    private void addAttackBlahajGoal(CallbackInfo ci) {
        this.goalSelector.addGoal(3, new ApproachBlahajGoal(this));
    }
}
