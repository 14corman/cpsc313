package chapter3;

import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

/**
 *
 * @author Cory Edwards
 */
public class prob4_4 {
    public static void main(String[] args) {
        int minM = Integer.MAX_VALUE;
        char[] keys = new char[]{'S', 'E', 'A', 'R', 'C', 'H', 'X', 'M', 'P', 'L'};
        for(int a = 1; a < 100; a++){
            for(int m = 1; m < 25; m++){
                ArrayList<Integer> hashes = new ArrayList();
                for(char key : keys){
                    int hash = (a * key) % m;
                    if(!hashes.contains(hash))
                        hashes.add(hash);
                    else
                        break;
                }
                
                if(hashes.size() == keys.length){
                    if(m < minM)
                        minM = m;
                    StdOut.println("a = " + a + " m = " + m);
                }
            }
        }
        
        StdOut.println("Min m = " + minM);
    }
    
}
