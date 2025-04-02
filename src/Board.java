public class Board
{
    private GridButton[][] grid;
    private Game game;

    public Board()
    {
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
            }
        }
    }

    public void ResetBoard()
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j].setIcon(null);
                grid[i][j].SetMark("");
                grid[i][j].removeShips(true); //potentially another method to add to the UML diagram
            }
        }
    }

    public void PlaceMark (int row, int col)
    {
        grid[row][col].SetMark();
    }
}
