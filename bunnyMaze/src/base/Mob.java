package base;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.lang.Math;

import javax.imageio.ImageIO;

public class Mob extends Entity{
	private int mobX;
	private int mobY;
    Random rand= new Random();
    
    
	Mob(BufferedImage image) {

		super();//i costruttori della classe padre non si ereditano
	    
	    Random rand= new Random();
	    int x=rand.nextInt(15 ) + 1;
	    int y=rand.nextInt(11 ) + 1;
	    this.mobX= 48*x;
	    this.mobY= 48*y;
	    this.image=image;
	}
    
	public void die() {
		 alive=false;
	}
	public boolean isAlive() {
		return alive;
	}
	public int getMobX() {
		return mobX;
	}
	public int getMobY() {
		return mobY;
	}
	public BufferedImage getImage() {
		return image;
	}
}
