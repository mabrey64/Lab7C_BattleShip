import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public JPanel mainGame;
    public StatusDisplay status;
    public Game game;
    public ControlButton playButton;
    public ControlButton quitButton;
    public String Title;
    public Board board;
    public JLabel titleLabel;

    public GameFrame() {
        // Constructor to initialize the game frame
        mainGame = new JPanel(new GridBagLayout());
        status = new StatusDisplay(0, 0, 0, 0);
        playButton = new ControlButton("Play");
        quitButton = new ControlButton("Quit");
        Title = "Battleship";
        titleLabel = new JLabel("Single-Player Battleship: Defeat the AI");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setTitle(Title);
        setSize(800, 800);

        board = new Board();
        game = new Game(this, board);
        DisplayFrame();
    }

    /*
        * This method sets up the main game frame, including the title, board, and status display.
        * It also adds the buttons for playing and quitting the game.
     */
    public void DisplayFrame() {
        setLayout(new BorderLayout());

        board.SetGame(game);
        board.DisplayBoard();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .8;
        mainGame.add(board.getBoardPanel(), c);

        add(mainGame, BorderLayout.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        DisplayStatus();
        DisplayButtons();

        System.out.println("GameFrame.DisplayFrame - Board instance: " + board);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

    /*
        * This method sets up the buttons for playing and quitting the game.
        * It adds action listeners to the buttons to handle their respective actions.
     */
    public void DisplayButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        playButton.setPreferredSize(new Dimension(100, 50));
        quitButton.setPreferredSize(new Dimension(100, 50));

        playButton.addActionListener(ControlButton.NewGame(this));
        quitButton.addActionListener(ControlButton.QuitGame());

        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(playButton, c);

        c.gridx = 1;
        buttonPanel.add(quitButton, c);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /*
        * This method displays the status of the game, including the current game stats.
        * It adds the status display to the main game panel.
     */
    public void DisplayStatus() {
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

    /*
        * This method handles the move made by the player.
        * It updates the board and the status display based on the move.
     */
    public void IncrementCounter(String result) {
        status.IncrementCounter(result);
    }
}