/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;


/**
 *
 * @author Cory Edwards
 */
public class rob3_20_21_27_28 {
    
    Node<String> firstNode = new Node();
    int n = 0;
    public void delete(int k)
    {
        if(k > n) return;
        Node<String> node = firstNode;
        int i = 0;
        while(node != null)
        {
            if(i == k - 1)
            {
                Node<String> temp = node.next.next;
                node.next = null;
                node.next = temp;
                return;
            }
            else
            {
                i++;
                node = node.next;
            }
        }
    }
    
    public boolean find(String key, Node<String> first)
    {
        if(key == null) return false;
        Node<String> node = first;
        while(node != null)
        {
            if(node.item.equals(key))
                return true;
            else
                node = node.next;
        }
        return false;
    }
    
    public int max(Node<Integer> first)
    {
        int max = 0;
        Node<Integer> node = first;
        while(node != null)
        {
            max = node.item != null ? (node.item > max ? node.item : max) : max;
            node = node.next;
        }
        return max;
    }
    
    public int recMax(Node<Integer> first)
    {
        int max = 0;
        max = first.item != null ? (first.item > max ? first.item : max) : max;
        if(first.next != null)
        {
            int temp = recMax(first.next);
            if(temp > max) max = temp;
        }
        return max;
    }
    
    // helper linked list class
    public static class Node<Item> {
        public Item item;
        public Node<Item> next;
    }
}
