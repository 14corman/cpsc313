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
    private double weight;                        // weight of MST
    private final Set<Edge> mst = new HashSet();  // edges in MST

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public prob3_24(EdgeWeightedGraph G) {
        MaxPQ<Edge> pq = new MaxPQ();
        for (Edge e : G.edges()) {
            pq.insert(e);
            mst.add(e);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.delMax();
            if(checkIfConnected(G.V()))
                mst.remove(e);
            else
                weight += e.weight();
        }
    }
    
    private boolean checkIfConnected(int v){
        boolean[] marked = new boolean[v];
        for(Edge e : mst)
            marked[e.either()] = true;
        
        for(Edge e : mst)
            if(!marked[e.either()])
                return false;
        return true;
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }
}
