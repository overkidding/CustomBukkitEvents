package me.overkidding.bukkitevents.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;

public class ProjectileHitBlockEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private Projectile projectile;
    private boolean cancelled;

    public ProjectileHitBlockEvent(Projectile projectile, Block block) {
        super(block);
        this.projectile = projectile;
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
