/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Cory Edwards
 */
public class MoviePredictor {
    public static void main(String[] args)
    {
        LinearProbingHashST<String, Double> wordRatings = new LinearProbingHashST();
        In ratingsFile = new In(args[0]);
        String line;
        while((line = ratingsFile.readLine()) != null)
        {
            //Separate the rating from the message.
            double rating = Double.parseDouble(line.substring(0, 1));
            String message = line.substring(2);
            
            //Get rid of extra characters so it is only the words.
            message = message.replace(".", "").replace("?", "").replace("!", "").replace(",", "").toLowerCase();
            String[] words = message.split(" ");
            
            //Go over each word in the message separated by a space.
            for(String word : words)
            {
                //If the word has a valid double attached to it then
                //average the 2 ratings together. Otherwise put the new
                //rating in.
                if(wordRatings.contains(word))
                {
                    Double currentRating = wordRatings.get(word);
                    if(currentRating == null)
                        wordRatings.put(word, rating);
                    else
                        wordRatings.put(word, (rating + currentRating) / 2.0);
                }
                else
                    wordRatings.put(word, rating);
            }
        }
        
        //Get and separate the new message to rate just like all earlier
        //messages.
        String newMessage = args[1];
        newMessage = newMessage.replace(".", "").replace("?", "").replace("!", "").replace(",", "").toLowerCase();
        String[] words = newMessage.split(" ");
        double rating = 0.0;
        for(String word : words)
        {
            if(wordRatings.contains(word))
                rating = (rating + wordRatings.get(word)) / 2.0;
        }
        
        StdOut.println("Rating: " + rating);
        StdOut.println(newMessage);
    }
}
