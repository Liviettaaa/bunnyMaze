package base;

import java.awt.Color;
import java.awt.Graphics2D;

public class Level {
	
    private int punteggio=0;
    private DialogBox end;
    private DialogBox score;
    private Menu menu;
	private Map map;
    private Player p;
    private Squad squad;
    private AudioManager audio;
	private KeyHandler keyboard;
    public static final int tileSize=48;
    private int levelState=0;//default not running
	boolean enterHandled = false;
	long oldTime;
	
    public Level(KeyHandler k) {
		// TODO Auto-generated constructor stub
    	 menu= new Menu();
		 p= new Player();
         map=new Map();
         squad=new Squad();
         squad.initializeMobs(map);
         audio = new AudioManager();
 	     score= new DialogBox(tileSize*10,tileSize*1,tileSize*5,tileSize*1,24f,"Punteggio:"+punteggio);
 	     end= new DialogBox((tileSize*10)/2,(tileSize*10)/2,tileSize*7,tileSize*2,Color.green,Color.green,50f,"Hai vinto!");
 	     keyboard=k;
 		 audio.playMusic();
	    
	}
    
    public void drawLevel(Graphics2D g2) {
		// TODO Auto-generated method stub
		
		map.drawMap(g2);
		score.setText("Punteggio: "+punteggio );
		score.drawDialogBox(g2);
	    squad.drawMobs(g2);
		p.drawPlayer(g2);
	    if (punteggio==10) end(g2);
		if (menu.isDrawable()) menu.drawMenu(g2);
	

	}
	public void handleInput()  {
		

		if (keyboard.isEnterPress()) {
		    if (!enterHandled) {
		        if (!menu.isDrawable()) {
		            menu.setDrawable(true);
		            p.setMovable(false);
		        } 
		        else if (menu.getChoice()==1) {
		            menu.setDrawable(false);
		            p.setMovable(true);
		        }
		        else if(menu.getChoice()==2) {
		            menu.setDrawable(false);
		            restart();
		        }
		        else if(menu.getChoice()==3) {
		        	destroy();
		        }
		        enterHandled = true;
		    }
		} else {
		    enterHandled = false;
		}

		
		if(keyboard.isUpPress()) {
			
			menu.moveArrow(0);
			
			if(map.isEmptyTile(p.getEntityY()-tileSize,p.getEntityX())&& p.isMovable())
				p.goUp();
			else if (p.isMovable())audio.playWall();
			
		}
		if(keyboard.isDownPress()) {
			menu.moveArrow(1);
			if(map.isEmptyTile(p.getEntityY()+tileSize,p.getEntityX())&& p.isMovable())
				p.goDown();
			else if (p.isMovable())audio.playWall();
			
		}
		if(keyboard.isRightPress()) 
			if(map.isEmptyTile(p.getEntityY(),p.getEntityX()+tileSize)&& p.isMovable())
				p.goRight();
			else if (p.isMovable())audio.playWall();
		
		if(keyboard.isLeftPress()) 
			if(map.isEmptyTile(p.getEntityY(),p.getEntityX()-tileSize)&& p.isMovable())
				p.goLeft();
			else if (p.isMovable())audio.playWall();
		
		
		if (squad.isTouching(p.getEntityY(),p.getEntityX()))	punteggio+=1;
		    
		

	}
	public void run() {
		levelState=1;
		audio.resetWall();
		
	}
	public void pause() {
		levelState=2;
	}

	public void destroy() {
		levelState=4;
		
	}
	public void restart() {
		squad.initializeMobs(map);
        audio.playMusic();
		p.resetPosition();
		punteggio=0;
        p.setMovable(true);
	}
	public void restart(Graphics2D g2) {
		end.drawDialogBox(g2);
	    long newTime=System.currentTimeMillis();
		while (newTime-oldTime<100)newTime=System.currentTimeMillis();
		while (audio.winIsRunning());
		audio.stopWin();
		levelState=1;
		squad.initializeMobs(map);
        audio.playMusic();
		p.resetPosition();
		punteggio=0;
	}
	public int getLevelState() {
		return levelState;
	}
	public void end(Graphics2D g2) {
		audio.stopMusic();
		audio.playWin();
		oldTime=System.currentTimeMillis();
		restart(g2);
	}
}
