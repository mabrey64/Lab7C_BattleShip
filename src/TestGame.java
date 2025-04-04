import javax.swing.*;
import java.awt.*;

public class TestGame
{
        public static void main(String[] args)
        {
            // Create a JPanel to pass to the Board constructor
            JPanel boardPanel = new JPanel(new GridLayout(10, 10));

            // Create instances of the classes
            Board board = new Board(boardPanel);
            StatusDisplay statusDisplay = new StatusDisplay(0, 0, 0, 0);

            // Display the board
            board.DisplayBoard();

            // Test placing a mark
            board.PlaceMark(0, 0, "Miss", statusDisplay);
            board.PlaceMark(1, 1, "Hit", statusDisplay);

            // Check the status display
            System.out.println(statusDisplay);

            // Check the marks on the grid
            System.out.println("Mark at (0,0): " + board.grid[0][0].GetMark());
            System.out.println("Mark at (1,1): " + board.grid[1][1].GetMark());
        }
}

