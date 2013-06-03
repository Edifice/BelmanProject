package dk.easv.belman.DAL;

import dk.easv.belman.BE.Setting;
import java.awt.Color;
import java.util.Properties;

public class SettingsManager {

    private static Setting setting;
    private static final String PATH = "settings.cfg";
    private static Properties settingsProp;

    private SettingsManager() {
    }

    public static Setting getSettings() {
        
        settingsProp = FileManager.readPropertiesFile(PATH);
        
        //if (setting == null) {
            setting = new Setting();
            // Time settings
            setting.setLowestSeconds(Double.parseDouble(settingsProp.getProperty("LOWESTSECONDS")));
            setting.setHighestSeconds(Double.parseDouble(settingsProp.getProperty("HIGHESTSECONDS")));
//             Urgent order settings
            setting.setUrgentColorRGB(Integer.valueOf(settingsProp.getProperty("URGENTCOLORRGB")));
            setting.setUrgentWithIn(Integer.valueOf(settingsProp.getProperty("URGENTWITHIN")));
//             Expired order settings
            setting.setExpiredColorRGB(Integer.valueOf(settingsProp.getProperty("EXPIREDCOLORRGB")));
            
       // }
        return setting;

    }

    public static void setSettings(Setting setting) {
        settingsProp.setProperty("LOWESTSECONDS", String.valueOf(setting.getLowestSeconds()));
        settingsProp.setProperty("HIGHESTSECONDS", String.valueOf(setting.getHighestSeconds()));

        settingsProp.setProperty("URGENTCOLORRGB", String.valueOf(setting.getUrgentColorRGB()));
        settingsProp.setProperty("URGENTWITHIN", String.valueOf(setting.getUrgentWithIn()));

        settingsProp.setProperty("EXPIREDCOLORRGB", String.valueOf(setting.getExpiredColorRGB()));

        FileManager.write(settingsProp);
    }
}
