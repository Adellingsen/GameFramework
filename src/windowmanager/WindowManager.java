package windowmanager;

import java.awt.Color;
import java.util.*;
import javax.swing.*;
import player.*;

public class WindowManager extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel gamePanel;
	private ArrayList<Player> players = new ArrayList<Player>();

    public WindowManager(String gameName, int width, int height) {
    	frame = new JFrame(gameName);
    	gamePanel = new JPanel();
        frame.setSize(width, height);
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void showWindow() {
    	frame.setVisible(true);
    }

    public void update() {
    	for (Player player : players) {
    		player.setLocation(player.getXPos(), player.getYPos());
    	}
    }
    
    public void addPlayer(Player player) {
    	frame.addKeyListener(player);
    	gamePanel.add(player);
    	players.add(player);
    }
}