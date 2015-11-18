package towerofhanoi;

import java.util.Observable;

/**
 * Solves the HanoiTower using a variety of methods.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDiscs;
    
    /**
     * Initializes a hanoi solver with a number of discs.
     * @param numDiscs Number of discs to be solved.
     */
    public HanoiSolver(int numDiscs)
    {
        this.numDiscs = numDiscs;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }
    
    /**
     * Gets the number of discs being solved.
     * @return number of discs.
     */
    public int discs()
    {
        return numDiscs;
    }
    
    /**
     * Returns tower at a given position.
     * @param pos position of tower
     * @return the tower at that position.
     */
    public Tower getTower(Position pos)
    {
        switch(pos)
        {
            case LEFT: 
                return left;
            case MIDDLE: 
                return middle;
            case RIGHT: 
                return right;
            default: 
                throw new IllegalArgumentException();
        }
    }
    
    /**
     * Converts the discs on each tower to a string of their widths.
     * @return the created string.
     */
    @Override
    public String toString()
    {
        return left.toString() + middle.toString() + 
                right.toString();
    }
    
    /**
     * Moves a disc to and from designated towers.
     * @param source the source of the disc
     * @param destination were the disc will be moved to
     */
    private void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        this.setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * Adjusts the positioning of the discs on the towers using 
     * recursion.
     * @param num Number of Discs
     * @param startPole Initial Pole
     * @param tempPole Pole used for temporary placement
     * @param endPole Pole where the discs will end up.
     */
    private void solveTowers(int num, Tower startPole, 
            Tower tempPole, Tower endPole)
    {
        if (num == 1)
        {
            move(startPole, endPole);
        }
        
        else
        {
            solveTowers(num - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(num - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Method to execute solving of the puzzle.
     */
    public void solve()
    {
        solveTowers(numDiscs, left, middle, right);
    }
    
    
}
