/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author cjedwards1
 */
public class BlackFilterModified
{
    // Do not instantiate.
    private BlackFilterModified() { }

    public static void main(String[] args) {
        for(int i = 0; i < 2; i++)
        {
            SET<String> dict = new SET<String>();

            // read in strings and add to set
            In dictFile = new In(args[0]);
            while (!dictFile.isEmpty()) {
                String word = dictFile.readString();
                dict.add(word);
            }

            // read in strings and add to set
            In file = new In(args[1]);
            while (!file.isEmpty()) {
                String word = file.readString();
                if (!dict.contains(word))
                    StdOut.println(word);
            }
        }
    }
}
