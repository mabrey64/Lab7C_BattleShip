import javax.swing.*;
import java.awt.*;

public class GridButton extends JButton
{
    private int row;
    private int col;
    private String state;

    public GridButton()
    {
        setPreferredSize(new Dimension(13, 13));
        setMinimumSize(new Dimension(10, 10));
        setMaximumSize(new Dimension(20, 20));
    }

    public String GetMark()
    {
        // Code to get the mark. The code after state makes it so that the state is not null and if it is, it returns an empty string.
        return state != null ? state : "";
    }

    public void SetMark(String currentState, StatusDisplay statusDisplay)
    {
        // Code to set the mark
        this.state = currentState;
        if(state.equals("Miss"))
        {
            // Code to set the mark to a miss
            this.setText("X");
            // Another way to set the mark to a miss
            this.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/images/miss.png")), 13, 13));
            statusDisplay.IncrementCounter("Miss");
        }
        else if(state.equals("Hit"))
        {
            // Code to set the mark to a Hit
            this.setText("O");
            // Another way to set the mark to a Hit
            this.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/images/hit.png")), 13, 13));

            // Increment the hit counter
            statusDisplay.IncrementCounter("Hit");
        }
        System.out.println("statusDisplay: " + statusDisplay);
    }

    public void Click(Game game, int row, int col, StatusDisplay statusDisplay)
    {
        // Code to handle the click
        if(game.positions[row][col] != null)
        {
            // Hit
            game.HandleMove(row, col);
            System.out.println("Hit at (" + row + ", " + col + ")");
            if(game.positions[row][col].IsSunk())
            {
                System.out.println("Ship sunk!");
            }
        }
        else
        {
            // Miss
            System.out.println("Miss at (" + row + ", " + col + ")");
        }
        statusDisplay.updateStatus();
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
