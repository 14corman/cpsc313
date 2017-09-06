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
    private Group[] groups = new Group[0];
    private final Entry[] items;
    
    public Groups(int n)
    {
        items = new Entry[n];
        for(int i = 0; i < n; i++)
        {
            items[i] = new Entry(i + 1);
        }
    }
    
    public void join(int group1, int group2)
    {
        Entry[] e = groups[group2].getEntries();
        
        for(Entry entry : e)
        {
            groups[group1].add(entry);
            entry.setGroup(group1);
        }
        
        int moved = groups.length - group2 - 1;
        if(moved > 0)
             System.arraycopy(groups, group2 + 1, groups, group2, moved);
        
        Group[] temp = new Group[groups.length - 1];
        System.arraycopy(groups, 0, temp, 0, temp.length);
        
        groups = temp;
        
    }
    
    public int getNumItems()
    {
        return items.length;
    }
    
    public int getNumGroups()
    {
        return groups.length;
    }
    
    //query if 2 are in same group
    public boolean inSameGroup(int first, int second)
    {
        Integer f = items[first - 1].getGroup();
        Integer s = items[second - 1].getGroup();
        
        if(s == null || f == null)
            return false;
        else
        {
            return s == f;
        }
    }
    
    //add element to group i
    private void add(int item, int group)
    {
        groups[group].add(items[item - 1]);
        items[item - 1].setGroup(group);
    }
    
    //toString
    @Override
    public String toString()
    {
        String groupString = "";
        for(int i = 0; i < groups.length; i++)
        {
            groupString += "Group :" + i + System.lineSeparator() + printGroup(i) + System.lineSeparator();
        }
        
        return groupString;
    }
    
    //get group i
    public Group getGroup(int group)
    {
        return groups[group];
    }
    
    //print group i
    public String printGroup(int group)
    {
        return groups[group].toString();
    }
    
    //add pair
    public void addPair(int first, int second)
    {
        int firstB = getGroupWithItem(first);
        int secondB = getGroupWithItem(second);
        
        if(firstB != -1 && secondB != -1 && firstB == secondB)
            return;
        
        if(firstB != -1 && secondB != -1)
        {
            join(firstB, secondB);
        }
        else if(firstB != -1 && secondB == -1)
        {
            add(second, firstB);
        }
        else if(firstB == -1 && secondB != -1)
        {
            add(first, secondB);
        }
        else
        {
            Group group = new Group();
            group.add(items[first - 1]);
            group.add(items[second - 1]);
            
            Group[] temp = new Group[groups.length + 1];
            System.arraycopy(groups, 0, temp, 0, groups.length);
            temp[temp.length - 1] = group;
            items[first - 1].setGroup(temp.length - 1);
            items[second - 1].setGroup(temp.length - 1);
            
            groups = temp;
        }
    }
    
    //Is item in a group
    public int getGroupWithItem(int item)
    {
        Integer g = items[item - 1].getGroup();
        
        return g == null ? -1 : g;
    }
}
