package me.overkidding.bukkitevents.listeners;

import me.overkidding.bukkitevents.events.ProjectileHitBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

public class ProjectileHitListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        Location loc = projectile.getLocation();
        Vector vec = projectile.getVelocity();
        Location finalLoc = new Location(loc.getWorld(), loc.getX() + vec.getX(), loc.getY() + vec.getY(), loc.getZ() + vec.getZ()).clone();
        int x = finalLoc.getBlockX(), y = finalLoc.getBlockY(), z = finalLoc.getBlockZ();
        final Block block = projectile.getWorld().getBlockAt(x, y, z);
        Bukkit.getServer().getPluginManager().callEvent(new ProjectileHitBlockEvent(projectile, block));
        projectile.remove();
    }
}
