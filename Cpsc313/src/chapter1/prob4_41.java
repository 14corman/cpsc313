/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import chapter1.classes.TwoSum;
import chapter1.classes.TwoSumFast;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;
import edu.princeton.cs.algs4.ThreeSumFast;

/**
 *
 * @author Cory Edwards
 */
public class prob4_41 {

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
//        TwoSum.count(a);
//        TwoSumFast.count(a);
//        ThreeSum.count(a);
        ThreeSumFast.count(a);
        return timer.elapsedTime();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
            prev = time;
        } 
    }
    
}
