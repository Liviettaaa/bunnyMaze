package base;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//screen settings
	
	final static int tileSize= 48;//48x48
	final int maxScreenRow=16,maxScreenCol=12;
	final int screenWidth=tileSize*maxScreenRow;
	final int screenHeight=tileSize*maxScreenCol;
    private long currentTime;
    private long nextTime;
    
    
    private Level level;
	Thread gameThread;
	KeyHandler keyboard = new KeyHandler();
    
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyboard);
		this.setFocusable(true);	
		level=new Level(keyboard);
		

	}
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		level.drawLevel(g2);
		g2.dispose();
		
	}

	@Override
	public void run() {
		currentTime=System.currentTimeMillis();
		while(gameThread != null) {
			
			//System.out.println("Game running");
		    nextTime=System.currentTimeMillis();
		    if(nextTime-currentTime>=50) { //circa 20 fps
		    	level.run();
			    currentTime=System.currentTimeMillis();
				//1.handle input
				level.handleInput();
				//2.update logic
				if (level.getLevelState()==4) System.exit(0);
		    }
		    else {
		    	level.pause();
		    }
			//3.draw updates
			repaint();
		}
		
	}
}
