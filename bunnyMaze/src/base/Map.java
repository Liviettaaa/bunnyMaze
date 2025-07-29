package base;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class Map {
	

	private final int[][] tileMap;
	private final Tileset tileset;
    public final static int [] [] colors=//DEFAULT TILES MADE WITH COLORS
    	{
    	{250,0,0},
    	{130,80,40},
    	{20,40,70},
    	{20,140,20},
    	{50,45,120}
    };
    private static final int size=48;//tilesize
	/**
	 * 	
		tileMap= new int [][] { //in futuro FORSE NEL PRELOAD DELLA MATRICE..CREARE STRUTTURA SECONDARIA CHE MEMORIZZA RIGHE UGUALI
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,2,2,2,2,0,0,0,0,0,0,2,0,1},
					{1,0,0,0,0,0,2,0,0,0,0,0,0,2,0,1},
					{1,0,0,0,0,0,2,0,0,2,0,0,0,2,0,1},
					{1,0,0,0,0,0,2,0,0,2,0,0,0,2,0,1},
					{1,0,0,0,0,0,2,0,0,2,0,0,0,0,0,1},
					{1,2,0,0,0,0,2,0,0,2,0,0,0,0,0,1},
					{1,2,2,0,0,0,0,0,0,2,2,2,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
					}; 
	 */
	public Map() {
		// TODO Auto-generated constructor stub
		
		
				XmlLoader xml =new XmlLoader();
				tileMap=xml.tileMapLoader(0);
				tileset=xml.tilesetLoader();
	}
	public  void drawMap(Graphics2D block) {
		int i=0,j=0;


		
		for (int[] row: tileMap){
			for(int tile: row) {
					//int a=colors[tile-1][0],b=colors[tile-1][1],c=colors[tile-1][2];
					//Color color =new Color(a,b,c);
					//block.setColor(color);
					//block.fillRect(j*size, i*size, size,size);
				
					block.drawImage(tileset.getTileImage(tile), j*size, i*size, size, size, getFocusCycleRootAncestor());
					
				
				j+=1;
			}
			j=0;
			i+=1;
		}
	}
	private ImageObserver getFocusCycleRootAncestor() {
		// TODO Auto-generated method stub
		return null;
	}
	public  boolean isEmptyTile(int y,int x){//puo essere usato anche per mob

		if(tileset.isTileCollidable(tileMap[y/size][x/size]))
			return false;
		return true;
	}

}
