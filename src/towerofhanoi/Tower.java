package towerofhanoi;

/**
 * Creates towers for discs to be stacked on.
 * @author Daniel Xu <xudy>
 * @version 2015.10.18 
 *
 */
public class Tower extends LinkedStack<Disc> {

    private Position position;
    
    /**
     * Takes a position.
     * @param position position of the tower.
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
    
    /**
     * Position of a tower.
     * @return the position
     */
    public Position position()
    {
        return position;
    }
    
    /**
     * Puts a new disc onto a tower.
     * @param disc disc being pushed onto the tower
     */
    @Override
    public void push(Disc disc)
    {
        if (this.isEmpty() || disc.compareTo(super.peek()) < 0)
        {
            super.push(disc);
        }
        
        else
        {
            throw new IllegalStateException();
        }
    }
}
