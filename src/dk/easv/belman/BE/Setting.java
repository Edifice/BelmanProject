package dk.easv.belman.BE;

import java.awt.Color;

public class Setting {

    
    private double lowestSeconds;// Amount of seconds to cut initialEstimateLength of the lowest thickness
    private double highestSeconds;// Amount of seconds to cut initialEstimateLength of the highest thickness
    
    private int urgentWithIn; // Amount of days an order is urgent within.
    
    private int urgentColorRGB; // The color for the urgent orders in the table
    private int expiredColorRGB; // The color for the expired orders in the table
   
    

    public Setting() {
    }   

    /**
     * @return the lowestSeconds
     */
    public double getLowestSeconds() {
        return lowestSeconds;
    }

    /**
     * @param lowestSeconds the lowestSeconds to set
     */
    public void setLowestSeconds(double lowestSeconds) {
        this.lowestSeconds = lowestSeconds;
    }

    /**
     * @return the highestSeconds
     */
    public double getHighestSeconds() {
        return highestSeconds;
    }

    /**
     * @param highestSeconds the highestSeconds to set
     */
    public void setHighestSeconds(double highestSeconds) {
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


}
