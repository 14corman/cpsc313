package chapter3;

import edu.princeton.cs.algs4.Queue;

/**
 *
 * @author cjedwards1
 * Problem 3.5.2
 */
public class SequentialSearchSET<Key> {
    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Node next;

        public Node(Key key, Node next)  {
            this.key  = key;
            this.next = next;
        }
    }

    public SequentialSearchSET() {
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    
    private boolean get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        for (SequentialSearchSET.Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return true;
        }
        return false;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key);
    }

    public void put(Key key) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        first = new Node(key, first);
        n++;
    }
    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
