/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;

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
        
        //The ArrayLists will act as auto expanding Character arrays to keep track of characters
        //for the different keys.
        LinearProbingHashST<String, ArrayList<Character>> dictionary = new LinearProbingHashST();
        In source = new In(args[0]);
        String sourceText = source.readAll();

        int stride = Integer.parseInt(args[1]);
        for(int i = 0; i < sourceText.length() - stride; i++)
        {
            //Get the key of characters.
            String chars = sourceText.substring(i, i + stride);
            
            //Get the list of characters that come from this key.
            ArrayList<Character> list;
            if(dictionary.contains(chars))
                list = dictionary.get(chars);
            else
                list = new ArrayList();

            //Get the character after the key and place it in the array.
            list.add(sourceText.charAt(i + stride));
            dictionary.put(chars, list);
        }
        
        //Add the initial key to the output.
        StringBuilder textOutput = new StringBuilder();
        textOutput.append(sourceText.substring(0, stride));

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
                //Add random character from source.
                int random = StdRandom.uniform(sourceText.length());
                textOutput.append(sourceText.charAt(random));
            }
        }
        
        if(args.length > 3 && args[3] != null)
        {
            Out out = new Out(args[3]);
            out.print(textOutput.toString());
            out.close();
        }
        else
        {
            StdOut.println(textOutput.toString());
        }
    }
}
