import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlButton extends JButton
{
    private String Label;

    // Constructor for ControlButton
    public ControlButton(String label)
    {
        super(label);
    }

    /*
     * This method sets the label for the button.
     * It also sets the action listener for the button.
     */
    static ActionListener NewGame(GameFrame gameFrame)
    {
        return e ->
        {
            String[] options = {"New Game", "Continue"};
            int choice  = JOptionPane.showOptionDialog(null, "Would you like to start a new game or continue the current game?", "New Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 0)
            {
                // Code to start a new game
                System.out.println("Starting a new game...");
                gameFrame.game.ResetGame();
                gameFrame.board.DisplayBoard();
            }
        };
    }

    /*
     * This method sets the action listener for the quit button.
     * It shows a confirmation dialog when the button is clicked.
     */
    static ActionListener QuitGame()
    {
        return e ->
        {
            JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit Game", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == 0)
            {
                System.exit(0);
            }
        };
    }
}