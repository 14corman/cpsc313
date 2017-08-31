/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author cjedwards1
 */
public class prob1_31 {
    
    /**
     * @param args the command-line arguments
     */
    public static void main(String[] args) 
    {
        int n = Integer.parseInt(args[0]);      //Number of nodes to draw.
        double p = Double.parseDouble(args[1]); //Probability that 2 nodes will have a drawn edge.
        int r = n * 5;                          //Radius of cirlce.
        int max = r * 2;                        //Max size of cirlce.

        StdDraw.setCanvasSize(max + 50, max + 50);  //Size of canvas + 50 to fit cirlces in.
        StdDraw.setXscale(0, max + 50);             //Set X to be min 0 and max canvas sise.
        StdDraw.setYscale(0, max + 50);             //Set Y to be min 0 and max canvas sise.
        StdDraw.setPenColor(StdDraw.GRAY);          //Set color to gray for problem.
        
        Point2D[] points = new Point2D[n];  //Init points array.
        int xCen = (max + 50) / 2;          //X center of canvas.
        int yCen = (max + 50) / 2;          //Y center of canvas.
        for (int i = 0; i < n; i++) 
        {
            StdDraw.setPenRadius(0.05);
            double x = xCen + r * Math.cos(2 * Math.PI * i / n);
            double y = yCen + r * Math.sin(2 * Math.PI * i / n);
            points[i] = new Point2D(x, y);
            points[i].draw();
            
            //Have new node go over every other initialized node to see if edge is drawn.
            for(int e = 0; e < i; e++)
            {
                StdDraw.setPenRadius(0.002);
                if(StdRandom.bernoulli(p))
                    points[i].drawTo(points[e]);
            }
        }
            
        StdDraw.show();
    }
}
