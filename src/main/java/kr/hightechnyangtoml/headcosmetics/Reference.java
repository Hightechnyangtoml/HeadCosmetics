package kr.hightechnyangtoml.headcosmetics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Reference {
    public static final String prefix = "§a§l[§b§lHeadCosmetics§a§l] §r";

    public static ItemStack getHorn() {
        ItemStack item = new ItemStack(Material.END_ROD);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "뿔");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + "유니콘의 뿔이다.");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.FORTUNE, 10, true);
            item.setItemMeta(meta);
        }
        return item;
    }
    public static ItemStack getBone() {
        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "뼈");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + "개가 좋아한다.");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.FORTUNE, 10, true);
            item.setItemMeta(meta);
        }
        return item;
    }
    public static ItemStack getSpaceHelmet() {
        ItemStack item = new ItemStack(Material.GLASS);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Space Helmet");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + "우주로 갈 수 있다.");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.FORTUNE, 10, true);
            item.setItemMeta(meta);
        }
        return item;
    }
    public static ItemStack getScarf() {
        ItemStack item = new ItemStack(Material.RED_CARPET);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "목도리");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.WHITE + "따뜻하다.");
            meta.setLore(lore);
            meta.addEnchant(Enchantment.FORTUNE, 10, true);
            item.setItemMeta(meta);
        }
        return item;
    }
}
