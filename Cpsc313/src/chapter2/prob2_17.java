/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

/**
 *
 * @author Cory Edwards
 */
public class prob2_17 {
    public static Node sortedMerge(Node a, Node b){
        Node result;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.key <= b.key){
            result = a;
            result.next = sortedMerge(a.next, b);
        } 
        else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
 
    public static Node mergeSort(Node a){
        if (a == null || a.next == null)
            return a;
        Node middle = getMiddle(a);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(a);
        Node right = mergeSort(nextToMiddle);
        Node sorted = sortedMerge(left, right);
        return sorted;
    }
 
    public static Node getMiddle(Node a){
        if (a == null)
            return a;
        Node fast = a.next;
        Node slow = a;
        while (fast != null){
            fast = fast.next;
            if(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    
    public static void main(String[] args)
    {
        List list = new List(new Node(5));
        list.add(new Node(3));
        list.add(new Node(9));
        list.add(new Node(6));
        list.add(new Node(4));
        list.add(new Node(2));
        System.out.println(list);
        Node sorted = mergeSort(list.first);
        System.out.println(sorted);
    }
}
class List{
    public Node first;
    public Node last;
    int size = 0;
    public List(Node first){
        this.first = first;
        last = first;
        size++;
    }
    
    public void add(Node node){
        last.next = node;
        last = node;
        size++;
    }
    @Override
    public String toString(){
        Node node = first;
        String result = "";
        while(node != null){
            result += node.key + "  ";
            node = node.next;
        }
        return result;
    }
}
class Node {
    public int key;
    public Node next = null;

    public Node(int key){
        this.key = key;
    }
    @Override
    public String toString(){
        if(next != null) return key + "  " + next.toString();
        else return Integer.toString(key);
    }
}
