import javax.swing.*;

public class GameFrame extends JFrame
{
    public JPanel mainGame;
    public StatusDisplay status;
    public Game game;
    public ControlButton playButton;
    public ControlButton quitButton;
    public String Title;
    public Board board;

    public GameFrame()
    {
        mainGame = new JPanel();
        status = new StatusDisplay();
        game = new Game();
        playButton = new ControlButton("Play");
        quitButton = new ControlButton("Quit");
        Title = "Battleship";
        board = new Board();
    }

    public void DisplayFrame()
    {
        // Code to display the frame
    }

    public void DisplayButtons()
    {
        // Code to display the buttons. Can be placed below Grid using proper layout manager
    }

    public void DisplayStatus()
    {
        // Code to display the status
    }
}
