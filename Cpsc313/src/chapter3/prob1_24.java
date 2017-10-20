/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import chapter3.classes.CutSearchST;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author cjedwards1
 */
public class prob1_24
{
    public static void main(String[] args) {
        int n = 100, m = 1000000;
        double sum = 0.0;
        Integer[] ints = new Integer[m];
        for(int i = 0; i < m; i++)
            ints[i] = StdRandom.uniform(100);
        
        for(int i = 0; i < n; i++)
        {
            int distinct = 0, words = 0;
//            BinarySearchST<Integer, Integer> st = new BinarySearchST();
            CutSearchST<Integer> st = new CutSearchST();
            Stopwatch watch = new Stopwatch();

            for(Integer key : ints) {
                words++;
                if (st.contains(key)) {
                    st.put(key, st.get(key) + 1);
                }
                else {
                    st.put(key, 1);
                    distinct++;
                }
            }
            
            
            // find a key with the highest frequency count
            Integer max = Integer.MAX_VALUE;
            st.put(max, 0);
            for (Integer word : st.keys()) {
                if (st.get(word) > st.get(max))
                    max = word;
            }

//            StdOut.println(max + " " + st.get(max));
//            StdOut.println("distinct = " + distinct);
//            StdOut.println("words    = " + words);
//            StdOut.println();
            sum += watch.elapsedTime();
        }
        StdOut.println("Total = " + (sum / n));
    }
}
