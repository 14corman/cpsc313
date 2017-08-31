/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

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
        
        Random rand = new Random();
        for(int i = 0; i < 25; i++)
        {
            for(int x = 0; x < 25; x++)
            {
                groups.addGroup(rand.nextInt(25), rand.nextInt(25));
            }
        }
        
        System.out.println(groups.toString());
    }
}
