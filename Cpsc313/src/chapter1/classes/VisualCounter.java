/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.classes;

import edu.princeton.cs.algs4.Point2D;

/**
 *
 * @author Cory Edwards
 */
public class VisualCounter {
    
    private final int n;
    private final int max;
    private int count = 0;
    private int ops = 0;
    
    public VisualCounter(int n, int max)
    {
        this.n = n;
        this.max = max;
    }
    
    public void increment()
    {
        if(ops < n)
        {
            if(Math.abs(count) <= max)
            {
                count++;
                ops++;
                new Point2D(ops, tally()).draw();
            }
        }       
    }
    
    public void decrement()
    {
        if(ops < n)
        {
            if(Math.abs(count) <= max)
            {
                count--;
                ops++;
                new Point2D(ops, tally()).draw();
            }
        }       
    }
    
    public int tally()
    {
        return Math.abs(count);
    }
}
