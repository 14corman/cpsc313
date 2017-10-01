/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import chapter2.classes.CustomQuickX;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author Cory Edwards
 */
public class prob3_29 {
    public static void main(String[] args)
    {
        int[] m = new int[]{10, 20, 50};
        for(int n = 10000; n <= 10000000; n *= 10)
        {
            Integer[] array = new Integer[n];
            for(int i = 0; i < n; i++)
                array[i] = i;
            Stopwatch watch = new Stopwatch();
            for(int cut : m)
            {
                CustomQuickX.MEDIAN_OF_3_CUTOFF = cut;
                
//                CustomQuickX.sort(array, StdRandom.uniform(n), array.length - 1);
                
                StdRandom.shuffle(array);
                CustomQuickX.sort(array);
                
                StdOut.println("n: " + n + "\tm: " + cut + "\ttime: " + watch.elapsedTime());
            }
            StdOut.println();
        }
        
    }
}
