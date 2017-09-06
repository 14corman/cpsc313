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
public class Transaction
{
    private final String who;
    private final Date when;
    private final double amount;
    
    public Transaction(String who, Date when, double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    
    public String who()
    {
        return who;
    }
    
    public Date when()
    {
        return when;
    }
    
    public double amount()
    {
        return amount;
    }
    
    @Override
    public String toString()
    {
        return who() + "\t" + when() + "\t" + amount();
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
        
        Transaction that = (Transaction) x;
        if(this.amount != that.amount)
            return false;
        
        if(!this.when.equals(that.when))
            return false;
        
        if(!this.who.equals(that.who))
            return false;
        
        return true;
    }
}
