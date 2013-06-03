package dk.easv.belman.DAL;

import dk.easv.belman.BE.Setting;
import dk.easv.belman.BLL.Estimator;
import dk.easv.belman.GUI.Main;
import java.util.Properties;

public class SettingsManager {

    private static Setting setting;
    private static final String PATH = "settings.cfg";
    private static Properties settingsProp = FileManager.readPropertiesFile(PATH);

    private SettingsManager() {
    }

    public static Setting getSettings() {        
//        if (setting == null) {
            setting = new Setting();
            // Time settings
            setting.setLowestSeconds(Integer.valueOf(settingsProp.getProperty("LOWESTSECONDS")));
            setting.setHighestSeconds(Integer.valueOf(settingsProp.getProperty("HIGHESTSECONDS")));
            // Urgent order settings
            setting.setUrgentColorRGB(Integer.valueOf(settingsProp.getProperty("URGENTCOLORRGB")));
            setting.setUrgentWithIn(Integer.valueOf(settingsProp.getProperty("URGENTWITHIN")));
            // Expired order settings
            setting.setExpiredColorRGB(Integer.valueOf(settingsProp.getProperty("EXPIREDCOLORRGB")));
            //
            setting.setRefreshPeriod(Integer.valueOf(settingsProp.getProperty("REFRESHPERIOD")));
//        }
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
    
    public static void applySettings(){
        Main.urgentDays = setting.getUrgentWithIn();
        Main.schedulerPeriod = setting.getRefreshPeriod();
        Main.urgentColor = new java.awt.Color(setting.getUrgentColorRGB());
        Main.expiredColor = new java.awt.Color(setting.getExpiredColorRGB());
        Main.gui.setHighlightColors();
        Main.gui.updateEstTime();
    }
}
