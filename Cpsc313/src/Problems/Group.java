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
    private int[] group = new int[1];
    private int n = 0;
    
    public int getElement(int item) 
    {
        return group[item];
    }
    
    public int[] getEntries()
    {
        return group;
    }
    
    
    public void add(Integer entry)
    {
        if(n == group.length) resize(2 * group.length);
        group[n++] = entry;
    }
    
    private void resize(int max)
    {
        int[] temp = new int[max];
        System.arraycopy(group, 0, temp, 0, n);
        group = temp;
    }
    
    public void close()
    {
        group = new int[0];
    }
    
    @Override
    public String toString()
    {
        String list = "\t";
        for(Integer item :  group)
        {
            list += item + "   ";
        }
        
        return list;
    }
}
