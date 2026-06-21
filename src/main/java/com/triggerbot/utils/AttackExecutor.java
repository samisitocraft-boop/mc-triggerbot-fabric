package com.triggerbot.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.GameMode;

public class AttackExecutor {

    /**
     * Ejecuta un ataque crítico (jump attack)
     * Se realiza cuando el jugador está saltando
     */
    public void executeCriticalAttack(MinecraftClient client, LivingEntity target) {
        if (client.interactionManager == null) return;

        // Mirar al enemigo (sin girar drasticamente)
        lookAtEntity(client, target, 2.0f);

        // Realizar ataque
        client.interactionManager.attackEntity(client.player, target);
        client.player.swingHand(Hand.MAIN_HAND);
    }

    /**
     * Ejecuta un ataque de barrido (sweep attack)
     * Se usa cuando el jugador está en el suelo
     */
    public void executeSweepAttack(MinecraftClient client) {
        if (client.interactionManager == null || client.player == null) return;

        // Ataque de barrido
        client.player.swingHand(Hand.MAIN_HAND);
    }

    /**
     * Ejecuta un ataque normal sin crítico
     */
    public void executeNormalAttack(MinecraftClient client) {
        if (client.interactionManager == null || client.player == null) return;

        client.player.swingHand(Hand.MAIN_HAND);
    }

    /**
     * Mira hacia la entidad sin girar drásticamente
     * Smoothing para evitar movimiento sospechoso
     */
    private void lookAtEntity(MinecraftClient client, LivingEntity target, float smoothing) {
        if (client.player == null) return;

        double dx = target.getX() - client.player.getX();
        double dy = target.getEyeY() - client.player.getEyeY();
        double dz = target.getZ() - client.player.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);

        float yaw = (float) Math.toDegrees(Math.atan2(dz, dx)) - 90.0f;
        float pitch = (float) -Math.toDegrees(Math.atan2(dy, distance));

        // Aplicar suavizado (smoothing) para no girar drásticamente
        float currentYaw = client.player.getYaw();
        float currentPitch = client.player.getPitch();

        float newYaw = currentYaw + (yaw - currentYaw) / smoothing;
        float newPitch = currentPitch + (pitch - currentPitch) / smoothing;

        client.player.setYaw(newYaw);
        client.player.setPitch(newPitch);
    }
}