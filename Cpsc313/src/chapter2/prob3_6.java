/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import chapter2.classes.QuickCount;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Cory Edwards
 */
public class prob3_6 {
    public static void main(String[] args)
    {
        Integer[] n = new Integer[Integer.parseInt(args[0])];
        for(int i = 0; i < n.length; i++)
            n[i] = i;
        int sum = 0;
        int sorts = 1000;
        for(int i = 0; i < sorts; i++)
        {
            QuickCount count = new QuickCount();
            count.sort(n);
            sum += count.compares;
//            StdOut.println(sum);
        }
        StdOut.println("Cn = " + (sum / sorts));
    }
}
