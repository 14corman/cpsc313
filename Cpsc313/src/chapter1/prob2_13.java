/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

/**
 *
 * @author Cory Edwards
 */
public class prob2_13 {

    public static void main(String[] args)
    {
        Transaction[] trans = new Transaction[5];
        trans[0] = new Transaction("First", new Date(5, 10, 2017), 45.67);
        trans[1] = new Transaction("Second", new Date(5, 11, 2017), 23.73);
        trans[2] = new Transaction("Third", new Date(5, 12, 2017), 99.99);
        trans[3] = new Transaction("Fourth", new Date(5, 13, 2017), 0.01);
        trans[4] = new Transaction("Fifth", new Date(5, 14, 2017), 56.78);

        for (Transaction tran : trans)
            StdOut.println(tran.toString());
    }
}
