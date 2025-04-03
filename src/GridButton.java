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
        return state;
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
            this.setIcon(new ImageIcon("miss.png"));
            statusDisplay.IncrementCounter("Miss");
        }
        else if(state.equals("Hit"))
        {
            // Code to set the mark to a Hit
            this.setText("O");
            // Another way to set the mark to a Hit
            this.setIcon(new ImageIcon("Hit.png"));
            statusDisplay.IncrementCounter("Hit");
        }
        System.out.println("statusDisplay: " + statusDisplay);
    }

    public void Click()
    {
        // Code to handle the click
        
    }
}
