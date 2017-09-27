/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

import edu.princeton.cs.algs4.Queue;

/**
 *
 * @author Cory Edwards
 */
public class prob2_14 {
    
    public static Queue<Integer> mergeQueue(Queue<Integer> a, Queue<Integer> b)
    {
        if(a.isEmpty() && b.isEmpty())
            return new Queue();
        else if(b.isEmpty())
            return a;
        else if(a.isEmpty())
            return b;
        else{
            Queue<Integer> queue = new Queue();
            while(!a.isEmpty() || !b.isEmpty()){
                if(!a.isEmpty() && !b.isEmpty()){
                    if(a.peek() < b.peek())
                        queue.enqueue(a.dequeue());
                    else
                        queue.enqueue(b.dequeue());
                }
                else if(a.isEmpty())
                    queue.enqueue(b.dequeue());
                else
                    queue.enqueue(a.dequeue());
            }
            return queue;
        }
    }
    
    public static void main(String[] args)
    {
        Queue<Integer> a = new Queue();
        Queue<Integer> b = new Queue();
        a.enqueue(5);
        a.enqueue(7);
        a.enqueue(9);
        a.enqueue(11);
        a.enqueue(13);
        a.enqueue(15);
        System.out.println(a);
        b.enqueue(4);
        b.enqueue(6);
        b.enqueue(8);
        b.enqueue(10);
        b.enqueue(12);
        b.enqueue(14);
        System.out.println(b);
        System.out.println(mergeQueue(a, b));
    }
}
