/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author Cory Edwards
 */
public class prob1_30 {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        int x = 0;
        double t = 1.1;
        while (h < n/3) h = (int) Math.floor(Math.pow(t, x++));

        while (h >= 1) {
            StdOut.print("\t" + h);
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            assert isHsorted(a, h);
            h /= t;
        }
        assert isSorted(a);
        StdOut.println();
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }

    // print array to standard output
    private static void show(IntCompare[] a) {
        for (int i = 0; i < 100; i++) {
            StdOut.println(a[i].key);
        }
    }

    public static void main(String[] args)
    {
        IntCompare[] n = new IntCompare[10000000];
        for(int i = 0; i < n.length; i++)
        {
            n[i] = new IntCompare();
        }

        Stopwatch watch = new Stopwatch();
        sort(n);
        StdOut.println("Time: " + watch.elapsedTime());
        show(n);
    }
}

class IntCompare implements Comparable
{
    public final int key;

    public IntCompare()
    {
        key = StdRandom.uniform(10000000);
    }

    @Override
    public int compareTo(Object o) {
        IntCompare object = (IntCompare) o;
        if(key < object.key)
            return -1;
        else if(key > object.key)
            return 1;
        else
            return 0;
    }

}
