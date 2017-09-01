/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author cjedwards1
 */
public class prob1
{
    public static void main(String args[])
    {
        GroupList<Integer> groups = new GroupList();
        In in = new In(args[0]);
        int n = in.readInt();
        int[] array = new int[n];
        
        for(int i = 0; i < n; i++)
            array[i] = i;
        
        String line;
        while(in.hasNextLine())
        {
            line = in.readLine();
            if(!line.equals(""))
            {
                String[] parts = line.split(" ");
                int first = array[Integer.parseInt(parts[0])];
                int second = array[Integer.parseInt(parts[1])];
                groups.addPair(first, second);
            }
        }
        
        in.close();
        System.out.println(groups.toString());
    }
}
