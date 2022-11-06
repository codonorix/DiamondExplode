package me.logan.diamondexplode;

import me.logan.diamondexplode.events.MineBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiamondExplode extends JavaPlugin {
	FileConfiguration config = getConfig();
	private static DiamondExplode instance;

	public static DiamondExplode getInstance(){
		return instance;
	}
	@Override
	public void onEnable() {
		instance = this;
		// Plugin startup logic
		config.addDefault("ExplosionStrength", 2);
		config.options().copyDefaults(true);
		saveConfig();

		Bukkit.getServer().getPluginManager().registerEvents(new MineBlockEvent(), this);
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
