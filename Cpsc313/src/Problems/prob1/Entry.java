/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems.prob1;

/**
 *
 * @author Cory Edwards
 */
public class Entry {
    
    private final int key;
    private int group = -1;
    
    public Entry(int key)
    {
        this.key = key;
    }
    
    public int getKey()
    {
        return key;
    }
    
    public void setGroup(int group)
    {
        this.group = group;
    }
    
    public int getGroup()
    {
        return group;
    }
    
    /**
     * Returns whether this Entry's key is larger than entry's key.
     * @param entry
     * @return True if this key is larger than entry's key
     */
    public boolean compare(Entry entry)
    {
        return entry.getKey() < key;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(key);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        
        if(!(obj instanceof Entry))
            return false;
        
        final Entry e = (Entry) obj;
        return e.getKey() == key;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.key;
        return hash;
    }
}
