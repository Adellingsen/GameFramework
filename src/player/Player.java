package player;

import javax.swing.*;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends JPanel implements IGameObject, KeyListener {
    
	private String name;
	private int posX = 0, posY = 0;
	private Image image;
	private JLabel jLabel;
	
	public Player(String name, String pathToIcon) {
		this.name = name;
		this.image = getScaledImage(new ImageIcon(pathToIcon).getImage(), 50, 50); 
		this.jLabel = new JLabel();
		this.jLabel.setIcon(new ImageIcon(image));
		add(this.jLabel);
	}

	@Override
	public void move(String direction) {
		if (direction.equals("left")) {
			posX -= 20;
		} else if (direction.equals("right")) {
			posX += 20;
		} else if (direction.equals("up")) {
			posY -= 20;
		} else if (direction.equals("down")) {
			posY += 20;
		}
	}
	
	public String getName() {
		return name;
	}

	public int getXPos() {
		return posX;
	}

	public int getYPos() {
		return posY;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		int key = keyEvent.getKeyCode();
		switch (key) {
			case KeyEvent.VK_LEFT:
				move("left");
				break;
			case KeyEvent.VK_RIGHT:
				move("right");
				break;
			case KeyEvent.VK_UP:
				move("up");
				break;
			case KeyEvent.VK_DOWN:
				move("down");
			default:
		}
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite newComposite = 
                AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.5f);
        g2.setComposite(newComposite); 
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}