package me.overkidding.bukkitevents;

import me.overkidding.bukkitevents.listeners.ArrowAttackListener;
import me.overkidding.bukkitevents.listeners.BowInteractListener;
import me.overkidding.bukkitevents.listeners.ProjectileHitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class CustomBukkitEvents extends JavaPlugin {

    @Override
    public void onEnable() {
        Arrays.asList(
                new BowInteractListener(),
                new ProjectileHitListener(),
                new ArrowAttackListener()
        ).forEach(listener ->
                Bukkit.getPluginManager().registerEvents(listener, this)
        );

    }

    @Override
    public void onDisable() {

    }
}
