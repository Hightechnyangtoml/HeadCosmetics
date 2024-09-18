package kr.hightechnyangtoml.headcosmetics;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        ItemStack itemInHand = e.getPlayer().getInventory().getItemInMainHand();

        if (itemInHand == null || itemInHand.getType().isAir()) {
            return;
        }

        ItemMeta meta = itemInHand.getItemMeta();
        if (meta == null) {
            return;
        }

        if (meta.hasLore()) {
            List<String> lore = meta.getLore();
            if (lore != null) {
                for (String line : lore) {
                    if (line.contains("§4Head Cosmetic") && e.getAction().toString().contains("RIGHT_CLICK")) {
                        Player player = e.getPlayer();
                        e.setCancelled(true);
                        ItemStack itemInHeadSlot = player.getInventory().getHelmet();
                        player.getInventory().setHelmet(itemInHand);
                        player.getInventory().setItemInMainHand(itemInHeadSlot);
                        player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_CHAIN, 1.0f, 1.0f);
                        return;
                    }
                }
            }
        }
    }
}
