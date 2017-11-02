/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import chapter3.classes.ModifiedSeparateChainingHashST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Cory Edwards
 */
public class prob4_36 {
    public static void main(String[] args) {
        int[] ns = new int[]{1000, 10000, 100000, 1000000};
        for(int n : ns) {
            ModifiedSeparateChainingHashST<Integer, Integer> map = new ModifiedSeparateChainingHashST(n / 100);
            for(int i = 0; i < n; i++)
                map.put(StdRandom.uniform(-100000, 100000), i);
            
            int shortest = Integer.MAX_VALUE;
            int longest = 0;
            for(SequentialSearchST array : map.st) {
                if(shortest > array.size())
                    shortest = array.size();
                if(longest < array.size())
                    longest = array.size();
            }
            StdOut.println("n = " + n + " shortest = " + shortest + " longest = " + longest);
        }
    }
    
}
