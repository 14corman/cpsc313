/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob2_3 {
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        ArrayList<Interval2D> intervals = new ArrayList();
        
        //Since x and y are private in Interval2D, we need to keep track of them externally to see when 1 interval is in another.
        ArrayList<Interval1D> xs = new ArrayList();
        ArrayList<Interval1D> ys = new ArrayList();
        
        //Parameter checking
        if(min < 0 || max < 0 || max < min)
            throw new IllegalArgumentException("min or max if off");
        
        StdDraw.setCanvasSize((int) (Math.abs(min) + Math.abs(max)) * 100, (int) (Math.abs(min) + Math.abs(max)) * 100);
        StdDraw.setXscale(min - 1, max + 1);
        StdDraw.setYscale(min - 1, max + 1);
        
        for(int i = 0; i < n; i++)
        {
            double iMin1 = StdRandom.uniform(min, max);
            double iMax1 = StdRandom.uniform(min, max);
            while(iMin1 > iMax1)
                iMax1 = StdRandom.uniform(min, max);
            
            Interval1D i1 = new Interval1D(iMin1, iMax1);
            
            double iMin2 = StdRandom.uniform(min, max);
            double iMax2 = StdRandom.uniform(min, max);
            while(iMin2 > iMax2)
                iMax2 = StdRandom.uniform(min, max);
            
            Interval1D i2 = new Interval1D(iMin2, iMax2);
            Interval2D interval = new Interval2D(i1, i2);
            interval.draw();
            intervals.add(interval);
            xs.add(i1);
            ys.add(i2);
        }
        
        Interval2D[] intervalsArray = intervals.toArray(new Interval2D[0]);
        for(int i = 0; i < intervalsArray.length; i++)
        {
            Interval2D i1 = intervalsArray[i];
            Interval1D x1 = xs.get(i);
            Interval1D y1 = ys.get(i);
            for(int x = i + 1; x < intervalsArray.length; x++)
            {
                Interval2D i2 = intervalsArray[x];
                Interval1D x2 = xs.get(x);
                Interval1D y2 = ys.get(x);
                
                if(i1.intersects(i2))
                    System.out.println("(" + i1 + "), (" + i2 + ") intersect");
                
                if(x1.min() < x2.min() && x1.max() > x2.max() && y1.min() < y2.min() && y1.max() > y2.max())
                    System.out.println("(" + i2 + ") is inside (" + i1 + ")");
                else if(x1.min() > x2.min() && x1.max() < x2.max() && y1.min() > y2.min() && y1.max() < y2.max())
                    System.out.println("(" + i1 + ") is inside (" + i2 + ")");
            }
        }
        StdDraw.show();
    }
}
