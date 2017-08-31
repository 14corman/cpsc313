/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cjedwards1
 */
public class GroupList<K>
{
    private final ArrayList<Set<K>> groups;
    
    public GroupList()
    {
        groups = new ArrayList<>();
    }
    
    public void addGroup(K first, K second)
    {
        for(Set<K> group : groups)
        {
            if(group.contains(first) && group.contains(second))
                return;
            else if(group.contains(first))
            {
                group.add(second);
                return;
            }
            else if(group.contains(second))
            {
                group.add(first);
                return;
            }
        }
        
        Set<K> group = new HashSet();
        group.add(first);
        group.add(second);
        groups.add(group);
    }
    
    public int getNumGroups()
    {
        return groups.size();
    }
    
    public Set<K> getGroup(int n)
    {
        if(n >= groups.size())
            throw new IllegalArgumentException(n + " is too large. Total number of groups = " + groups.size());
        
        return groups.get(n);
    }
    
    public String printGroup(int n)
    {
        if(n >= groups.size())
            throw new IllegalArgumentException(n + " is too large. Total number of groups = " + groups.size());
        
        String list = "\tGroup " + n + ":" + System.lineSeparator() + "\t\t";
        for(K item : groups.get(n))
        {
            list += item + "     ";
        }
        return list + System.lineSeparator();
    }
    
    @Override
    public String toString()
    {
        String groupsString = "Groups: " + System.lineSeparator();
        for(int i = 0; i < groups.size(); i++)
        {
            groupsString += printGroup(i);
        }
        
        return groupsString;
    }
}
