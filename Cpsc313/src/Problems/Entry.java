/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

/**
 *
 * @author Cory Edwards
 */
public class Entry {
    
    private final int key;
    private Integer group = null;
    private Entry left = null;
    private Entry right = null;
    
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
    
    public Integer getGroup()
    {
        return group;
    }
    
    public void setLeft(Entry left)
    {
        this.left = left;
    }
    
    public void setRight(Entry right)
    {
        this.right = right;
    }
    
    public Entry getRight()
    {
        return right;
    }
    
    public Entry getLeft()
    {
        return left;
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
