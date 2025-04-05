import javax.swing.*;
import java.awt.*;

public class Board {
    GridButton[][] grid;
    private Game game;
    private JPanel boardPanel;

    public Board(Game game) {
        this.game = game; // Use the passed game object
        this.boardPanel = new JPanel(new GridLayout(10, 10)); // Set the layout here
        grid = new GridButton[10][10];
    }

    public void DisplayBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new GridButton();
                int row = i;
                int col = j;
                grid[i][j].addActionListener(e -> game.HandleMove(row, col));
                boardPanel.add(grid[i][j]);
            }
        }
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void PlaceMark(int row, int col, String mark, StatusDisplay statusDisplay) {
        String currentState = grid[row][col].GetMark();
        if (!currentState.equals(mark)) {
            grid[row][col].SetMark(mark, statusDisplay);
        }
    }
}