/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cjedwards1
 */
public class Generator
{
    public static void main(String[] args)
    {
        if(args[0] == null)
        {
            StdOut.println("There must be a source file given");
            return;
        }
        
        if(args[1] == null)
        {
            StdOut.println("Missing number of characters per key");
            return;
        }
        
        if(args[2] == null)
        {
            StdOut.println("Need to specify number of output characters");
            return;
        }
        
        RedBlackBST<String, ArrayList<Character>> dictionary = new RedBlackBST();
        ArrayList<Character> charactersInSource = new ArrayList();
        In source = new In(args[0]);
        String sourceText = source.readAll();
        int stride = Integer.parseInt(args[1]);
        for(int i = 0; i < sourceText.length() - stride; i++)
        {
            //Get the key of characters.
            String chars = sourceText.substring(i, i + stride);
            charactersInSource.add(sourceText.charAt(i));
            
            //Get the list of characters that come from this key.
            ArrayList<Character> list = dictionary.get(chars);
            if(list == null) 
                list = new ArrayList();

            //Get the character after the key and place it in the array.
            char character = sourceText.charAt(i + stride);
            list.add(character);
            dictionary.put(chars, list);
        }
        
        StringBuilder textOutput = new StringBuilder();
        
        //We want to pick (stride) random characters, so pick
        //(stride) random characters from the list of characters.
        for(int i = 0; i < stride; i++)
        {
            int random = StdRandom.uniform(dictionary.size());
            textOutput.append(dictionary.select(random));
        }
        
        
        int outputLength = Integer.parseInt(args[2]);
        for(int i = 0; i < outputLength; i++)
        {
            //Get the list of characters from the current position + (stride)
            String key = textOutput.substring(i, i + stride);
            ArrayList<Character> chars = dictionary.get(key);
            
            if(chars != null)
            {
                //Pick the next character to add randomly from the list of options.
                int random = StdRandom.uniform(chars.size());
                textOutput.append(chars.get(random));
            }
            else
            {
                int random = StdRandom.uniform(charactersInSource.size());
                textOutput.append(charactersInSource.get(random));
            }
        }
        
        if( args.length > 3 && args[3] != null)
        {
            try(BufferedWriter out = new BufferedWriter(new FileWriter(args[3])))
            {
                out.write(textOutput.toString());
            }
            catch(IOException ex)
            {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            StdOut.println(textOutput.toString());
        }
    }
}
