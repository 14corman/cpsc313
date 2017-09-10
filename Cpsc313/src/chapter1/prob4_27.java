package chapter1;

import chapter1.classes.StackQueue;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Cory Edwards
 */
public class prob4_27 {

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue();
        for(int i = 0; i < 50; i++)
            queue.enqueue(i);
        StdOut.println(queue.toString());
        for(int i = 0; i < 50; i++)
            StdOut.println(queue.dequeue());
        
    }
    
}
