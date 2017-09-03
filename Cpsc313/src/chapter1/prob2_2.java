/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

/**
 *
 * @author Cory Edwards
 */
public class prob2_2 {
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        ArrayList<Interval1D> intervals = new ArrayList();
        StdOut.println("Please put in 2 doubles for an interval.");
        
        //Read n intervals from the user.
        for(int i = 0; i < n; i++)
        {
            StdOut.println("Interval " + (i + 1) + ":");
            double d1 = StdIn.readDouble();
            double d2 = StdIn.readDouble();
            intervals.add(new Interval1D(d1, d2));
        }
        
        Interval1D[] intIntervals = intervals.toArray(new Interval1D[0]);
        
        //Go over every interval pair and see if they intersect, and if they do print.
        for(int i = 0; i < intIntervals.length; i++)
        {
            Interval1D i1 = intIntervals[i];
            for(int x = i + 1; x < intIntervals.length; x++)
            {
                Interval1D i2 = intIntervals[x];
                if(i1.intersects(i2))
                {
                    StdOut.println("Intervals " + (i + 1) + " with min=" + i1.min() + " and max=" + i1.max() + " and " + (x + 1) + " with min=" + i2.min() + " and max=" + i2.max() + " intersect");
                }
            }
        }
    }
}
