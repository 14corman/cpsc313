package chapter1;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 *
 * @author Cory Edwards
 */
public class prob3_12 {
    public static Stack<String> copy(Stack<String> stack)
    {
        Stack<String> newStack = new Stack();
        Iterator<String> iter = stack.iterator();
        while(iter.hasNext())
            newStack.push(iter.next());
        return newStack;
    }
    
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack();
        stack.push("This");
        stack.push("is");
        stack.pop();
        stack.push("a");
        stack.push("test");
        
        StdOut.println(copy(stack).toString());
    }
}
