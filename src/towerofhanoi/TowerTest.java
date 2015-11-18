package towerofhanoi;

/**
 * Tests the Tower class.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class TowerTest extends student.TestCase {
    
    private Tower t;
    
    /**
     * Sets up a tower for testing.
     */
    public void setUp()
    {
        t = new Tower(Position.LEFT);
    }
    
    /**
     * Should return the position of the tower.
     */
    public void testPosition()
    {
        assertEquals(t.position(), Position.LEFT);
    }
    
    /**
     * Tests that discs can only be pushed onto bigger
     * discs or empty towers.
     */
    public void testPush()
    {
        Disc d1 = new Disc(6);
        t.push(d1);
        assertFalse(t.isEmpty());
        
        boolean caught = false;
        Disc d2 = new Disc(7);
        try
        {
            t.push(d2);
        }
        catch (IllegalStateException x)
        {
            caught = true;
        }
        assertTrue(caught);
    }
}
