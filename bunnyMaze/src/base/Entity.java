package base;

import java.awt.image.BufferedImage;
public class Entity {

	    protected int entityX;
		protected int entityY;
		protected static final int size=48;
		protected boolean movable=true;
	    protected boolean alive=false;
	    
	    protected BufferedImage image;
	    
	
		Entity() {

		    int x=1;
		    int y=1;
		    this.entityX= size*x;
		    this.entityY= size*y;
		    this.alive=true;
		}
		void recalculate() {
		    int x= 1;
		    int y= 1;
		    entityX= size*x;
		    entityY= size*y;
		}
		public void die() {
			 alive=false;
		}
		public boolean isAlive() {
			return alive;
		}
		public int getEntityX() {
			return entityX;
		}
		public int getEntityY() {
			return entityY;
		}
		public void goUp() {
			entityY-=size;
		}
		public void goDown() {
			entityY+=size;
		}
		public void goLeft() {
			entityX-=size;
		}
		public void goRight() {
			entityX+=size;
		}
		public BufferedImage getImage() {
			return image;
		}
		public void resetPosition() {

		    this.entityX= size*1;
		    this.entityY= size*1;
		}
		public void setMovable(boolean movable) {
			this.movable = movable;
		}
		public boolean isMovable() {
			return movable;
		}

}
