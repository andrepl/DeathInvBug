package io.github.andrepl;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathInvBug extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onHorseDeath(EntityDeathEvent event) {
		if (event.getEntity() instanceof Horse) {
			Horse h = (Horse) event.getEntity();
			ItemStack saddle = new ItemStack(Material.SADDLE);
			ItemMeta meta = saddle.getItemMeta();
			meta.setDisplayName("Altered Saddle");
			saddle.setItemMeta(meta);
			((Horse) event.getEntity()).getInventory().setSaddle(saddle);
		}
	}
}
