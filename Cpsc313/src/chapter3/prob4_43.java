/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import chapter3.classes.ModifiedLinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author cjedwards1
 */
public class prob4_43
{
    public static void main(String[] args)
    {
        for(int n = 1; n < 250000; n *= 2)
        {
            int compares = 0;
            for(int i = 0; i < 100; i++)
            {
                ModifiedLinearProbingHashST<Integer, Integer> map = new ModifiedLinearProbingHashST(n);
                for(int x = 0; x < n; x++)
                    compares += map.put(StdRandom.uniform(-100000, 100000), x);
            }
            
            StdOut.println(" n = " + n + " actual compares = " + (compares / 100) + " estimated compares = " + (Math.sqrt(Math.PI / 2) * Math.sqrt(Math.pow(n, 3))));
        }
    }
}
