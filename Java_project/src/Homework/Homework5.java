package Homework;

import java.util.HashMap;
import java.util.Map;

class ConfigurationManager {
    private static ConfigurationManager instance;
    private Map<String, String> settings;
    private static final Object lock = new Object();

    private ConfigurationManager() {
        settings = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public void loadSettings(Map<String, String> newSettings) {
        settings.putAll(newSettings);
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }
}

public class Homework5 {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        Map<String, String> settings = new HashMap<>();
        settings.put("appName", "MyApplication");
        settings.put("version", "1.0.0");
        configManager.loadSettings(settings);

        System.out.println("App Name: " + configManager.getSetting("appName"));
        System.out.println("Version: " + configManager.getSetting("version"));

        configManager.setSetting("version", "1.1.0");
        System.out.println("Updated Version: " + configManager.getSetting("version"));

        ConfigurationManager anotherConfigManager = ConfigurationManager.getInstance();
        System.out.println("Same instance: " + (configManager == anotherConfigManager)); // Должно быть true
    }
}
