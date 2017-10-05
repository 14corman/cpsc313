/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author Cory Edwards
 */
public class prob4_39 {
    public static void main(String[] args)
    {
        int n = 10000000;
        double prob = 0.0;

        for(int i = 0; i < 10; i++)
        {
            MaxPQ<Integer> heap = new MaxPQ(n);
            Stopwatch watch = new Stopwatch();
            for(int x = 1; x <= n; x++)
                heap.insert(x);
            double construction = watch.elapsedTime();
            for(int x = 1; x <= n; x++)
                heap.delMax();
            double deleteTime = watch.elapsedTime();
            prob += construction / (construction + deleteTime);
//            StdOut.println("Construct time = " + construction + " Delete time = " + deleteTime);
        }
        
        StdOut.println("Finish time = " + (prob / 10));
    }
}
