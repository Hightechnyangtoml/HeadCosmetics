package kr.hightechnyangtoml.headcosmetics;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeadCosmetics extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("headcosmetics").setExecutor(new Command());
        getCommand("headcosmetics").setTabCompleter(new Command());

        Bukkit.getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
    }
}
