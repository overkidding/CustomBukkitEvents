package me.overkidding.bukkitevents.listeners;

import me.overkidding.bukkitevents.events.ArrowHitEntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class ArrowAttackListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        Entity damager = event.getEntity();

        if(damager instanceof Arrow){
            Arrow arrow = (Arrow) damager;
            ProjectileSource shooter = arrow.getShooter();

            if(shooter instanceof Entity){
                Entity shooterEntity = (Entity) shooter;
                Bukkit.getPluginManager().callEvent(new ArrowHitEntityEvent(event.getEntity(), shooterEntity));
            }
        }

    }
}
