package towerofhanoi;

import java.util.EmptyStackException;

/**
 * Tests the LinkedStack class.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<String> strStack;
    
    /**
     * Sets up a stack to be used in testing.
     */
    public void setUp()
    {
        strStack = new LinkedStack<String>();
    }
    
    /**
     * Tests that the correct size is returned.
     */
    public void testSize()
    {
        assertEquals(strStack.size(), 0);
    }
    
    /**
     * Tests that the push method adds an entry.
     */
    public void testPush()
    {
        strStack.push("baseDisc");
        assertEquals(strStack.size(), 1);
    }
    
    /**
     * Tests that the the correct boolean is returned
     * depending on if the stack is empty or not.
     */
    public void testIsEmpty()
    {
        assertTrue(strStack.isEmpty());
        strStack.push("disc");
        assertFalse(strStack.isEmpty());
    }
    
    /**
     * Assert that clear removes all entries.
     */
    public void testClear()
    {
        strStack.push("yes");
        strStack.push("no");
        strStack.clear();
        assertTrue(strStack.isEmpty());
    }
    
    /**
     * Tests that peek returns the top entry.
     */
    public void testPeek()
    {
        boolean caught = false;
        try
        {
            strStack.peek();
        }
        catch (EmptyStackException x)
        {
            caught = true;
        }
        assertTrue(caught);
        strStack.push("little");
        assertEquals(strStack.peek(), "little");
        strStack.push("medium");
        assertEquals(strStack.peek(), "medium");
    }
    
    /**
     * Tests that the stack is correctly converted
     * to a string.
     */
    public void testToString()
    {
        assertEquals(strStack.toString(), "[]");
        strStack.push("Is Cool");
        strStack.push("CS2114");
        assertEquals(strStack.toString(), "[CS2114, Is Cool]");
    }
    
}
