/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuttimeestimation;

/**
 *
 * @author Martin
 */
public class CutTimeEstimation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estimator est = new Estimator(100, 10, 60, 0.2, 10 );
        est.calculateTimeForCut(10, 10, 100);
        System.out.println(est);
    }
}
