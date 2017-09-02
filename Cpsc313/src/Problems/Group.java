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
    private int[] group = new int[0];
    
    public int getElement(int i) 
    {
        final int e = group[i];
        return e;
    }
    
    public boolean contains(int i)
    {
        return getPos(i) != -1;
    }
    
    /**
     * Binary search.
     * @param i
     * @return The position of the element or -1 if the element is not in the group.
     */
    public int getPos(int i)
    {
        int start = 0;
        int end = group.length - 1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(i == group[mid])
                return mid;
            
            if(i < (int) group[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    
    public void add(int item)
    {
        int[] temp = new int[group.length + 1];
        
        if(temp.length == 1)
        {
            temp[0] = item;
            group = temp;
            return;
        }
        
        int i = 0;
        for(;i < group.length; i++)
        {
            if(group[i] == item)
                return;
            
            if(group[i] < item)
                temp[i] = group[i];
            else
                break;
        }
        
        temp[i++] = item;
        
        for(; i - 1 < group.length; i++)
        {
            if(group[i - 1] == item)
                return;
            
            temp[i] = group[i - 1];
        }
        
        group = temp;
    }
    
    @Override
    public String toString()
    {
        String list = "\t";
        for(int item : (int[]) group)
        {
            list += item + "   ";
        }
        
        return list;
    }
    
    public static void main(String[] args)
    {
        Group g = new Group();
        g.add(5);
        g.add(2);
        g.add(10);
        g.add(7);
        g.add(4);
        g.add(4);
        
        System.out.println(g);
    }
}
