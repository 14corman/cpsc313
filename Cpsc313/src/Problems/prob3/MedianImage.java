/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob3;

import edu.princeton.cs.algs4.Heap;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Cory Edwards
 */
public class MedianImage {
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0) return;
        
        //Get initial metadata for pictures.
        BufferedImage tempImage = ImageIO.read(new File(args[0]));
        int width = tempImage.getWidth();
        int height = tempImage.getHeight();
        int numPictures = args.length;
        BufferedImage[] images = new BufferedImage[numPictures];
        for(int i = 0; i < numPictures; i++)
            images[i] = ImageIO.read(new File(args[i]));
        
        //Create the new image based off the files' metadata coming in, then
        //go over each pixel in the image to set it.
        BufferedImage newImage = new BufferedImage(width, height, tempImage.getType());
        for (int col = 0; col < width; col++) 
        {
            for (int row = 0; row < height; row++) 
            {
                //Get every red, green, and blue value from pixel at (col, row)
                //for all images.
                Integer[] red = new Integer[numPictures];
                Integer[] green = new Integer[numPictures];
                Integer[] blue = new Integer[numPictures];
                for(int i = 0; i < numPictures; i++)
                {
                    Color pixel = new Color(images[i].getRGB(col, row));
                    red[i] = pixel.getRed();
                    green[i] = pixel.getGreen();
                    blue[i] = pixel.getBlue();
                }
                
                //Sort the red, green, and blue arrays and get the median from
                //the sorted arrays.
                Heap.sort(red);
                Heap.sort(green);
                Heap.sort(blue);
                Color medianPixel = new Color(
                        red[numPictures / 2], 
                        green[numPictures / 2], 
                        blue[numPictures / 2]);
                newImage.setRGB(col, row, medianPixel.getRGB());
            }
        }
        
        ImageIO.write(newImage, "jpg", 
                new File(System.getProperty("user.dir") + File.separator + "medianPicture.jpg"));
    }
}
