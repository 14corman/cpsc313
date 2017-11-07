/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author cjedwards1
 */
public class BlackFilterModified
{
    // Do not instantiate.
    private BlackFilterModified() { }

    public static void main(String[] args) {
        Object dummy = new Object();
        double time = 0.0;
        for(int i = 0; i < 10; i++)
        {
            Stopwatch watch = new Stopwatch();
            RedBlackBST<String, Object> dict = new RedBlackBST();
//            SeparateChainingHashST<String, Object> dict = new SeparateChainingHashST();
//            LinearProbingHashST<String, Object> dict = new LinearProbingHashST();

            // read in strings and add to set
            In dictFile = new In(args[0]);
            while (!dictFile.isEmpty()) {
                String word = dictFile.readString();
                dict.put(word, dummy);
            }

            // read in strings and add to set
            In file = new In(args[1]);
            while (!file.isEmpty()) {
                String word = file.readString();
                if (!dict.contains(word))
                    StdOut.println(word);
            }
            time += watch.elapsedTime();
        }
        StdOut.println("time = " + (time / 10));
    }
}
