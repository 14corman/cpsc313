/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.classes;

import edu.princeton.cs.algs4.BinarySearch;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class TwoSumFast {
    
    public static int count(int[] a)
    {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for(int i = 0; i < n; i++)
            if(BinarySearch.indexOf(a, -a[i]) > i)
                count++;
        return count;
    }
}
