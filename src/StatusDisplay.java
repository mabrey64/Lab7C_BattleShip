import javax.swing.*;
import java.awt.*;

public class StatusDisplay extends JPanel
{
    private JLabel statusLabel;
    private int MissCounter;
    int StrikeCounter;
    private int TotalMissCounter;
    private int TotalHitCounter;

    private final String displayId;
    private final String labelId;
    private static int displayCounter = 0;
    private static int labelCounter = 0;

    public StatusDisplay(int initialMisses, int initialStrikes, int initialTotalMisses, int initialTotalHits)
    {
        displayId = "StatusDisplay-" + displayCounter++;
        labelId = "StatusLabel-" + labelCounter++;
        statusLabel = new JLabel("Current Game Stats:");
        MissCounter = initialMisses;
        StrikeCounter = initialStrikes;
        TotalMissCounter = initialTotalMisses;
        TotalHitCounter = initialTotalHits;

        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        System.out.println("Created " + displayId + " with " + labelId);
    }

    @Override
    public String toString() {
        return "StatusDisplay{" +
                "displayId='" + displayId + '\'' +
                ", labelId='" + labelId + '\'' +
                ", MissCounter=" + MissCounter +
                ", StrikeCounter=" + StrikeCounter +
                ", TotalMissCounter=" + TotalMissCounter +
                ", TotalHitCounter=" + TotalHitCounter +
                '}';
    }

    public void IncrementCounter(String result)
    {

        if (result.equals("Miss"))
        {
            MissCounter++;
            TotalMissCounter++;
            System.out.println("MissCounter: " + MissCounter);
            System.out.println("TotalMissCounter: " + TotalMissCounter);
            if (MissCounter >= 5)
            {
                StrikeCounter++;
                MissCounter = 0;
                System.out.println("StrikeCounter: " + StrikeCounter);
            }
        }
        else if (result.equals("Hit"))
        {
            TotalHitCounter++;
            System.out.println("TotalHitCounter: " + TotalHitCounter);
        }
    UpdateStatus();
    revalidate();
    repaint();
}

    public void UpdateStatus()
    {
        System.out.println("Updating " + displayId + " with " + labelId);
        statusLabel.setText("<html>Current Game Stats:<br>Misses: " + MissCounter
                + " | Strikes: " + StrikeCounter
                + " | Total Misses: " + TotalMissCounter
                + " | Total Hits: " + TotalHitCounter + "</html>");
        statusLabel.setBackground(Color.RED);
        statusLabel.repaint();
        statusLabel.setBackground(null);
        statusLabel.repaint();
        this.revalidate();
        this.repaint();
    }
}