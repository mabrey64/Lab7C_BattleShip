import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private GameFrame gameFrame;
    public Board board;
    public Ship[][] positions;
    public StatusDisplay statusDisplay;
    private boolean[][] clicked;
    private List<Ship> allShips = new ArrayList<>();

    public Game (GameFrame gameFrame, Board board)
    {
        // Constuctor for the Game class
        this.gameFrame = gameFrame;
        this.board = board;
        positions = new Ship[10][10];
        clicked = new boolean[10][10];
        statusDisplay = gameFrame.status;
        System.out.println("Game constructor - Board instance: " + board);
        StartGame();
    }

    public void StartGame()
    {
        // Code to start the game
        RandomizeShips();
        // SetStaticShips();
    }

    /*
     * This method randomizes the ship positions on the board.
     * It creates a 10x10 grid and places ships randomly on it.
     * The ships are represented by their size and name.
     * The method checks if the ship can be placed in the desired position
     * and orientation (horizontal or vertical).
     * If the ship can be placed, it updates the positions array
     * with the ship object.
     * The method also clears the previous ship positions
     * and initializes the clicked array.
     * The ships are stored in a list for later reference.
     */

    public void RandomizeShips()
    {
        int rows = 10;
        int cols = 10;

        Ship ship1 = new Ship("Carrier", 5);
        Ship ship2 = new Ship("Battleship", 4);
        Ship ship3 = new Ship("Cruiser", 3);
        Ship ship4 = new Ship("Submarine", 3);
        Ship ship5 = new Ship("Destroyer", 2);
        Ship[] shipsArray = new Ship[] { ship1, ship2, ship3, ship4, ship5 };

        allShips.clear();
        allShips.add(ship1);
        allShips.add(ship2);
        allShips.add(ship3);
        allShips.add(ship4);
        allShips.add(ship5);

        positions = new Ship[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                positions[i][j] = null;
            }
        }

        for (Ship ship : shipsArray)
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

    /*
        * This method resets the game by clearing the ship positions
        * and clicked arrays.
        * It also randomizes the ship positions again.
        * The method initializes the positions array
        * and clicked array to null and false respectively.
        * It is used to start a new game after the previous one ends,
        * or when the player chooses to play again after clicking the Play Again button.
     */
    public void ResetGame() {
        int rows = 10;
        int cols = 10;

        positions = new Ship[rows][cols];
        clicked = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                positions[i][j] = null;
                clicked[i][j] = false;
            }
        }
        allShips.clear();
        RandomizeShips();
        printShipPositions(this);
        board.ClearBoard(); // This sets the displayChar and text of the buttons

        // Force the Board's panel to redraw
        board.getBoardPanel().revalidate();
        board.getBoardPanel().repaint();

        // Optionally, you can also revalidate and repaint the GameFrame's main panel
        gameFrame.mainGame.revalidate();
        gameFrame.mainGame.repaint();

        statusDisplay.ResetCounters();
        statusDisplay.UpdateStatus();
        // SetStaticShips();
    }

    /*
        * This method sets static positions for the ships on the board.
        * It creates a 10x10 grid and places ships in specific positions.
        * The ships are represented by their size and name.
        * The method initializes the positions array
        * and clicked array to null and false respectively.
        * It is used for testing purposes to check if the game logic works correctly
        * with predefined ship positions.
     */
//    public void SetStaticShips() {
//        int rows = 10;
//        int cols = 10;
//
//        Ship ship1 = new Ship("Carrier", 5);
//        Ship ship2 = new Ship("Battleship", 4);
//        Ship ship3 = new Ship("Cruiser", 3);
//        Ship ship4 = new Ship("Submarine", 3);
//        Ship ship5 = new Ship("Destroyer", 2);
//
//        positions = new Ship[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                positions[i][j] = null;
//                ships[i][j] = null;
//                clicked[i][j] = false;
//            }
//        }
//
//        // Set static positions for the ships
//        // Carrier
//        for (int i = 0; i < ship1.GetSize(); i++) {
//            positions[0][i] = ship1;
//            ships[0][i] = ship1;
//        }
//        // Battleship (vertical)
//        for (int i = 0; i < ship2.GetSize(); i++) {
//            positions[i][5] = ship2;
//            ships[i][5] = ship2;
//        }
//        // Cruiser
//        for (int i = 0; i < ship3.GetSize(); i++) {
//            positions[4][i + 3] = ship3;
//            ships[4][i + 3] = ship3;
//        }
//        // Submarine (vertical
//        for (int i = 0; i < ship4.GetSize(); i++) {
//            positions[i + 5][6] = ship4;
//            ships[i + 5][6] = ship4;
//        }
//        // Destroyer
//        for (int i = 0; i < ship5.GetSize(); i++) {
//            positions[8][i + 7] = ship5;
//            ships[8][i + 7] = ship5;
//        }
//    }


    /*
        * This method handles the move made by the player.
        * It checks if the button was already clicked,
        * and if not, it updates the clicked array.
        * It then checks if the move was a hit or a miss
        * and updates the positions array accordingly.
        * The method also updates the status display
        * and checks if all ships are sunk or if the player has lost.
     */
    public void HandleMove(int row, int col)
    {
        if (clicked[row][col]) {
            JOptionPane.showMessageDialog(null,"This button was already clicked!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        clicked[row][col] = true;

        // Code to handle the move
        if (positions[row][col] != null) {
            // Hit
            positions[row][col].RegisterHit();
            System.out.println("Hit at (" + row + ", " + col + ")");
            gameFrame.IncrementCounter("Hit");
            gameFrame.board.getGrid()[row][col].SetMark("Hit", statusDisplay);
            if (positions[row][col].IsSunk()) {
                System.out.println("Ship sunk!");
                if (CheckAllShipsSunk()) {
                    DisplayWin();
                }
            }
        } else {
            // Miss
            System.out.println("Miss at (" + row + ", " + col + ")");
            statusDisplay.IncrementCounter("Miss");
            gameFrame.board.getGrid()[row][col].SetMark("Miss", statusDisplay);
            if (statusDisplay.StrikeCounter >= 3) {
                DisplayLoss();
            }
        }
    }

    /*
        * This method checks if all ships are sunk.
        * It iterates through the list of all ships
        * and checks if each ship is sunk.
        * If all ships are sunk, it returns true,
        * otherwise it returns false.
     */
    public boolean CheckAllShipsSunk() {
        for (Ship ship : allShips) {
            if (!ship.IsSunk()) {
                return false;
            }
        }
        return true;
    }

    /*
        * This method displays a message when the player wins the game.
        * It shows a dialog box with a message and two buttons:
        * "Play Again" and "Exit".
        * If the player chooses "Play Again", it resets the game.
        * If the player chooses "Exit", it exits the game.
     */
    public void DisplayWin()
    {
        // Code to display the win
        int response = JOptionPane.showOptionDialog(null,
                "You win! Play again?", "Game Over",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Play Again", "Exit"}, JOptionPane.YES_OPTION);
        if (response == 0) {
            // Reset the game
            ResetGame();
        } else {
            // Exit the game
            System.exit(0);
        }
        System.out.println("All ships sunk! You win!");
    }

    /*
        * This method displays a message when the player loses the game.
        * It shows a dialog box with a message and two buttons:
        * "Play Again" and "Exit".
        * If the player chooses "Play Again", it resets the game.
        * If the player chooses "Exit", it exits the game.
     */
    public void DisplayLoss()
    {
        // Code to display the loss
        int response = JOptionPane.showOptionDialog(null,
                "3 Strikes! You Lose...", "Game Over",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Play Again", "Exit"}, JOptionPane.YES_OPTION);
        if (response == 0) {
            // Reset the game
            ResetGame();
        } else {
            // Exit the game
            System.exit(0);
        }
        System.out.println("You lose!");
    }
    public void printShipPositions(Game game) {
        Ship[][] positions = game.positions;
        System.out.println("\n--- Ship Locations (after Reset) ---");
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j] != null) {
                    System.out.println("Ship: " + positions[i][j].GetName() + " at (" + i + ", " + j + ")");
                }
            }
        }
        System.out.println("--------------------------------------\n");
    }

}
