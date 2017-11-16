package chapter4;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

/**
 *
 * @author Cory Edwards
 */
public class prob1_22 {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("movies.txt", "/");
        Graph G = sg.graph();
        int s = sg.indexOf("Bacon, Kevin");
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        String[] actors = new String[]{"Garfield, Andrew", "Gosling, Ryan", "Mortensen, Viggo", "Washington, Denzel", "Bridges, Jeff", "Ali, Mahershala",
                                        "Patel, Dev", "Hedges, Lucas", "Shannon, Michael", "Huppert, Isabelle", "Negga, Ruth", "Stone, Emma"};
        for(String actor : actors) {
            if (sg.contains(actor)) {
                int t = sg.indexOf(actor);
                if (bfs.hasPathTo(t)) {
                    int number = 0;
                    for (int v : bfs.pathTo(t))
                        number++;
                    StdOut.println(actor + "\t\thas number " + number);
                }
                else
                    StdOut.println(actor + "\t\tNot connected");
            }
            else
                StdOut.println(actor + "\t\tNot in database.");
        }
    }
}
