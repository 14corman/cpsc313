/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob7;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

/**
 *
 * @author Cory Edwards
 */
public class ShowGraph {
    public static void main(String[] args)
    {
        In input = new In(args[0]);
        
        //Number of vertices to draw.
        int n = input.readInt();

        //Set the size of the canvas.
        StdDraw.setCanvasSize(500, 500);
        
        //We want to get the max x and y coordinates so we can ajust the spacing properly.
        double maxX = 0;
        double maxY = 0;
        
        //Create all the coordinates and get the maxes.
        Point2D[] points = new Point2D[n];
        for(int i = 0; i < n; i++)
        {
            double coord1 = input.readDouble();
            double coord2 = input.readDouble();
            points[i] = new Point2D(coord1, coord2);
            if(coord1 > maxX)
                maxX = coord1;
            
            if(coord2 > maxY)
                maxY = coord2;
        }
        
        //Set the maxes + 2 so the vertices can be seen.
        StdDraw.setXscale(0, maxX + 2);
        StdDraw.setYscale(0, maxY + 2);
        
        //Draw all the vertices on the adjusted canvas.
        for(Point2D point : points)
            point.draw();
        
        //Set pen color for edges and draw the edges for the vertices.
        StdDraw.setPenColor(StdDraw.GRAY);
        while(input.hasNextLine())
        {
            int v1 = input.readInt();
            int v2 = input.readInt();
            points[v1].drawTo(points[v2]);
        }
            
        //Show the canvas to the user.
        StdDraw.show();
    }
}
