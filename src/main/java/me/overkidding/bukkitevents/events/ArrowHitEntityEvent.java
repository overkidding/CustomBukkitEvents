package me.overkidding.bukkitevents.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public class ArrowHitEntityEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Entity shooter;

    private boolean cancelled = false;

    public ArrowHitEntityEvent(Entity who, Entity shooter) {
        super(who);
        this.shooter = shooter;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    public Entity getShooter() {
        return shooter;
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
