import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton
{
    private int row;
    private int col;
    private String state;
    StatusDisplay statusDisplay;
    Game game;
    private char displayChar = ' ';

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

    public void SetGame(Game game)
    {
        this.game = game;
    }

    public String GetMark()
    {
        // Code to get the mark. The code after state makes it so that the state is not null and if it is, it returns an empty string.
        return state != null ? state : "";
    }

    public void SetMark(String mark, StatusDisplay statusDisplay) {
        this.state = mark;
        System.out.println("SetMark called with mark: '" + mark + "' at row: " + row + ", col: " + col);
        if (mark.equals("Miss")) {
            this.displayChar = 'M';
            setForeground(Color.YELLOW);
            System.out.println("displayChar set to: " + this.displayChar);
        } else if (mark.equals("Hit")) {
            this.displayChar = 'X';
            setForeground(Color.RED);
            System.out.println("displayChar set to: " + this.displayChar);
        } else {
            this.displayChar = '≋';
            setForeground(Color.CYAN);
            System.out.println("displayChar set to: " + this.displayChar);
        }
        setText(String.valueOf(this.displayChar));
        setFont(new Font("Serif", Font.BOLD, 16));
        revalidate();
        repaint();
    }

    public void reset() {
        this.state = "";
        this.displayChar = ' ';
        setForeground(Color.BLACK);
        setText(String.valueOf(this.displayChar));
    }
}
