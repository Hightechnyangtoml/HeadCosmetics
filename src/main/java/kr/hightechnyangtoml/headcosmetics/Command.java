package kr.hightechnyangtoml.headcosmetics;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(Reference.prefix + "§c사용법: /headcosmetics [open/make/help]");
            return true;
        }

        if (args[0].equalsIgnoreCase("open")) {
            Inventory inv = Bukkit.createInventory(null, 9, "Head Cosmetics");

            inv.setItem(0, headCosmetinize(Reference.getHorn()));
            inv.setItem(1, headCosmetinize(Reference.getBone()));
            inv.setItem(2, headCosmetinize(Reference.getSpaceHelmet()));
            inv.setItem(3, headCosmetinize(Reference.getScarf()));

            player.openInventory(inv);
            return true;
        }

        if (args[0].equalsIgnoreCase("make")) {
            PlayerInventory inventory = player.getInventory();
            ItemStack itemInHand = inventory.getItemInMainHand();

            if (itemInHand != null && itemInHand.getType() != Material.AIR) {
                ItemStack cosmetizedItem = headCosmetinize(itemInHand);

                inventory.setItemInMainHand(cosmetizedItem);

                player.sendMessage(Reference.prefix + "§aDone!");
            } else {
                player.sendMessage(Reference.prefix + "§c손에 아이템이 없어요!");
            }
            return true;
        }

        if (args[0].equalsIgnoreCase("help")) {
            player.sendMessage(Reference.prefix + "§e-------------------- 도움말 --------------------");
            player.sendMessage(Reference.prefix + "/headcosmetics open - 기본 장식을 불러옵니다.");
            player.sendMessage(Reference.prefix + "/headcosmetics make - 손에 든 아이템을 장식으로 만듭니다.");
            player.sendMessage(Reference.prefix + "/headcosmetics help - 이 메세지를 출력합니다.");
            player.sendMessage(Reference.prefix + "§e-----------------------------------------------");
            return true;
        }

        player.sendMessage(Reference.prefix + "§c사용법: /headcosmetics [open/make/help]");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            List<String> subCommands = Arrays.asList("open", "make", "help");
            for (String subCommand : subCommands) {
                if (subCommand.toLowerCase().startsWith(args[0].toLowerCase())) {
                    completions.add(subCommand);
                }
            }
        }
        return completions;
    }

    public static ItemStack headCosmetinize(ItemStack item) {
        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

        lore.add("");
        lore.add("§6§lRight-Click: §e머리에 장착.");
        lore.add("§4Head Cosmetic");

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
