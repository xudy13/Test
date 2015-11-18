package towerofhanoi;

/**
 * Tests the Disc Class.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class DiscTest extends student.TestCase {

    private Disc d1;
    private Disc d2;
    private Disc d3;
    
    /**
     * Sets up three discs to be tested.
     */
    public void setUp()
    {
        d1 = new Disc(7);
        d2 = new Disc(9);
        d3 = null;
    }
    
    /**
     * Tests the compareTo method.
     */
    public void testCompareTo()
    {
        boolean caught = false;        
        try 
        {
            d1.compareTo(d3);
        }
        catch (IllegalArgumentException x)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(d1.compareTo(d2), -2);
        assertEquals(d1.compareTo(d1), 0);
        assertEquals(d2.compareTo(d1), 2);
    }
    
    /**
     * Tests the toString method.
     */
    public void testToString()
    {
        assertEquals(d1.toString(), "7");
    }
    
    /**
     * Tests the equals method.
     */
    public void testEquals()
    {
        Disc d4 = new Disc(7);
        assertFalse(d1.equals(d3));
        assertTrue(d1.equals(d1));
        assertTrue(d1.equals(d4));
        String str = "yes";
        assertFalse(d1.equals(str));
        assertFalse(d1.equals(d2));
    }
}
