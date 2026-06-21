package com.triggerbot.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EnemyDetector {
    
    public LivingEntity findNearestEnemy(PlayerEntity player, double radius) {
        World world = player.getWorld();
        double closestDistance = radius;
        LivingEntity closestEnemy = null;

        // Buscar en todas las direcciones (8 ángulos + arriba/abajo)
        for (LivingEntity entity : world.getEntitiesByClass(
            LivingEntity.class,
            player.getBoundingBox().expand(radius),
            e -> canTargetEntity(player, e)
        )) {
            double distance = player.distanceTo(entity);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestEnemy = entity;
            }
        }

        return closestEnemy;
    }

    private boolean canTargetEntity(PlayerEntity player, LivingEntity entity) {
        // No atacar a aliados, animales o el jugador mismo
        if (entity == player || entity.isSpectator() || entity.isDead()) {
            return false;
        }

        // Atacar solo jugadores
        if (entity instanceof PlayerEntity && !entity.isTeammate(player)) {
            return true;
        }

        return false;
    }

    public boolean isEntityInRadius(PlayerEntity player, LivingEntity entity, double radius) {
        return player.distanceTo(entity) <= radius && canTargetEntity(player, entity);
    }
}