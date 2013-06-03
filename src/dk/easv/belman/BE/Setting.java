package dk.easv.belman.BE;

import dk.easv.belman.DAL.SettingsManager;

public class Setting extends IEntity {

    
    private int lowestSeconds;// Amount of seconds to cut initialEstimateLength of the lowest thickness.
    private int highestSeconds;// Amount of seconds to cut initialEstimateLength of the highest thickness.
    
    private int urgentWithIn; // Amount of days an order is urgent within.
    
    private int urgentColorRGB; // The color for the urgent orders in the table.
    private int expiredColorRGB; // The color for the expired orders in the table.
   
    private int refreshPeriod; // Amount of minutes until the scheduler kicks off.

    public Setting() {
    }   

    /**
     * @return the lowestSeconds
     */
    public int getLowestSeconds() {
        return lowestSeconds;
    }

    /**
     * @param lowestSeconds the lowestSeconds to set
     */
    public void setLowestSeconds(int lowestSeconds) {
        this.lowestSeconds = lowestSeconds;
    }

    /**
     * @return the highestSeconds
     */
    public int getHighestSeconds() {
        return highestSeconds;
    }

    /**
     * @param highestSeconds the highestSeconds to set
     */
    public void setHighestSeconds(int highestSeconds) {
        this.highestSeconds = highestSeconds;
    }

    /**
     * @return the urgentWithIn
     */
    public int getUrgentWithIn() {
        return urgentWithIn;
    }

    /**
     * @param urgentWithIn the urgentWithIn to set
     */
    public void setUrgentWithIn(int urgentWithIn) {
        this.urgentWithIn = urgentWithIn;
    }

    /**
     * @return the urgentColor
     */
    public int getUrgentColorRGB() {
        return urgentColorRGB;
    }

    /**
     * @param urgentColorRGB the urgentColor to set
     */
    public void setUrgentColorRGB(int urgentColorRGB) {
        this.urgentColorRGB = urgentColorRGB;
    }

    /**
     * @return the expiredColor
     */
    public int getExpiredColorRGB() {
        return expiredColorRGB;
    }

    /**
     * @param expiredColorRGB the expiredColor to set
     */
    public void setExpiredColorRGB(int expiredColorRGB) {
        this.expiredColorRGB = expiredColorRGB;
    }

    /**
     * @return the refreshPeriod
     */
    public int getRefreshPeriod() {
        return refreshPeriod;
    }

    /**
     * @param refreshPeriod the refreshPeriod to set
     */
    public void setRefreshPeriod(int refreshPeriod) {
        this.refreshPeriod = refreshPeriod;
    }

    //<editor-fold defaultstate="collapsed" desc=" save() ">
    @Override
    public void save() {
        SettingsManager.setSettings(this);
    }
    //</editor-fold>
}
