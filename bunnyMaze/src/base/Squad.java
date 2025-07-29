package base;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Squad {
	private LinkedList<Mob> squadL=new LinkedList<Mob>();
	private final static int MOB_NUMBER=10;
	private BufferedImage image;
	public Squad() {
		try {
			image = ImageIO.read( new FileInputStream("images/carrot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean isTouching(int y,int x){
		for (Mob mob: squadL) {
				if(mob.isAlive()) {
					if((mob.getMobX()/GamePanel.tileSize==x/GamePanel.tileSize && mob.getMobY()/GamePanel.tileSize==y/GamePanel.tileSize)){
						mob.die();
						return true;
					}
				}
			}
		return false;
	
	}
	public boolean isTouchingEachOther() {
		if (squadL.size()<2) return false;
		    int lastX = squadL.getLast().getMobX();
		    int lastY = squadL.getLast().getMobY();

		    for (int i = 0; i < squadL.size() - 1; i++) {
		        int currX = squadL.get(i).getMobX();
		        int currY = squadL.get(i).getMobY();

		        // Distanza in pixel: considera 1 tile di margine
		        if (Math.abs(currX - lastX) < GamePanel.tileSize*2 &&
		            Math.abs(currY - lastY) < GamePanel.tileSize*2) {
		            return true;
		        }
		    }
		    return false;

		    
	}
	public void initializeMobs(Map map){
		squadL.clear();
		for(int i=0;i<MOB_NUMBER;i++) {
			squadL.add( new Mob (image));
				if(i>0) {
					while(!map.isEmptyTile(squadL.getLast().getMobY(),squadL.getLast().getMobX()) ||isTouchingEachOther())
							{
				squadL.removeLast();
				squadL.add(new Mob(image));
							}
				}
				else {
					while(!map.isEmptyTile(squadL.getLast().getMobY(),squadL.getLast().getMobX())){
							squadL.removeLast();
							squadL.add(new Mob(image));
					}
				}
		}
	
	}
	 void drawMobs(Graphics2D draw) {
		for (Mob mob: squadL) 
			if(mob.isAlive()) 
	             draw.drawImage(mob.getImage(), mob.getMobX(), mob.getMobY(), GamePanel.tileSize, GamePanel.tileSize, getFocusCycleRootAncestor());
			
		}
	private static ImageObserver getFocusCycleRootAncestor() {
		// TODO Auto-generated method stub
		return null;
	}
}
