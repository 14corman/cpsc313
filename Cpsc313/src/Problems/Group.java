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
public class Group
{
    private Entry[] group = new Entry[0];
    
    public Entry getElement(int item) 
    {
        return group[item];
    }
    
    public Entry[] getEntries()
    {
        return group;
    }
    
    public void setGroup(Entry[] entries)
    {
        group = entries;
    }
    
    public void add(Entry entry)
    {
        Entry[] temp = new Entry[group.length + 1];
        System.arraycopy(group, 0, temp, 0, group.length);
        temp[temp.length - 1] = entry;
        group = temp;
    }
    
    @Override
    public String toString()
    {
        String list = "\t";
        for(Entry item :  group)
        {
            list += item + "   ";
        }
        
        return list;
    }
}
