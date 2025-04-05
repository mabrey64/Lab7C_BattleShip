import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton
{
    private int row;
    private int col;
    private String state;
    StatusDisplay statusDisplay;
    Game game;

    public GridButton()
    {
        this.row = row;
        this.col = col;
        setPreferredSize(new Dimension(30, 30));
        this.state = "";
        setForeground(Color.BLACK);
        setMargin(new Insets(0, 0, 0, 0));
        setBackground(Color.LIGHT_GRAY); // Add this line for a light gray background
        setOpaque(true); // Ensure the background is painted
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
        System.out.println("SetMark called with mark: " + mark);
        if (mark.equals("Miss")) {
            setText("X");
            System.out.println("setText(\"X\") called");
        } else if (mark.equals("Hit")) {
            setText("O");
            System.out.println("setText(\"O\") called");
        } else {
            setText("");
            System.out.println("setText(\"\") called");
        }
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
