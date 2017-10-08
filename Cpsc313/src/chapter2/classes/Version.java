/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2.classes;

/**
 *
 * @author Cory Edwards
 */
public class Version implements Comparable{

    public int first;
    public int second;
    public int third;
    public Version(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public Version(String svn)
    {
        String[] parts = svn.split("\\.");
        first = Integer.parseInt(parts[0]);
        second = Integer.parseInt(parts[1]);
        third = Integer.parseInt(parts[2]);
    }
    
    @Override
    public int compareTo(Object o) {
        Version v2 = (Version) o;
        if(first > v2.first) return 1;
        if(first < v2.first) return -1;
        if(second > v2.second) return 1;
        if(second < v2.second) return -1;
        if(third > v2.third) return 1;
        if(third < v2.third) return -1;
        return 0;
    }
    
    @Override
    public String toString()
    {
        return first + "." + second + "." + third;
    }
}
