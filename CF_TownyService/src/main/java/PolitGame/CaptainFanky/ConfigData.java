package PolitGame.CaptainFanky;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ConfigData {
    private static File config = new File("plugins/CF_TownyService/config.yml");
    private static File message = new File("plugins/CF_TownyService/message.yml");

    public static void createData() {
        YamlConfiguration ymlPut;
        if(!config.exists()) {
            ymlPut = YamlConfiguration.loadConfiguration(config);
            List<String> paywall = new ArrayList<>();
            paywall.add("COBBLESTONE:128");
            paywall.add("OAK_LOG:64");
            paywall.add("IRON_INGOT:16");
            paywall.add("COAL:32");
            ymlPut.addDefault("resources", paywall);
            ymlPut.options().copyDefaults(true);
            try {
                ymlPut.save(config);
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage("Error to create Config.yml");
            }
        }
        if(!message.exists()) {
            ymlPut = YamlConfiguration.loadConfiguration(message);
            LinkedHashMap<String, Object> messages = new LinkedHashMap<>();
            messages.put("prefix", "[&eTowny&f] ");
            messages.put("not-resources", "&cНедостаточно Ресурсов");
            ymlPut.addDefaults(messages);
            ymlPut.options().copyDefaults(true);
            try {
                ymlPut.save(message);
            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage("Error to create Messages.yml");
            }

        }
    }

    public static Map<String, String> loadMsgList() {
        Map<String, String> map = new HashMap<>();
        YamlConfiguration ymlPut = YamlConfiguration.loadConfiguration(message);
        Set<String> set = ymlPut.getKeys(true);
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String msg = ymlPut.getString(key);
            String msg1 = msg.replace('&', '§');
            map.put(key, msg1);
        }
        return map;
    }
    public static File getConfig() {
        return config;
    }

}
