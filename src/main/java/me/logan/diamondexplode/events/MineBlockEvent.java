package me.logan.diamondexplode.events;

import me.logan.diamondexplode.DiamondExplode;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class MineBlockEvent implements Listener {
	@EventHandler
	public void onBlockMine(BlockBreakEvent event) {
		ArrayList<Material> pickaxes = new ArrayList<>(Arrays.asList(Material.DIAMOND_PICKAXE,
				Material.GOLDEN_PICKAXE,
				Material.IRON_PICKAXE,
				Material.STONE_PICKAXE,
				Material.WOODEN_PICKAXE,
				Material.NETHERITE_PICKAXE));

		Block block = event.getBlock(); //Get the diamond block
		ItemStack playerItem = event.getPlayer().getInventory().getItemInMainHand();


		if((block.getType().equals(Material.DIAMOND_ORE) || block.getType().equals(Material.DEEPSLATE_DIAMOND_ORE)) && pickaxes.contains(playerItem.getType())) {
			block.getWorld().createExplosion(block.getLocation(), DiamondExplode.getInstance().getConfig().getInt("ExplosionStrength"));
		}
	}
}
