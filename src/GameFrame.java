import javax.swing.*;
import java.awt.*;

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
        mainGame = new JPanel(new GridBagLayout());
        status = new StatusDisplay(3, 2, 5, 4);
        game = new Game();
        playButton = new ControlButton("Play");
        quitButton = new ControlButton("Quit");
        Title = "Battleship";
        setTitle(Title);
        setSize(800, 800);
        DisplayFrame();
        //StartGame(); This should be called when the GameFrame is initialized
    }

    public void DisplayFrame()
    {
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setPreferredSize(new Dimension(450, 450));
        boardPanel.setLayout(new GridLayout(10, 10));

        board = new Board(boardPanel);
        board.DisplayBoard();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .8;
        mainGame.add(boardPanel, c);

        add(mainGame, BorderLayout.CENTER);

        DisplayStatus();
        DisplayButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
        // Code to display the frame
    }

    public void DisplayButtons()
    {
        // Code to display the buttons. Can be placed below Grid using proper layout manager
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        playButton.setPreferredSize(new Dimension(100, 50));
        quitButton.setPreferredSize(new Dimension(100, 50));

        playButton.addActionListener(ControlButton.NewGame());
        quitButton.addActionListener(ControlButton.QuitGame());

        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(playButton, c);

        c.gridx = 1;
        buttonPanel.add(quitButton, c);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void DisplayStatus()
    {
        status.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 0.2;
        mainGame.add(status, c);
        mainGame.revalidate();
        mainGame.repaint();

    }
}
