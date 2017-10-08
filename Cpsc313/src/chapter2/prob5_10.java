/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import chapter2.classes.Version;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Cory Edwards
 */
public class prob5_10 {
    public static void main(String[] args)
    {
        Version[] versions = new Version[]{new Version("115.1.0"), new Version("115.10.0"), new Version("115.1.4"), new Version("115.10.4"), new Version("11.0.0"), new Version("11.0.4")
                ,new Version("115.0.5"), new Version("115.0.5"), new Version("115.0.0")};

        Heap.sort(versions);
        for(Version version : versions)
            StdOut.println(version);
    }
}
