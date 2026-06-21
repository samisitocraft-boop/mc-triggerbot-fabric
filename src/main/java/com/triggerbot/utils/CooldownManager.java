package com.triggerbot.utils;

import java.util.HashMap;
import java.util.Map;

public class CooldownManager {
    private final Map<String, Long> cooldowns = new HashMap<>();

    // Tiempos en milisegundos
    private static final Map<String, Long> SWORD_COOLDOWNS = new HashMap<String, Long>() {{
        put("netherite_sword", 1600L);
        put("diamond_sword", 1600L);
        put("iron_sword", 1600L);
        put("gold_sword", 1600L);
        put("stone_sword", 1600L);
        put("wooden_sword", 1600L);
    }};

    private static final Map<String, Long> AXE_COOLDOWNS = new HashMap<String, Long>() {{
        put("netherite_axe", 850L);
        put("diamond_axe", 850L);
        put("gold_axe", 850L);
        put("iron_axe", 930L);
        put("stone_axe", 1020L);
        put("wooden_axe", 1020L);
    }};

    private static final Map<String, Long> NORMAL_ATTACK_COOLDOWN = new HashMap<String, Long>() {{
        put("netherite_sword", 800L);
        put("diamond_sword", 800L);
        put("iron_sword", 800L);
        put("gold_sword", 800L);
        put("stone_sword", 800L);
        put("wooden_sword", 800L);
        put("netherite_axe", 600L);
        put("diamond_axe", 600L);
        put("gold_axe", 600L);
        put("iron_axe", 650L);
        put("stone_axe", 700L);
        put("wooden_axe", 700L);
    }};

    public long getCooldownTime(String weapon, boolean isCritical) {
        String weaponName = extractWeaponName(weapon);
        
        if (isCritical) {
            // Críticos = cooldown máximo
            if (SWORD_COOLDOWNS.containsKey(weaponName)) {
                return SWORD_COOLDOWNS.get(weaponName);
            }
            if (AXE_COOLDOWNS.containsKey(weaponName)) {
                return AXE_COOLDOWNS.get(weaponName);
            }
        } else {
            // Golpes normales = cooldown menor
            if (NORMAL_ATTACK_COOLDOWN.containsKey(weaponName)) {
                return NORMAL_ATTACK_COOLDOWN.get(weaponName);
            }
        }
        
        return 500L; // Cooldown por defecto
    }

    public boolean canAttack(String weapon, long currentTime) {
        String weaponName = extractWeaponName(weapon);
        Long lastAttack = cooldowns.getOrDefault(weaponName, 0L);
        return currentTime >= lastAttack;
    }

    public void setCooldown(String weapon, long time) {
        String weaponName = extractWeaponName(weapon);
        cooldowns.put(weaponName, time);
    }

    private String extractWeaponName(String weapon) {
        // Convierte "Items.NETHERITE_SWORD" a "netherite_sword"
        return weapon.toLowerCase()
            .replace("items.", "")
            .replace("item.", "")
            .replace("minecraft:", "");
    }

    public void reset() {
        cooldowns.clear();
    }
}