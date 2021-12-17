package me.overkidding.bukkitevents.listeners;

import me.overkidding.bukkitevents.events.BowUseEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BowInteractListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBowInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(!event.hasItem() || event.getItem() == null) return;

        if(event.getItem().getType() == Material.BOW){
            BowUseEvent bowUseEvent = new BowUseEvent(player);

            Bukkit.getPluginManager().callEvent(bowUseEvent);


            Event.Result result = bowUseEvent.isCancelled() ? Event.Result.DENY : Event.Result.ALLOW;

            event.setUseItemInHand(result);
            event.setUseInteractedBlock(result);

            if(result == Event.Result.DENY) player.updateInventory();
        }
    }
}
