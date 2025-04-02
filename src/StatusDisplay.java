import javax.swing.*;

public class StatusDisplay extends JPanel
{
    private JLabel statusLabel;
    private int MissCounter;
    private int StrikeCounter;
    private int TotalMissCounter;
    private int TotalHitCounter;

    public StatusDisplay()
    {
        statusLabel = new JLabel();
        MissCounter = 0;
        StrikeCounter = 0;
        TotalMissCounter = 0;
        TotalHitCounter = 0;
    }

    public void IncrementCounter(String result)
    {
        if (result.equals("Miss"))
        {
            MissCounter++;
            StrikeCounter++;
            TotalMissCounter++;
        }
        else if (result.equals("Strike"))
        {
            TotalHitCounter++;
        }
    }
}
