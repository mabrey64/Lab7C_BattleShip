import javax.swing.*;
import java.awt.*;

public class Board {
    GridButton[][] grid;
    private Game game;
    private JPanel boardPanel;

    /*
        * Constructor to initialize the board with a game object.
        * The board is represented as a 10x10 grid of GridButton objects.
     */
    public Board() {
        this.boardPanel = new JPanel(new GridLayout(10, 10)); // Set the layout here
        grid = new GridButton[10][10];
    }

    public void SetGame(Game game) {
        this.game = game;
    }

    /*
        * This method returns the grid of buttons.
        * It is used to access the grid from other classes.
     */
    public GridButton[][] getGrid() {
        return grid;
    }

    /*
        * This method sets the grid of buttons.
        * It is used to set the grid from other classes.
     */
    public void DisplayBoard() {
        boardPanel.removeAll(); // Clear the panel before adding new buttons
        grid = new GridButton[10][10]; // Initialize the grid again
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new GridButton(i, j);
                grid[i][j].SetMark("", null);
                int row = i;
                int col = j;
                grid[i][j].addActionListener(e -> game.HandleMove(row, col));
                boardPanel.add(grid[i][j]);
            }
        }
        boardPanel.revalidate(); // Revalidate the panel to reflect changes
        boardPanel.repaint(); // Repaint the panel to reflect changes
    }

    /*
        * This method returns the board panel.
        * It is used to access the board panel from other classes.
     */
    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void ClearBoard()
    {
        System.out.println("ClearBoard() called on Board instance: " + this);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].SetMark("", null);
                grid[i][j].displayChar = '≋';
                grid[i][j].setText(String.valueOf(grid[i][j].displayChar));
            }
        }
    }

    public void InitializeGrid() {
        grid = new GridButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new GridButton(i, j);
            }
        }
    }

    /*
        * This method places a mark on the board at the specified row and column.
        * It checks if the current state is different from the new mark before placing it.
        * However, it goes unused in the current implementation.
     */
//    public void PlaceMark(int row, int col, String mark, StatusDisplay statusDisplay) {
//        String currentState = grid[row][col].GetMark();
//        if (!currentState.equals(mark)) {
//            grid[row][col].SetMark(mark, statusDisplay);
//        }
//    }
}