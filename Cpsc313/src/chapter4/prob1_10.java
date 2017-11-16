/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import edu.princeton.cs.algs4.Graph;

/**
 *
 * @author Cory Edwards
 */
public class prob1_10 {
    public int findRemovealNode(Graph g) throws Exception {
        for(int i = 0; i < g.V(); i++)
            if(g.degree(i) != g.V() - 1) throw new Exception();
        return 0;
    }
}
