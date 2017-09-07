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
    private Group[] groups = new Group[1];
    private final Entry[] items;
    private int n = 0;
    
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
        Group group = groups[group2];
        for(int key : group.getEntries())
        {
            groups[group1].add(key);
                items[key - 1].setGroup(group1);
        }
        
        int moved = n - group2 - 1;
        if(moved > 0)
        {
            System.arraycopy(groups, group2 + 1, groups, group2, moved);
            for(int i = group2; i < group2 + moved; i++)
            {
                int[] keys = groups[i].getEntries();
                for(int key : keys)
                {
                        items[key].setGroup(i);
                }
            }
        }
        
        n--;
//        groups[n].close();
        groups[n] = null;
        
        if(n > 0 && n == groups.length / 4) resize(groups.length / 2);
        
    }
    
    public int getNumItems()
    {
        return items.length;
    }
    
    public int getNumGroups()
    {
        return n;
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
        groups[group].add(items[item - 1].getKey());
        items[item - 1].setGroup(group);
    }
    
    //toString
    @Override
    public String toString()
    {
        String groupString = "";
        for(int i = 0; i < n; i++)
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
            join(firstB, secondB);
        else if(firstB != -1 && secondB == -1)
            add(second, firstB);
        else if(firstB == -1 && secondB != -1)
            add(first, secondB);
        else
        {
            Group group = new Group();
            group.add(items[first - 1].getKey());
            group.add(items[second - 1].getKey());
            
            if(n == groups.length) resize(2 * groups.length);
            
            items[first - 1].setGroup(n);
            items[second - 1].setGroup(n);
            groups[n++] = group;
        }
    }
    
    private void resize(int max)
    {
        Group[] temp = new Group[max];
        System.arraycopy(groups, 0, temp, 0, n);
        groups = temp;
    }
    
    //Is item in a group
    public int getGroupWithItem(int item)
    {
        Integer g = items[item - 1].getGroup();
        
        return g == null ? -1 : g;
    }
}
