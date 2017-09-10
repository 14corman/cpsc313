package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob4_12 {
    public static void printPairs(int[] a, int[] b, int n)
    {
        ArrayList<Integer> pairs = new ArrayList();
        for(int i = 0; i < n; i++)
            if(a[i] == b[i])
                if(!pairs.contains(a[i])){
                    StdOut.println(a[i]);
                    pairs.add(a[i]);
                }
    }
    
    public static void main(String[] args) {
        int n = 50;
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = StdRandom.uniform(-10, 10);
            b[i] = StdRandom.uniform(-10, 10);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        StdOut.println("a: " + Arrays.toString(a));
        StdOut.println("b: " + Arrays.toString(b));
        printPairs(a, b, n);
    }
    
}
