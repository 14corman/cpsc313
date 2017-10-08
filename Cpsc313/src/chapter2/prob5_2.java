/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Cory Edwards
 */
public class prob5_2 {
    public static void main(String[] args)
    {
       String line;
       ArrayList<String> strings = new ArrayList();
       StdOut.println("To add to the list type a word then hit enter. "
               + "To finish list hit enter on a blank line.");
       while(!(line = StdIn.readLine()).equals(""))
           strings.add(line);

       StdOut.println();
       String[] list = strings.toArray(new String[0]);
       MergeX.sort(list, (Comparator) (Object o1, Object o2) -> 
       {
           int compare = o1.toString().length();
           int to = o2.toString().length();
           if(compare < to) return -1;
           if(compare > to) return 1;
           return 0;
       });

       for(int i = 0; i < list.length; i++){
           String s1 = list[i];
           for(int j = i + 1; j < list.length; j++){
               String s2 = list[j];
               for(int x = j + 1; x < list.length; x++){
                   String s3 = list[x];
                   if(s1.length() + s2.length() < s3.length()) break;
                   if(s1.length() + s2.length() == s3.length()){
                       if((s1 + s2).equals(s3)) StdOut.println(s3);
                       else if((s2 + s1).equals(s3)) StdOut.println(s3);
                   }
               }
           }
       }
    }
}