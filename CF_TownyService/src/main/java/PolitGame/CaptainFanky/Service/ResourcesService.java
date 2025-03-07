package PolitGame.CaptainFanky.Service;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ResourcesService {
    public static boolean hasRequiredItems(Player player, List<String> paywall) {
        for (String item : paywall) {
            String[] parts = item.split(":");
            Material material = Material.getMaterial(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            if (material != null && player.getInventory().contains(material, amount)) {
                continue;
            }
            return false;
        }
        return true;
    }
    public static void removeRequiredItems(Player player, List<String> paywall) {
        for (String item : paywall) {
            String[] parts = item.split(":");
            Material material = Material.getMaterial(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            if (material != null) {
                player.getInventory().removeItem(new ItemStack(material, amount));
            }
        }
    }
}
