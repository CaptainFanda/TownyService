package PolitGame.CaptainFanky;

import PolitGame.CaptainFanky.Listener.PreTownCreateEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public final class CF_TownyService extends JavaPlugin {
    private static Map<String, String> massages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigData.createData();
        massages = ConfigData.loadMsgList();
        getServer().getPluginManager().registerEvents(new PreTownCreateEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Map<String, String> getMassages() {
        return massages;
    }

}
