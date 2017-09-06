/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1.classes;

/**
 *
 * @author cjedwards1
 */
public class Date
{
    private final int month;
    private final int day;
    private final int year;
    
    public Date(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    
    public int month()
    {
        return month;
    }
    
    public int day()
    {
        return day;
    }
    
    public int year()
    {
        return year;
    }
    
    @Override
    public String toString()
    {
        return month() + "/" + day() + "/" + year();
    }
    
    @Override
    public boolean equals(Object x)
    {
        if(this == x)
            return true;
        
        if(x == null)
            return false;
        
        if(this.getClass() != x.getClass())
            return false;
        
        Date that = (Date) x;
        if(this.day != that.day)
            return false;
        
        if(this.month != that.month)
            return false;
        
        if(this.year != that.year)
            return false;
        
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + this.month;
        hash = 37 * hash + this.day;
        hash = 37 * hash + this.year;
        return hash;
    }
}
