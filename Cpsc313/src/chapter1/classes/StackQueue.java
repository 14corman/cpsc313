/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.classes;

import edu.princeton.cs.algs4.Stack;
import java.util.Iterator;

/**
 *
 * @author Cory Edwards
 */
public class StackQueue<K> {
    Stack<K> top = new Stack();
    Stack<K> bottom = new Stack();
    
    public void enqueue(K item)
    {
        bottom.push(item);
        top = new Stack();
        for(Iterator it = bottom.iterator(); it.hasNext();)
            top.push((K) it.next());
    }
    
    public K dequeue()
    {
        K item = top.pop();
        bottom = new Stack();
        for(Iterator it = top.iterator(); it.hasNext();)
            bottom.push((K) it.next());
        return item;
    }
    
    public boolean isEmpty()
    {
        return top.isEmpty();
    }
    
    public int size()
    {
        return top.size();
    }
    
    public Iterator iterator()
    {
        return top.iterator();
    }
    
    public K peek()
    {
        return top.peek();
    }
    
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(Iterator it = top.iterator(); it.hasNext();) {
            s.append(it.next());
            s.append(' ');
        }
        return s.toString();
    }
    
    
}
