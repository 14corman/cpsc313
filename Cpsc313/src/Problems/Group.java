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
public class Group<K>
{
    private Object[] group = new Object[0];
    
    public K getElement(int i) 
    {
        @SuppressWarnings("unchecked")
        final K e = (K) group[i];
        return e;
    }
    
    public boolean contains(K i)
    {
        for(K item : (K[]) group)
        {
            if(item == i)
                return true;
        }
        
        return false;
    }
    
    public Integer getPos(K i)
    {
        int o = 0;
        for(K item : (K[]) group)
        {
            if(item == i)
                return o;
            o++;
        }
        
        return null;
    }
    
    private void increment()
    {
        Object[] temp = new Object[group.length  + 1];
        System.arraycopy(group, 0, temp, 0, temp.length);
        group = temp;
    }
    
    public void add(K i)
    {
        increment();
        group[group.length] = i;
    }
    
    @Override
    public String toString()
    {
        String list = "\t\t";
        for(K item : (K[]) group)
        {
            list += item + "   ";
        }
        
        return list;
    }
}
