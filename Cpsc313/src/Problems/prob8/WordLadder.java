/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob8;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Cory Edwards
 */
public class WordLadder {
    public static void main(String[] args)
    {
        //Get all the words from the file and build the graph with them.
        String[] words = new In(args[0]).readAllLines();
        Graph graph = new Graph(words.length);
        getEdges(words, graph);
        
        //Keep some metadata so we can keep track of the longest one and some
        //information about it to print out later.
        int max = 0;
        Iterable<Integer> vertices = null;
        int vertex = 0;
        
        //Go over every word and get its diameter in the graph to see
        //which word has the largest diameter.
        for(int i = 0; i < words.length; i++)
        {
            Diameter diameter = new Diameter(graph, i);
            if(diameter.getDiameter()> max)
            {
                vertices = diameter.getList();
                max = diameter.getDiameter();
                vertex = i;
            }
        }
        
        //If there is a minimum ladder, then print out its information.
        if(vertices == null)
            StdOut.println("No ladders found");
        else
        {
            StdOut.println("The vertex " + vertex + " has the largest minimal graph with " + max + " vertices.");
            for(int v : vertices)
                StdOut.println(words[v]);
        }
    }
    
    //Build the graph from the words.
    private static void getEdges(String[] words, Graph graph)
    {
        for(int i = 0; i < words.length - 1; i++)
        {
            for(int j = i + 1; j < words.length; j++)
            {
                //Go over every letter in both words to check if the
                //letters are equal.
                int difference = 0;
                for(int x = 0; x < 5; x++)
                {
                    if(difference > 1)
                        break;
                    
                    if(words[i].charAt(x) != words[j].charAt(x))
                        difference++;
                }
                
                if(difference <= 1)
                    graph.addEdge(i, j);
            }
        }
    }
}

class Diameter
{
    //The min diameter for the given vertex.
    private int diameter = 0;
    
    //The vertex that has the smallest path.
    private Iterable<Integer> vertices;
    
    public Diameter(Graph G, int v) 
    {
        getProperties(G, v);
    }
    
    private void getProperties(Graph G, int v)
    {
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, v);
        for(int i = 0; i < G.V(); i++)
        {
            int length = bfs.distTo(i);
            Iterable<Integer> iter = bfs.pathTo(i);
            if(diameter < length && iter != null)
            {
                diameter = length;
                vertices = bfs.pathTo(i);
            }
        }
    }
    public int getDiameter(){
        return diameter;
    }
    
    public Iterable getList()
    {
        return vertices;
    }
}
