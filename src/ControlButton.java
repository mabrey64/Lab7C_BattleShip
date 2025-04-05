import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlButton extends JButton
{
    private String Label;

    public ControlButton(String label)
    {
        super(label);
    }

    static ActionListener NewGame()
    {
        return e ->
        {
            String[] options = {"New Game", "Continue"};
            JOptionPane.showOptionDialog(null, "Would you like to start a new game or continue the current game?", "New Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (JOptionPane.YES_OPTION == 0)
            {
                // Code to start a new game
                System.out.println("Error expected, action listener worked.");
            }
        };
    }

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