package io.github.chihirios.plushshark.mixins;

import io.github.chihirios.plushshark.entity.InfestBlahajGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Endermite.class)
public abstract class EndermiteMixin extends Monster {
    protected EndermiteMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals()V", at = @At("HEAD"))
    private void addAttackBlahajGoal(CallbackInfo ci) {
        this.goalSelector.addGoal(1, new InfestBlahajGoal(this));
    }
}
