package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob4_17 {
    public static double[] farthestPair(double[] a, int n)
    {
        double[] pair = new double[2];
        Arrays.sort(a);
        StdOut.println("a: " + Arrays.toString(a));
        pair[0] = a[0];
        pair[1] = a[n - 1];
        return pair;
    }
    
    public static void main(String[] args) {
        int n = 50;
        double[] a = new double[n];
        for(int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-10.0, 10.0);
        StdOut.println(Arrays.toString(farthestPair(a, n)));
    }
}
