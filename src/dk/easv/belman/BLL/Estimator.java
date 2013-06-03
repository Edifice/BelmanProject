/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BLL;

import dk.easv.belman.BE.Item;
import dk.easv.belman.BE.Setting;
import dk.easv.belman.DAL.SettingsManager;

/**
 *
 * @author Martin
 */
public class Estimator {

    private static double initialEstimateLength = 100;// Centimeters
    private static double lowestThickness = 0.2;// The lowest thickness
    private static double highestThickness = 0.8; // The highest thickness   

    public Estimator() {
    }

    public static String getTimeForCut(/*Item sleeve,*/double length, double thickness, int amountOfCuts) { // In seconds
        Setting setting = SettingsManager.getSettings();
        
//        double length = sleeve.getCircumference();
//        double thickness = sleeve.getThickness();        
        

        double lowestSeconds = setting.getLowestSeconds();// Amount of seconds to cut initialEstimateLength of the lowest thickness
        double highestSeconds = setting.getHighestSeconds();// Amount of seconds to cut initialEstimateLength of the highest thickness
        
        double cutLength = initialEstimateLength / length;
        double percentageIncrease = (((highestSeconds - lowestSeconds) / lowestSeconds) * 100) / (((highestThickness - lowestThickness) / lowestThickness) * 100);
        
        double timeMultFactor = (((thickness - lowestThickness) / lowestThickness) * percentageIncrease);
        double timeForEachCut = (lowestSeconds + (lowestSeconds * timeMultFactor)) / cutLength;
        double timeForCut = amountOfCuts * timeForEachCut;
        
        return formatSecsToHHmmss((int) Math.round(timeForCut));
    }

    private static String formatSecsToHHmmss(int secs) {
            int hours = secs / 3600,
                remainder = secs % 3600,
                minutes = remainder / 60,
                seconds = remainder % 60;

        String disHour = (hours < 10 ? "0" : "") + hours,
                disMinu = (minutes < 10 ? "0" : "") + minutes,
                disSec = (seconds < 10 ? "0" : "") + seconds;


        return disHour + ":" + disMinu + ":" + disSec;
    }

//    @Override
//    public String toString() {
//        int secs = 0;
//
//        secs = (int) Math.round(timeForCut);
//
//        int hours = secs / 3600,
//                remainder = secs % 3600,
//                minutes = remainder / 60,
//                seconds = remainder % 60;
//
//        String disHour = (hours < 10 ? "0" : "") + hours,
//                disMinu = (minutes < 10 ? "0" : "") + minutes,
//                disSec = (seconds < 10 ? "0" : "") + seconds;
//
//
//        return disHour + ":" + disMinu + ":" + disSec;
//    }
}
