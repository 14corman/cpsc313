package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob4_16 {
    public static double[] closestPair(double[] a, int n)
    {
        double[] pair = new double[2];
        double min = Double.MAX_VALUE;
        Arrays.sort(a);
        for(int i = 0; i < n - 1; i++){
            double tMin = Math.abs(Math.abs(a[i + 1]) - Math.abs(a[i]));
            if(tMin < min){
                pair[0] = a[i];
                pair[1] = a[i + 1];
                min = tMin;
            }
        }
        return pair;
    }
    
    public static void main(String[] args) {
        int n = 50;
        double[] a = new double[n];
        for(int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-10.0, 10.0);
        StdOut.println(Arrays.toString(closestPair(a, n)));
    }
}
