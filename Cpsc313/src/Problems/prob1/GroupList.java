/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author cjedwards1
 * 
 * Import version of problem.
 */
public class GroupList<K>
{
    private final HashMap<K, Integer> groups;
    
    //Current group number on.
    private int currentGroup = 1;
    
    public GroupList()
    {
        groups = new HashMap<>();
    }
    
    public boolean addPair(K first, K second)
    {
        if(first == second)
            return false;
        
        Integer fGroup = groups.get(first);
        Integer sGroup = groups.get(second);
        
        if(fGroup == null && sGroup == null)        //Neither item is in a group
        {
            groups.put(first, currentGroup);
            groups.put(second, currentGroup);
            currentGroup++;
            return true;
        }
        else if(fGroup == null && sGroup != null)   //Second is in group
        {
            groups.put(first, sGroup);
            return true;
        }
        else if(fGroup != null && sGroup == null)   //First is in group
        {
            groups.put(second, fGroup);
            return true;
        }
        
        return false;
    }
    
    /**
     * Query to check if 2 elements are in the same group.
     * @param first
     * @param second
     * @return True if first and second are in the same group or if neither are in a group.
     */
    public boolean inSameGroup(K first, K second)
    {
        return Objects.equals(groups.get(first), groups.get(second));
    }
    
    public int getNumGroups()
    {
        return (int) groups.values().stream().sorted().distinct().count();
    }
    
    public Set<K> getGroup(int n)
    {
        if(n >= groups.size())
            throw new IllegalArgumentException(n + " is too large. Total number of groups = " + groups.size());
        
        Set<K> temp = new HashSet();
        groups.forEach((Object t, Object u) -> 
        {
            if((int) u == n)
                temp.add((K) t);
        });
        return temp;
    }
    
    public String printGroup(int n)
    {
        if(n >= groups.size())
            throw new IllegalArgumentException(n + " is too large. Total number of groups = " + groups.size());
        
        String list = "\tGroup " + n + ":" + System.lineSeparator() + "\t\t";
        Set<K> group = getGroup(n);
        for(K item : group)
        {
            list += item + "     ";
        }
        return list + System.lineSeparator();
    }
    
    @Override
    public String toString()
    {
        StringBuilder[] elements = new StringBuilder[getNumGroups()];
        
        for(K key : groups.keySet())
        {
            int group = groups.get(key) - 1;
            
            if(elements[group] == null)
                elements[group] = new StringBuilder();
            
            
            elements[group].append(key).append("     ");
        }
        
        StringBuilder groupsString = new StringBuilder("Groups: " + System.lineSeparator());
        int i = 1;
        for(StringBuilder group : elements)
        {
            groupsString.append("\tGroup ").append(i).append(":").append(System.lineSeparator()).append("\t\t").append(group).append(System.lineSeparator());
            i++;
        }
        return groupsString.toString();
    }
}
