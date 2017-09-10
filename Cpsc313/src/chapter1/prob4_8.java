package chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 *
 * @author Cory Edwards
 */
public class prob4_8 {
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String[] objects = in.readAllLines();
        Arrays.sort(objects);
        int count = 0;
        for(int i = 0; i < objects.length - 1; i++)
            if(objects[i].equals(objects[i + 1])) count++;
        StdOut.println("Number of pairs = " + count);
    }
}
