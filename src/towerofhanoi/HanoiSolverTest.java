package towerofhanoi;

/**
 * Tests the Hanoi Solver.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class HanoiSolverTest extends student.TestCase {

    private HanoiSolver hs;
    
    /**
     * Sets up a new Hanoi Solver with 5 discs.
     */
    public void setUp()
    {
        hs = new HanoiSolver(2);
    }
    
    /**
     * Should return the number of discs.
     */
    public void testDiscs()
    {
        assertEquals(hs.discs(), 2);
    }
    
    /**
     * Returns the tower at a given location.
     * Throws an exception if the parameter is invalid.
     */
    public void testGetTower()
    {
        
        boolean caught = false;
        try
        {
            hs.getTower(Position.AHEAD);
        }
        catch (IllegalArgumentException x)
        {
            caught = true;
        }
        assertTrue(caught);
        
        assertEquals(hs.getTower(Position.LEFT).getClass(),
                Tower.class);
        assertEquals(hs.getTower(Position.RIGHT).getClass(), 
                Tower.class);
        assertEquals(hs.getTower(Position.MIDDLE).getClass(),
                Tower.class);
    }
    
    /**
     * Tests that the current game setup is converted 
     * to a string.
     */
    public void testToString()
    {
        assertEquals(hs.toString(), "[][][]");
        Disc disc = new Disc(6);
        hs.getTower(Position.LEFT).push(disc);
        assertEquals(hs.toString(), "[6][][]");
    }
    
    /**
     * Tests that the problem is solved correctly.
     */
    public void testSolve()
    {
        Disc disc1 = new Disc(6);
        hs.getTower(Position.LEFT).push(disc1);
        Disc disc2 = new Disc(4);
        hs.getTower(Position.LEFT).push(disc2);
        hs.solve();
        assertEquals(hs.toString(), "[][][4, 6]");
    }
}
