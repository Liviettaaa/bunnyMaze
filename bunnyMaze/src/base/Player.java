package base;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
	
	
	
	public Player() {
		// TODO Auto-generated constructor stub
		super();//i costruttori della classe padre che hanno parametri non si ereditano, solo quelli con zero parametri si ereditano
	    try {
			image = ImageIO.read( new FileInputStream("images/sprite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void drawPlayer(Graphics2D g2) {
		g2.drawImage(image, this.getEntityX(), this.getEntityY(), size, size, getFocusCycleRootAncestor());
			
		
	}
	
	private ImageObserver getFocusCycleRootAncestor() {
		// TODO Auto-generated method stub
		return null;
	}
}
