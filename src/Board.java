import javax.swing.*;

public class Board
{
    private GridButton[][] grid;
    private Game game;
    private JPanel boardPanel;

    public Board(JPanel boardPanel)
    {
        this.boardPanel = boardPanel;
        this.game = new Game();
        grid = new GridButton[10][10];
    }
    public void DisplayBoard()
    {
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

//    public void ResetBoard()
//    {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                grid[i][j].setIcon(null);
//                grid[i][j].SetMark("");
//                grid[i][j].removeShips(true); //potentially another method to add to the UML diagram
//            }
//        }
//    }

    public void PlaceMark (int row, int col, String mark, StatusDisplay statusDisplay)
    {
       String currentState = grid[row][col].GetMark();
       if(!currentState.equals(mark))
       {
           grid[row][col].SetMark(mark, statusDisplay);
       }
    }
}
