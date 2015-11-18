package towerofhanoi;

import java.awt.Color;
import java.util.Random;

import CS2114.Shape;

/**
 * Methods for Disc type objects.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class Disc extends Shape implements Comparable<Disc> {

    /**
     * Initializes Discs.
     * @param width Width of the disc.
     */
    public Disc(int width)
    {
        super(0, 0, width, 5);
        Random random = new Random();
        int x = random.nextInt(255);
        int y = random.nextInt(255);
        int z = random.nextInt(255);
        Color color = new Color(x, y, z);
        this.setBackgroundColor(color);
    }
    
    /**
     * Compares width of current disk and parameter disk.
     * @param otherDisc the disc being compared to
     * @return negative if current < other; positive if current > other;
     * 0 if current = other
     */
    @Override
    public int compareTo(Disc otherDisc) {
        if (otherDisc == null)
        {
            throw (new IllegalArgumentException());
        }
        
        else
        {
            return this.getWidth() - otherDisc.getWidth();
        }
    }
    
    /**
     * Converts the width of the Disc to a string
     * @return the width of the disc in a string
     */
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append(this.getWidth());
        return string.toString();
    }
    
    /**
     * Tests if a disc is equal to another object.
     * @param obj the object being compared to.
     * @return true or false depending on whether the two
     * objects are equal.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        
        if (this == obj)
        {
            return true;
        }
        
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        
        Disc disc = (Disc)obj;
        
        return this.getWidth() == disc.getWidth();
    }

}
