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
//        in.show();
        
        int dim = in.width() * in.height();
        int wi = 0;
        int he = 0;
        for(int i = 0; i < dim; i++)
        {
            Color p = in.get(wi, he);
            Color p2 = new Color(
                (p.getRed() & 1) == 1 ? 255 : 0,
                (p.getGreen() & 1) == 1 ? 255 : 0, 
                (p.getBlue() & 1) == 1 ? 255 : 0);
            out.set(wi, he, p2);
            
            if(wi == in.width() - 1)
            {
                wi = 0;
                he++;
            }
            else
                wi++;
        }
//        out.show();
        out.save("Uncovered1A.png");
    }
}
