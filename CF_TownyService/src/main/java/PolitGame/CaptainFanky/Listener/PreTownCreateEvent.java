package PolitGame.CaptainFanky.Listener;

import PolitGame.CaptainFanky.CF_TownyService;
import PolitGame.CaptainFanky.ConfigData;
import PolitGame.CaptainFanky.Service.ResourcesService;
import com.palmergames.bukkit.towny.event.PreNewTownEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;
import java.util.List;

public class PreTownCreateEvent implements Listener {
    private static String prefix = CF_TownyService.getMassages().get("prefix");

    @EventHandler
    public void onPreTownCreate(PreNewTownEvent e) {
        File config = ConfigData.getConfig();
        YamlConfiguration ymlPut = YamlConfiguration.loadConfiguration(config);
        List<String> paywall = ymlPut.getStringList("resources");
        Player player = e.getPlayer();
        if(ResourcesService.hasRequiredItems(player, paywall)) {
            ResourcesService.removeRequiredItems(player, paywall);
        } else {
            String message = prefix + CF_TownyService.getMassages().get("not-resources");
            player.sendMessage(message);
            e.setCancelled(true);
        }
    }

}
