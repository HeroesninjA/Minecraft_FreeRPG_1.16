package mc.carlton.freerpg.events.enchanting;

import mc.carlton.freerpg.FreeRPG;
import mc.carlton.freerpg.config.ConfigLoad;
import mc.carlton.freerpg.skills.perksAndAbilities.Enchanting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.plugin.Plugin;

public class PlayerEnchant implements Listener {

  Plugin plugin = FreeRPG.getPlugin(FreeRPG.class);

  @EventHandler(priority = EventPriority.HIGH)
  void onEnchant(EnchantItemEvent e) {
    if (e.isCancelled()) {
      return;
    }
    ConfigLoad configLoad = new ConfigLoad();
    if (!configLoad.getAllowedSkillsMap().get("enchanting")) {
      return;
    }
    Player p = (Player) e.getEnchanter();
    Enchanting enchantingClass = new Enchanting(p);
    enchantingClass.enchantItem(e.getItem(), e.whichButton(),
        (EnchantingInventory) e.getInventory());

  }
}
