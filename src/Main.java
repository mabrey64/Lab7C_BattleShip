public class Main
{
    public static void main(String[] args) {
        // Create the game frame
        new GameFrame();

        // Initialize the game
        Game game = new Game();
        game.StartGame();
        printShipPositions(game);
    }

    // This method prints the ship positions on the console. Used for debugging purposes.
    public static void printShipPositions(Game game) {
        Ship[][] positions = game.positions;
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (positions[i][j] != null) {
                    System.out.print(positions[i][j].GetSize() + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
