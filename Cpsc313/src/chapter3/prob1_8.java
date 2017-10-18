/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Cory Edwards
 */
public class prob1_8 {
    public static void main(String[] args) throws IOException {
        int distinct = 0, words = 0;
        String[] tales = new String(Files.readAllBytes(Paths.get("C:\\NSF\\cpsc313\\Cpsc313\\tale_of_two_cities.txt"))).split(" ");
        int minlen = 10;
        ST<String, Integer> st = new ST();

        // compute frequency counts
        for(String key : tales) 
        {
            if (key.length() < minlen) continue;
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
    }
}
