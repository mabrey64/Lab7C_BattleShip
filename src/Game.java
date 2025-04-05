
import java.util.List;

public class Game
{
    public Board board;
    public Ship[] ships;
    public Ship[][] positions;
    public StatusDisplay statusDisplay;

    public Game ()
    {
        // Initialize the game
        positions = new Ship[10][10];
        board = new Board(this);
        statusDisplay = new StatusDisplay(0, 0, 0, 0);
    }

    public void StartGame()
    {
        RandomizeShips();
    }

    public void RandomizeShips()
    {
        int rows = 10;
        int cols = 10;

        Ship ship1 = new Ship("Carrier", 5);
        Ship ship2 = new Ship("Battleship", 4);
        Ship ship3 = new Ship("Cruiser", 3);
        Ship ship4 = new Ship("Submarine", 3);
        Ship ship5 = new Ship("Destroyer", 2);
        ships = new Ship[] { ship1, ship2, ship3, ship4, ship5 };

        positions = new Ship[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                positions[i][j] = null;
            }
        }

        for (Ship ship : ships)
        {
            boolean placed = false;
            while (!placed)
            {
                int row = (int) (Math.random() * rows);
                int col = (int) (Math.random() * cols);
                boolean horizontal = Math.random() < 0.5;

                int size = ship.GetSize();
                boolean canPlace = true;

                if (horizontal)
                {
                    if (col + size > cols)
                    {
                        canPlace = false;
                    }
                    else
                    {
                        for (int k = 0; k < size; k++)
                        {
                            if (positions[row][col + k] != null)
                            {
                                canPlace = false;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    if (row + size > rows)
                    {
                        canPlace = false;
                    }
                    else
                    {
                        for (int k = 0; k < size; k++)
                        {
                            if (positions[row + k][col] != null)
                            {
                                canPlace = false;
                                break;
                            }
                        }
                    }
                }

                if (canPlace)
                {
                    if (horizontal)
                    {
                        for (int k = 0; k < size; k++)
                        {
                            positions[row][col + k] = ship;
                        }
                    }
                    else
                    {
                        for (int k = 0; k < size; k++)
                        {
                            positions[row + k][col] = ship;
                        }
                    }
                    placed = true;
                }
            }
        }
    }

    public void HandleMove(int row, int col)
    {
        // Code to handle the move
        if (positions[row][col] != null) {
            // Hit
            positions[row][col].RegisterHit();
            System.out.println("Hit at (" + row + ", " + col + ")");
            if (positions[row][col].IsSunk()) {
                System.out.println("Ship sunk!");
            }
        } else {
            // Miss
            System.out.println("Miss at (" + row + ", " + col + ")");
        }
    }

    public void DetermineGameState()
    {
        // Code to determine the game state
    }

    public void DisplayWin()
    {
        // Code to display the win
    }

    public void DisplayLoss()
    {
        // Code to display the loss
    }


}
