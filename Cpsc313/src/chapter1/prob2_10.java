/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import chapter1.classes.VisualCounter;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Cory Edwards
 */
public class prob2_10 {
    
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        VisualCounter counter = new VisualCounter(n, max);
        
        StdDraw.setCanvasSize(n * 100, max * 10);
        StdDraw.setXscale(0, n + 1);
        StdDraw.setYscale(-0.5, max + 1);
        StdDraw.setPenRadius(0.01);
        new Point2D(0, 0).draw();
        
        for(int i = 0; i < n + 5; i++)
        {
            if(StdRandom.bernoulli(p))
                counter.increment();
            else
                counter.decrement();
        }
        
        StdDraw.show();
    }
}
