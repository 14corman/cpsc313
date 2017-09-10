/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import edu.princeton.cs.algs4.In;

/**
 *
 * @author cjedwards1
 */
public class prob1
{
    public static void main(String args[])
    {
        In in = new In(args[0]);
        int n = in.readInt();
        GroupList<Integer> groups = new GroupList();
//        Groups groups = new Groups(n);
        
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
//        System.out.println(groups.toString());
    }
}
