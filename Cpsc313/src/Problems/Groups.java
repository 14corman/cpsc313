/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

/**
 *
 * @author cjedwards1
 */
public class Groups
{
    private final Entry[] items;
    
    //Number of groups.
    private int n = 0;
    
    public Groups(int n)
    {
        items = new Entry[n];
        for(int i = 0; i < n; i++)
        {
            items[i] = new Entry(i);
        }
    }
    
    /**
     * Put all the elements from group 2 into group 1.
     * @param group1
     * @param group2 
     */
    public void join(int group1, int group2)
    {
        for(Entry entry : items)
        {
            if(entry.getGroup() == group2)
                entry.setGroup(group1);
            else if(entry.getGroup() > group2)
                entry.setGroup(entry.getGroup() - 1);
        }
        n--;
    }
    
    public int getNumItems()
    {
        return items.length;
    }
    
    public int getNumGroups()
    {
        return n;
    }
    
    //query if 2 items are in same group
    public boolean inSameGroup(int first, int second)
    {
        int f = items[first].getGroup();
        int s = items[second].getGroup();
        
        if(s == -1 || f == -1)
            return false;
        else
        {
            return s == f;
        }
    }
    
    //add element to group
    private void add(int item, int group)
    {
        items[item].setGroup(group);
    }
    
    //toString
    @Override
    public String toString()
    {
        String[] groupString = new String[n];
        
        for(Entry entry : items)
        {
            int group = entry.getGroup();
            if(group != -1)
            {
                if(groupString[group] == null)
                    groupString[group] = "Group " + group + ":" + System.lineSeparator() + "\t";

                groupString[group] += entry.getKey() + "   ";
            }
        }
        
        String g = "";
        for(String group : groupString)
            g += group + System.lineSeparator();
        
        return g;
    }
    
    
    //print group i
    public String printGroup(int group)
    {
        String list = null;
        for(Entry item :  items)
        {
            if(item.getGroup() == group)
            {
                if(list == null)
                    list = "\t";
                
                list += item + "   ";
            }
        }
        
        return list;
    }
    
    //add pair
    public void addPair(int first, int second)
    {
        int firstB = getGroupWithItem(first);
        int secondB = getGroupWithItem(second);
        
        //If both items are in a set, and they are equal then break since they are already in the same group.
        if(firstB != -1 && secondB != -1 && firstB == secondB)
            return;
        
        if(firstB != -1 && secondB != -1)       //Both are in different groups so join secondB to firstB.
            join(firstB, secondB);
        else if(firstB != -1 && secondB == -1)  //Add second to first group.
            add(second, firstB);
        else if(firstB == -1 && secondB != -1)  //Add first to second group.
            add(first, secondB);
        else                                    //Neither is in a group so add both to new group.
        {
            items[first].setGroup(n);
            items[second].setGroup(n);
            n++;
        }
    }
    
    //Get group of item.
    public int getGroupWithItem(int item)
    {
        return items[item].getGroup();
    }
}
