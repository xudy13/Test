package towerofhanoi;

import java.util.Observable;
import java.util.Observer;

import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Creates a window for the game.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 */
public class GameWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    private final int DISC_GAP = 2;
    private final int DISC_HEIGHT = 5;
    
    /**
     * Creates the window, towers, discs, and solve button.
     * @param game the game instance of Hanoi Towers.
     */
    public GameWindow(HanoiSolver game)
    {
        this.game = game;
        this.game.addObserver(this);
        
        window = new Window();
        window.setTitle("Tower of Hanoi");
        
        left = new Shape(window.getGraphPanelWidth() / 4,
                window.getGraphPanelHeight() / 4, 2, 100);
        window.addShape(left);
        
        middle = new Shape(window.getGraphPanelWidth() / 2, 
                window.getGraphPanelHeight()/4, 2, 100);
        window.addShape(middle);
        
        right = new Shape(3 * window.getGraphPanelWidth() / 4, 
                window.getGraphPanelHeight() / 4, 2, 100);
        window.addShape(right);
        
        for (int numDiscs = 5; numDiscs > 0; numDiscs--)
        {
            Disc currentDisc = new Disc(numDiscs * 10);
            game.getTower(Position.LEFT).push(currentDisc);
            window.addShape(currentDisc);
            this.moveDisc(Position.LEFT);
        }
        
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this);
    }
    
    /**
     * Updates the window with the newest instance of the program.
     */
    public void update(Observable arg0, Object arg1) {
        if (arg1.getClass().equals(Position.class))
        {
            Position position = (Position) arg1;
            moveDisc(position);
            this.sleep();
        }
    }
    
    /**
     * Moves the discs to a given tower.
     * @param pos the position to which the disc will move.
     */
    private void moveDisc(Position pos)
    {
        Disc currentDisc = game.getTower(pos).peek();
        Shape currentTower;
        
        if (pos == Position.LEFT)
        {
            currentTower = left;
        }
        
        else if (pos == Position.MIDDLE)
        {
            currentTower = middle;
        }
        
        else if (pos == Position.RIGHT)
        {
            currentTower = right;
        }
        
        else 
        {
            throw new IllegalArgumentException();
        }
        
        int x = (currentTower.getX() + currentTower.getWidth() / 2) - 
                (currentDisc.getWidth() / 2);
        int y = (currentTower.getY() + currentTower.getHeight()) - 
                (((game.getTower(pos)).size()) * DISC_HEIGHT) - DISC_GAP;
        currentDisc.moveTo(x, y);
    }
    
    /**
     * Returns the window in order to test.
     * @return The window.
     */
    public Window getWindow()
    {
        return window;
    }
    
    /**
     * Allows the program to wait in between processes.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    } // end sleep

    /**
     * Solves the HanoiTower when the button is clicked.
     * @param button button that needs to be clicked.
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Main method that executes the program.
     * @param args String array of discs.
     */
    static public void main(String[] args)
    {
        int discs = 5;
        if (args.length == 1)
        {
            discs = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(discs);
        new GameWindow(hanoi);
    }

}
