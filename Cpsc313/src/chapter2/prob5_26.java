/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


/**
 *
 * @author Cory Edwards
 */
public class prob5_26 {
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int max = 25;
        MinPQ<Point2D> points = new MinPQ(n, Point2D.Y_ORDER);
        for(int i = 0; i < n; i++)
            points.insert(new Point2D(StdRandom.uniform(max), StdRandom.uniform(max)));
        
        Point2D yMin = points.delMin();
        MinPQ<Point2D> minPolar = new MinPQ(n - 1, yMin.polarOrder());
        while(!points.isEmpty()) minPolar.insert(points.delMin());
        
        StdDraw.setCanvasSize(500, 500);  //Size of canvas + 50 to fit cirlces in.
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(0, max);
        Point2D current = yMin;
        while(!minPolar.isEmpty()){
            Point2D next = minPolar.delMin();
            current.drawTo(next);
            current = next;
        }
        current.drawTo(yMin);
        StdDraw.show();
    }
}
