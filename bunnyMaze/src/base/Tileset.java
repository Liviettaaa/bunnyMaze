package base;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Tileset {
	private ArrayList<Integer> collidable=new ArrayList<Integer>();
	private String tilesetSource;
	private BufferedImage image;
	
	public Tileset(String collidable,String tilesetSource) {
		char[]colls=collidable.toCharArray();
		for (char c:colls)if( Character.isDigit(c))this.collidable.add(c-'0');
		this.tilesetSource=tilesetSource;
		try {
			image = ImageIO.read( new FileInputStream(tilesetSource));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public BufferedImage getTileImage(int tileNumber) {
		return image.getSubimage((tileNumber-1)*16,0, 16, 16);
	}
	public boolean isTileCollidable(int tileNumber) {
		
		if( collidable.contains(tileNumber) )return true;
		return false;

	}
}
