/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob2;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.Stopwatch;
import java.awt.Color;

/**
 *
 * @author cjedwards1
 */
public class PictureDecryptor
{
    public static void main(String[] args)
    {
        Picture in = new Picture(args[0]);
        Picture out = new Picture(in.width(), in.height());
        in.show();
        
        Stopwatch watch = new Stopwatch();
        int dim = in.width() * in.height();
        int wi = 0;
        int he = 0;
        for(int i = 0; i < dim; i++)
        {
            if(wi == in.width() - 1)
            {
                wi = 0;
                he++;
            }
            
            Color p = in.get(wi, he);
            System.out.println(p.getRed());
            System.out.println((p.getRed() & 1) == 1 ? 255 : 0);
            out.set(wi, he, new Color(
                (p.getRed() & 1) == 1 ? 255 : 0,
                (p.getGreen() & 1) == 1 ? 255 : 0, 
                (p.getBlue() & 1) == 1 ? 255 : 0));
        }
        System.out.println("Time = " + watch.elapsedTime());
        
//        Stopwatch watch = new Stopwatch();
//        for(int w = 0; w < in.width(); w++)
//        {
//            for(int h = 0; h < in.height(); h++)
//            {
//                Color p = in.get(w, h);
//                System.out.println(p.getRed());
//                System.out.println((p.getRed() & 1) == 1 ? 255 : 0);
//                int r = (p.getRed() & 1) == 1 ? 255 : 0;
//                int g = (p.getGreen() & 1) == 1 ? 255 : 0;
//                int b = (p.getBlue() & 1) == 1 ? 255 : 0;
//                Color converted = new Color(r, g, b);
//                out.set(w, h, converted);
//            }
//        }
//        System.out.println("Time = " + watch.elapsedTime());
        
        out.show();
    }
}
