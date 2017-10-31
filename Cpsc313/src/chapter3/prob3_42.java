/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import chapter3.classes.ModifiedRedBlackTree;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 *
 * @author Cory Edwards
 */
public class prob3_42 {
    public static void main(String[] args)
    {
        int[] ns = new int[]{10000, 100000, 1000000};
        
        for(int n : ns)
        {
            double totalPercent = 0.0;
            for(int i = 0; i < 100; i++)
            {
                double red = 0.0;
                int total = 0;
                ModifiedRedBlackTree<Integer, Integer> tree = new ModifiedRedBlackTree();
                for(int x = 0; x < n; x++)
                    tree.put(StdRandom.uniform(-100000, 100000), x);
                Iterable<Boolean> itrb = tree.colors();
                Iterator<Boolean> it = itrb.iterator();
                while(it.hasNext())
                    if(it.next())
                        red++;
                total = tree.size();
                totalPercent = red / total;
            }
            StdOut.printf("%7d %5.1f\n", n, totalPercent);
        }
    }
}
