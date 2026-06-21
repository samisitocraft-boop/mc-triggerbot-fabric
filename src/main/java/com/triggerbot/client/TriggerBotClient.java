package com.triggerbot.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.triggerbot.utils.CooldownManager;
import com.triggerbot.utils.EnemyDetector;
import com.triggerbot.utils.AttackExecutor;

public class TriggerBotClient implements ClientModInitializer {
    private static KeyBinding triggerBotKey;
    private static boolean botActive = false;
    public static CooldownManager cooldownManager;
    public static EnemyDetector enemyDetector;
    public static AttackExecutor attackExecutor;

    @Override
    public void onInitializeClient() {
        triggerBotKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.triggerbot.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "category.triggerbot"
        ));

        cooldownManager = new CooldownManager();
        enemyDetector = new EnemyDetector();
        attackExecutor = new AttackExecutor();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (triggerBotKey.wasPressed()) {
                botActive = !botActive;
                if (client.player != null) {
                    String status = botActive ? "§aACTIVO" : "§cINACTIVO";
                    client.player.sendMessage(net.minecraft.text.Text.literal("TriggerBot " + status), true);
                }
            }

            if (botActive && client.player != null) {
                executeBot(client);
            }
        });
    }

    private static void executeBot(net.minecraft.client.MinecraftClient client) {
        if (client.world == null || client.player == null) return;

        // Detectar enemigos en radio de 3 bloques
        var target = enemyDetector.findNearestEnemy(client.player, 3.0);
        if (target == null) return;

        // Verificar si el jugador está saltando
        boolean isJumping = !client.player.isOnGround() && client.player.getVelocity().y > 0;

        // Obtener arma actual
        var weapon = client.player.getMainHandStack();
        if (weapon.isEmpty()) return;

        String weaponType = weapon.getItem().toString();
        long currentTime = System.currentTimeMillis();
        long cooldown = cooldownManager.getCooldownTime(weaponType, isJumping);

        if (cooldownManager.canAttack(weaponType, currentTime)) {
            if (isJumping) {
                // Atacar crítico al saltar
                attackExecutor.executeCriticalAttack(client, target);
            } else {
                // Golpes normales o barridos
                if (Math.random() > 0.5) {
                    attackExecutor.executeSweepAttack(client);
                } else {
                    attackExecutor.executeNormalAttack(client);
                }
            }
            cooldownManager.setCooldown(weaponType, currentTime + cooldown);
        }
    }

    public static boolean isBotActive() {
        return botActive;
    }
}