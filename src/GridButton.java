import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton
{
    private int row;
    private int col;
    private String state;
    StatusDisplay statusDisplay;
    Game game;
    char displayChar = ' ';

    /*
     * Constructor to initialize the button with row and column indices.
     * It sets the preferred size, font, and other properties of the button.
     */
    public GridButton(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.state = "";
        setPreferredSize(new Dimension(40, 40));
        setFont(new Font("Serif", Font.BOLD, 16));
        setContentAreaFilled(true);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /*
     * Constructor to initialize the button without row and column indices.
     * It sets the preferred size, font, and other properties of the button.
     * However, this constructor is not used in the current implementation.
     */
    public GridButton() {
        this.row = -1; // Or some default value
        this.col = -1; // Or some default value
        this.state = "";
        setPreferredSize(new Dimension(40, 40));
        setFont(new Font("Serif", Font.BOLD, 16));
        setContentAreaFilled(true);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /*
     * This method returns the row index of the button.
     * It is used to access the row index from other classes.
     * It is not used in the current implementation.
     */
    public void SetGame(Game game)
    {
        this.game = game;
    }

    /*
     * This method returns the column index of the button.
     * It is used to access the column index from other classes.
     * It is not used in the current implementation.
     */
    public String GetMark()
    {
        // Code to get the mark. The code after state makes it so that the state is not null and if it is, it returns an empty string.
        return state != null ? state : "";
    }

    /*
     * This method sets the mark for the button.
     * It also sets the foreground color and text based on the mark.
     * The method is used to update the button's appearance based on the game state.
     */
    public void SetMark(String mark, StatusDisplay statusDisplay) {
        this.state = mark;
        if (mark.equals("Miss")) {
            this.displayChar = 'M';
            setForeground(Color.YELLOW);
        } else if (mark.equals("Hit")) {
            this.displayChar = 'X';
            setForeground(Color.RED);
        } else {
            this.displayChar = '≋';
            setForeground(Color.CYAN);
        }
        setText(String.valueOf(this.displayChar));
        setFont(new Font("Serif", Font.BOLD, 16));
        revalidate();
        repaint();
    }
}
