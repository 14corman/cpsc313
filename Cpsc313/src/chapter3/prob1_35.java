/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import static chapter1.prob4_41.timeTrial;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSumFast;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Cory Edwards
 */
public class prob1_35 {
    public static double timeTrial(int n) throws IOException {
        int distinct = 0, words = 0;
        String[] tales = new String(Files.readAllBytes(Paths.get("C:\\NSF\\cpsc313\\Cpsc313\\tale_of_two_cities.txt"))).split(" ");
        SequentialSearchST<String, Integer> st = new SequentialSearchST();

        // compute frequency counts
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < tales.length; i++) 
        {
            if(i == n) break;
            String key = tales[i];
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
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        return timer.elapsedTime();
    }
    
    public static void main(String[] args) throws IOException
    {
        double prev = timeTrial(125);
        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
            StdOut.println();
            prev = time;
        } 
    }
}
