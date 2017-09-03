/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;

/**
 *
 * @author Cory Edwards
 */
public class prob2_1 {
    
    public static void main(String[] args)
    {
        ArrayList<Point2D> points = new ArrayList();
        int n = Integer.parseInt(args[0]);
        
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);
        StdDraw.setPenRadius(0.005);
        
        for(int i = 0; i < n; i++)
        {
            double x;
            double y;
            
            //Decide if x will be (-) or (+).
            if(StdRandom.bernoulli())
                x = 1.0;
            else
                x = -1.0;
            
            //Decide if y will be (-) or (+).
            if(StdRandom.bernoulli())
                y = 1.0;
            else
                y = -1.0;
            
            //For the dots to form a square, either x or y need to be 1,
            //so decide which one will be 1 and make the other [0,1).
            if(StdRandom.bernoulli())
                x *= StdRandom.uniform();
            else
                y *= StdRandom.uniform();
            
            Point2D point = new Point2D(x, y);
            point.draw();
            points.add(point);
        }
        
        Point2D[] totalPoints = points.toArray(new Point2D[0]);
        
        //If there are any points, the distance will always be less than max, so
        //set min to max so that we are sure to get those points.
        double min = Double.MAX_VALUE;
        int p1 = -5;
        int p2 = -5;
        
        //Go over every point with every other point to see which has the shortes distance.
        for(int i = 0; i < totalPoints.length; i++)
        {
            for(int x = i + 1; x < totalPoints.length; x++)
            {
                double distance = totalPoints[i].distanceTo(totalPoints[x]);
                if(distance < min)
                {
                    min = distance;
                    p1 = i;
                    p2 = x;
                }
            }
        }
        
        //Pint the calc shortest distance and the 2 points it comes from.
        StdOut.println("Shortest distance is " + min + " and is for points " + p1 + " and " + p2);
        
        //Show the shortest distance in red on the graph.
        if(p1 != -5 && p2 != -5)
        {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.002);
            totalPoints[p1].drawTo(totalPoints[p2]);
            StdDraw.show();
        }
    }
}
