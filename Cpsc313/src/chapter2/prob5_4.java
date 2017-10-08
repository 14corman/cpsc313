/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob5_4 {
    public static void main(String[] args)
    {
        String[] a = new String[]{"c", "d", "a", "f", "c", "a", "c", "b", "d"};
        String[] newArray = dedup(a);
        StdOut.println(Arrays.toString(newArray));
    }
    
    public static String[] dedup(String[] a)
    {
        Heap.sort(a);
        int count = 0;
        for(int i = 0; i < a.length - 1; i++)
            if(a[i].equals(a[i + 1])){a[i] = ""; count++;}
        Heap.sort(a);
        String[] newArray = new String[a.length - count];
        System.arraycopy(a, count, newArray, 0, newArray.length);
        return newArray;
    }
}
