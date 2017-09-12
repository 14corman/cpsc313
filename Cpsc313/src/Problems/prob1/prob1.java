/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author cjedwards1
 */
public class prob1
{
    public static void main(String args[])
    {
        In in = new In(args[0]);
        int n = in.readInt() + 1;
        
        //Import version
//        GroupList<Integer> groups = new GroupList();

        //Non import version
        Groups groups = new Groups(n);
        
        String line;
        while(in.hasNextLine())
        {
            line = in.readLine();
            if(!line.equals(""))
            {
                String[] parts = line.split(" ");
                groups.addPair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            }
        }
        
        in.close();
        
        //Print out for Prob1Data1.txt
        StdOut.println("1 and 2 together? " + groups.inSameGroup(1, 2));
        StdOut.println("2 and 7 together? " + groups.inSameGroup(2, 7));
        StdOut.println("3 and 5 together? " + groups.inSameGroup(3, 5));
        StdOut.println("6 and 7 together? " + groups.inSameGroup(6, 7));
        StdOut.println("1 and 8 together? " + groups.inSameGroup(1, 8));
        StdOut.println("1 and 9 together? " + groups.inSameGroup(1, 9));
        StdOut.println();
        StdOut.println("Number of groups: " + groups.getNumGroups());
        StdOut.println("Number of items: " + groups.getNumItems());
//        StdOut.println();
//        StdOut.println(groups.toString());
    }
}
