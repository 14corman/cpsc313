package chapter4;

import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import java.util.Iterator;

/**
 *
 * @author Cory Edwards
 * This would be GraphProperties
 */
public class prob1_16 {
    private int center;
    private int radius;
    private int diameter;
    public prob1_16(Graph G) throws Exception {
        for(int i = 0; i < G.V(); i++)
            if(G.degree(i) != G.V() - 1) throw new Exception();
        getProperties(G, G.V());
    }
    private void getProperties(Graph G, int v){
        DepthFirstPaths dfp = new DepthFirstPaths(G, 0);
        int min = Integer.MAX_VALUE;
        int max = 0;
        int vertex = 0;
        for(int i = 0; i < v; i++){
            int count = 0;
            for(Integer nv : dfp.pathTo(i))
                count++;
            if(min > count) {
                min = count;
                vertex = i;
            }
            if(max < count) max = count;
        }
        diameter = max;
        radius = min;
        center = vertex;
    }
    public int diameter(){
        return diameter;
    }
    public int radius(){
        return radius;
    }
    public int center(){
        return center;
    }
}
