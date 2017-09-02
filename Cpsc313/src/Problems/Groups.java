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
    Group[] groups = new Group[0];
    
    //query if 2 are in same group
    public boolean inSameGroup(int first, int second)
    {
        int f = getGroupWithItem(first);
        int s = getGroupWithItem(second);
        
        if(f == -1 && s == -1)
            return false;
        else 
            return f == s;
    }
    
    //add element to group i
    private void add(int item, int group)
    {
        groups[group].add(item);
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
    
    //get number of groups
    public int numGroups()
    {
        return groups.length;
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
    public boolean addPair(int first, int second)
    {
        int firstB = getGroupWithItem(first);
        int secondB = getGroupWithItem(second);
        
        if(firstB != -1 && secondB != -1)
            return false;
        else if(firstB != -1 && secondB == -1)
        {
            add(second, firstB);
            return true;
        }
        else if(firstB == -1 && secondB != -1)
        {
            add(first, secondB);
            return true;
        }
        else
        {
            Group group = new Group();
            group.add(first);
            group.add(second);
            
            Group[] temp = new Group[groups.length + 1];
            System.arraycopy(groups, 0, temp, 0, groups.length);
            temp[temp.length - 1] = group;
            
            groups = temp;
            return true;
        }
    }
    
    //Is item in a group
    public int getGroupWithItem(int item)
    {
        int i = 0;
        for(Group group : groups)
        {
            if(group.contains(item))
                return i;
            i++;
        }
        
        return -1;
    }
}
