/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuttimeestimation;

/**
 *
 * @author Martin
 */
public class Estimator {

    private double initialEstimateLength;// Centimeters
    private double botLimit;// Amount of seconds to cut initialEstimateLength of the lowest thickness
    private double topLimit;// Amount of seconds to cut initialEstimateLength of the highest thickness
    private double botThickness;// The lowest thickness
    private double topThickness;// The highest thickness
    private double timeForCoilChange = 20; // Minutes
    private double thickness;
    private double length;
    private boolean coilChange;
    private int amountOfCuts;
    private double timeForCut;

    public Estimator(double initialEstimateLength, double botLimit, double topLimit, double botThickness, double topThickness) {
        this.initialEstimateLength = initialEstimateLength;
        this.botLimit = botLimit;
        this.topLimit = topLimit;
        this.botThickness = botThickness;
        this.topThickness = topThickness;

    }

    public double calculateTimeForCut(int amountOfCuts, double thickness, double length) { // In seconds

        double cutLength = initialEstimateLength / length;

        double percentageIncrease = (((topLimit - botLimit) / botLimit) * 100) / (((topThickness - botThickness) / botThickness) * 100);
        double timeMultFactor = (((thickness - botThickness) / botThickness) * percentageIncrease);
        double timeForEachCut = (botLimit + (botLimit * timeMultFactor)) / cutLength;
        timeForCut = amountOfCuts * timeForEachCut;
        return timeForCut;
    }

    @Override
    public String toString() {
        int secs = 0;
        if (coilChange) {
            secs = (int) Math.round(timeForCut + (timeForCoilChange * 60));
        } else {
            secs = (int) Math.round(timeForCut);
        }
        int hours = secs / 3600,
                remainder = secs % 3600,
                minutes = remainder / 60,
                seconds = remainder % 60;

        String disHour = (hours < 10 ? "0" : "") + hours,
                disMinu = (minutes < 10 ? "0" : "") + minutes,
                disSec = (seconds < 10 ? "0" : "") + seconds;


        return disHour + ":" + disMinu + ":" + disSec;
    }
}
