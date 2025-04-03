import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatusDisplay extends JPanel
{
    private JLabel statusLabel;
    private int MissCounter;
    private int StrikeCounter;
    private int TotalMissCounter;
    private int TotalHitCounter;

    public StatusDisplay(int initialMisses, int initialStrikes, int initialTotalMisses, int initialTotalHits)
    {
        statusLabel = new JLabel("Current Game Stats:");
        MissCounter = initialMisses;
        StrikeCounter = initialStrikes;
        TotalMissCounter = initialTotalMisses;
        TotalHitCounter = initialTotalHits;

        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        updateStatus();
    }

    public void IncrementCounter(String result)
    {
        if (result.equals("Miss"))
        {
            MissCounter++;
            StrikeCounter++;
            TotalMissCounter++;
        }
        else if (result.equals("Hit"))
        {
            TotalHitCounter++;
        }

    }

    public void updateStatus()
    {
        statusLabel.setText("<html>Current Game Stats:<br>Misses: " + MissCounter
                + " | Strikes: " + StrikeCounter
                + " | Total Misses: " + TotalMissCounter
                + " | Total Hits: " + TotalHitCounter + "</html>");
    }
}
