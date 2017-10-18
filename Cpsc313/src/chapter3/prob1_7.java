/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Cory Edwards
 */
public class prob1_7 {
    public static int getDistinct(int n)
    {
        int distinct = 0, words = 0;
        ST<Integer, Integer> st = new ST();

        // compute frequency counts
        for(int i = 0; i < n; i++)
        {
            int key = StdRandom.uniform(1000);
            words++;
            if (st.contains(key))
                st.put(key, st.get(key) + 1);
            else 
            {
                st.put(key, 1);
                distinct++;
            }
        }

        return distinct;
        // find a key with the highest frequency count
//        String max = "";
//        st.put(max, 0);
//        for (String word : st.keys()) {
//            if (st.get(word) > st.get(max))
//                max = word;
//        }

//        StdOut.println(max + " " + st.get(max));
//        StdOut.println("distinct = " + distinct);
//        StdOut.println("words    = " + words);
    }
    
    public static void main(String[] args)
    {
        for(int n = 10; n <= 100000; n *= 10)
        {
            int sum = 0;
            for(int i = 0; i < 1000; i++)
            {
                sum += getDistinct(n);
            }
            StdOut.printf("%7d %5.1f\n", n, sum / 1000.0);
        }
    }
}
