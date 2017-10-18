/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class StoogSortDoubleTest {
    public static void stoogeSort(int[] L) 
    {
        stoogeSort(L, 0, L.length - 1);
    }
 
    public static void stoogeSort(int[] L, int lo, int hi) 
    {
        if (L[hi] < L[lo]) 
        {
            int tmp = L[lo];
            L[lo] = L[hi];
            L[hi] = tmp;
        }
        
        if (hi - lo > 1) 
        {
            int oneThird = (hi - lo + 1) / 3; //Get 1/3 of the set.
            stoogeSort(L, lo, hi - oneThird); //Do first 2/3
            stoogeSort(L, lo + oneThird, hi); //Do last 2/3
            stoogeSort(L, lo, hi - oneThird); //Do firs 2/3 again
        }
    }
    
    //Doubling test.
    public static double timeTrial(int n)
    {
        int max = 1000000;
        int[] a = new int[n];
        for(int i =0; i < n; i++)
            a[i] = StdRandom.uniform(-max, max);
        Stopwatch watch = new Stopwatch();
        stoogeSort(a);
        return watch.elapsedTime();
    }
    
    public static void main(String[] args)
    {
        for(int n = 250; true; n *= 2)
        {
            double sum = 0.0;
            for(int i = 0; i < 10; i++)
            {
                double time = timeTrial(n);
                sum += time;
            }
            StdOut.printf("%7d %5.1f\n", n, sum / 10.0);
        }
    }
}
