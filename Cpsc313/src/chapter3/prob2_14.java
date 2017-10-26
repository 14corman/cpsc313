/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3;

import edu.princeton.cs.algs4.Queue;
import java.util.NoSuchElementException;

/**
 *
 * @author Cory Edwards
 */
public class prob2_14<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    
    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        Node current = root;
        Node prev = current;
        while(current != null){
            prev = current;
            current = current.left;
        }
        return prev.key;
    }
    
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        Node current = root;
        Node prev = current;
        while(current != null){
            prev = current;
            current = current.right;
        }
        return prev.key;
    } 
    
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node current = root;
        Node prev = null;
        int cmp = key.compareTo(current.key);
        while(cmp != 0) {
            prev = current;
            if (cmp < 0) current = current.left;
            else         current = current.right;
            if(current == null) return prev.key;
            cmp = key.compareTo(current.key);
        }
        if (prev == null) return null;
        else              return prev.key;
    } 
    
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node current = root;
        Node prev = null;
        int cmp = key.compareTo(current.key);
        while(cmp != 0) {
            prev = current;
            if (cmp > 0) current = current.right;
            else         current = current.left;
            if(current == null) return prev.key;
            cmp = key.compareTo(current.key);
        }
        if (prev == null) return null;
        else              return prev.key;
    } 
    
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        Node current = root;
        int rank = 0;
        while(current != null) {
            int cmp = key.compareTo(current.key); 
            if      (cmp < 0) current = current.left;
            else if (cmp > 0) {
                rank += 1 + size(current.left);
                current = current.right;
            } 
            else              return size(current.left);
        }
        return rank;
    } 
    
    public Key select(int k) {
        if (k < 0 || k >= size())
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        
        Node current = root;
        while(current != null) {
            int t = size(current.left); 
            if(t > k){
                current = current.left;
            } 
            else if(t < k){
                current = current.right;
                k = k - t - 1;
            } 
            else return current.key; 
        }
        return null;
    }
    
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue();
        return keys(min(), max());
    }
    
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue();
        Node current = root;
        while(current != null) {
            int cmplo = lo.compareTo(current.key); 
            int cmphi = hi.compareTo(current.key); 
            if (cmplo < 0) current = current.left;
            if (cmplo <= 0 && cmphi >= 0) queue.enqueue(current.key); 
            if (cmphi > 0) current = current.right; 
        }
        return queue;
    } 
}
