/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MaxPQ;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Cory Edwards
 */
public class prob3_24 {
    private double weight;
    private final Set<Edge> mst = new HashSet();

    public prob3_24(EdgeWeightedGraph G) {
        MaxPQ<Edge> pq = new MaxPQ();
        for (Edge e : G.edges()) {
            pq.insert(e);
            mst.add(e);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.delMax();
            mst.remove(e);
            if(!checkIfConnected(G.V())){
                weight += e.weight();
                mst.add(e);
            }
        }
    }
    
    private boolean checkIfConnected(int v){
        boolean[] marked = new boolean[v];
        for(Edge e : mst)
            marked[e.either()] = true;
        
        for(int i = 0; i < v; i++)
            if(!marked[i])
                return false;
        return true;
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}