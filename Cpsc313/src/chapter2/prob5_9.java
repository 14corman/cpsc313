/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Heap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Cory Edwards
 */
public class prob5_9 {
    
    public static File sort(File file) throws IOException
    {
        ArrayList<String> strings = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line = br.readLine();
            while (line != null) {
                String[] tempString = line.split(" ");
                strings.add(tempString[1] + "," + tempString[0]);
                line = br.readLine();
            }
        } 
        
        String[] lines = strings.toArray(new String[0]);
        Heap.sort(lines);
        File output = new File("sortedData.txt");
        try(PrintWriter writer = new PrintWriter(output, "UTF-8"))
        {
            for(String dataLine : lines)
            {
                String[] dataParts = dataLine.split(",");
                writer.write(dataParts[1] + " " + dataParts[0]);
            }
        }
        
        return file;
    }
}
