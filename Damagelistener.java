package me.zain.projectkorra.listeners;

import me.zain.projectkorra.weaknesses.Weakness;
import me.zain.projectkorra.weaknesses.WeaknessManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player victim)) return;
        if (!(event.getDamager() instanceof Player attacker)) return;

        String victimElement = "Fire";    // TEMP
        String attackerElement = "Water"; // TEMP

        Weakness weakness = WeaknessManager.get(victimElement, attackerElement);
        if (weakness != null) {
            event.setDamage(event.getDamage() * weakness.damageMultiplier);
        }
    }
}
