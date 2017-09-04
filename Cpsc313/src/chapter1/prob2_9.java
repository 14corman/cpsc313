/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob2_9 {
    
    public static int indexOf(int[] a, int key, Counter counter)
    {
        counter.increment();
        
        //Array must be sorted
        int lo = 0;
        int hi = a.length - 1;
        
        while(lo <= hi)
        {
            //Key is in a[lo...hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid])
                hi = mid - 1;
            else if(key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] whiteList = new int[Integer.parseInt(args[0])];
        for(int i = 0; i < whiteList.length; i++)
            whiteList[i] = StdRandom.uniform(25);
        
        System.out.println(Arrays.toString(whiteList));
        
        Counter counter = new Counter("Number of keys searched");
        Arrays.sort(whiteList);
        
        int key = StdIn.readInt();
        while(key != -1)
        {
            //Read key. Print if not i whiteList.
            if(indexOf(whiteList, key, counter) == -1)
                StdOut.println(key);
            
            key = StdIn.readInt();
        }
        
        StdOut.println(counter);
    }
}
