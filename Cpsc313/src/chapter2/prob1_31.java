/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author Cory Edwards
 */
public class prob1_31 {
    
    public static double timeTrial(int n) {
        IntCompared[] a = new IntCompared[n];
        for (int i = 0; i < n; i++) {
            a[i] = new IntCompared();
        }
        Stopwatch timer = new Stopwatch();
//        Selection.sort(a);
//        Insertion.sort(a);
        Shell.sort(a);
        return timer.elapsedTime();
    }
    
    public static void main(String[] args){
        double prev = timeTrial(1000);
        for (int n = 1000; true; n += n) {
            double time = timeTrial(n);
            //182,800,000 or 182.8 mH clock speed
//            StdOut.printf("%7d %7.1f %7.1f %5.1f\n", n, ((0.5 * Math.pow(n, 2)) + n) / 182800000, time, time/prev);
//            StdOut.printf("%7d %7.1f %7.1f %5.1f\n", n, ((0.5 * Math.pow(n, 2)) + (0.25 * Math.pow(n, 2))) / 182800000,  time, time/prev);
            StdOut.printf("%7d %7.1f %7.1f %5.1f\n", n, Math.sqrt(Math.pow(n, 3)) / 182800000, time, time/prev);
            prev = time;
        } 
    }
}
class IntCompared implements Comparable
{
    public final int key;
    public IntCompared(){
        key = StdRandom.uniform(-1000000, 1000000);
    }

    @Override
    public int compareTo(Object o) {
        IntCompared object = (IntCompared) o;
        if(key < object.key)
            return -1;
        else if(key > object.key)
            return 1;
        else
            return 0;
    }
}
