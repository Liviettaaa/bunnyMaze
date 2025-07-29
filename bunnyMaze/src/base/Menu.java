package base;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {

	public final int tileSize=48;
	private DialogBox [] choices= new DialogBox [3];
	private BufferedImage arrow;
	
	private int []arrowPosY= {(tileSize*3)+10, (tileSize*5)+10, (tileSize*7)+10};
	private int currentPos=arrowPosY[0];
	private boolean coolDown=false;
	private int choice=0;

	private long currentTime;
    private long nextTime;
	private boolean drawable=false;
	public Menu() {
		// TODO Auto-generated constructor stub
		try {
			arrow=ImageIO.read( new FileInputStream("images/arrow.png"));
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		choices [0]= new DialogBox(tileSize*5,tileSize*3,tileSize*6,tileSize*2,Color.orange,Color.black,30f,"Continua");
		choices [0].setThick(true);
		choices [1]= new DialogBox(tileSize*5,tileSize*5,tileSize*6,tileSize*2,Color.orange,Color.black,30f, "Rigioca");
		choices [1].setThick(true);
		choices [2]= new DialogBox(tileSize*5,tileSize*7,tileSize*6,tileSize*2,Color.orange,Color.black,30f, "Esci");
		choices [2].setThick(true);

		currentTime=System.currentTimeMillis();
	}
	public void setDrawable(boolean drawable) {
		this.drawable = drawable;
	}
	public boolean isDrawable() {
		return drawable;
	}
	public int getChoice() {
		return choice;
	}
	public void moveArrow(int direction) {
		//1 for down 0 for up
		nextTime=System.currentTimeMillis();
		if (nextTime-currentTime>50) {
			if ((direction==1) && (currentPos== arrowPosY[2])) {
				if (coolDown==true) setCoolDown(false);
				else{
				currentPos=arrowPosY[0];
				choice=1;
				setCoolDown(true);
				}
	
				currentTime=System.currentTimeMillis();
			}
			else if (direction==0 && currentPos== arrowPosY[0]) {	
				if (coolDown==true) setCoolDown(false);
				else{
				currentPos=arrowPosY[2];
				choice=3;
				setCoolDown(true);
				}
	
				currentTime=System.currentTimeMillis();
			}
			else if (direction==1 && currentPos== arrowPosY[0]) {
					currentPos=arrowPosY[1];
					currentTime=System.currentTimeMillis();
					choice=2;
			}
			else if (direction==1 && currentPos== arrowPosY[1]) {
				
					currentPos=arrowPosY[2];
					currentTime=System.currentTimeMillis();
					choice=3;
			}
			else if (direction==0 && currentPos== arrowPosY[1]) {
				
			    	currentPos=arrowPosY[0];
					currentTime=System.currentTimeMillis();
					choice=1;
				}
			else if (direction==0 && currentPos== arrowPosY[2]) {
				
				    currentPos=arrowPosY[1];
					choice=2;
					currentTime=System.currentTimeMillis();
			}
		}

	}
	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}
	public void drawMenu(Graphics2D g2) {
		// TODO Auto-generated method stub
		if(isDrawable()){
		for (DialogBox choice: choices) 
			choice.drawDialogBox(g2);
		}
		g2.drawImage(arrow, tileSize*9,currentPos, tileSize, tileSize, getFocusCycleRootAncestor());
	}
	private ImageObserver getFocusCycleRootAncestor() {
		// TODO Auto-generated method stub
		return null;
	}
}
