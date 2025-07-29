package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DialogBox {

   private Font font;
   private int dialogBoxX,dialogBoxY,widthBox, heightBox;
   private float fontSize;
   private String text;
   public static final int tileSize=48;
   boolean thick=false;
   Color colorText= Color.white;
   Color colorBox=Color.white;
   public DialogBox(int dialogBoxX,int dialogBoxY, int widthBox,int heightBox, float fontSize, String text) {
		// TODO Auto-generated constructor stub

	       try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/retro.ttf"));
		   } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	       font=font.deriveFont(fontSize);
	       
	       this.dialogBoxX=dialogBoxX;
	       this.dialogBoxY=dialogBoxY;
	       this.widthBox= widthBox;
	       this.heightBox= heightBox;
	       this.fontSize= fontSize;
	       this.text=text;
	   }
   
   public DialogBox(int dialogBoxX,int dialogBoxY, int widthBox,int heightBox,Color colorBox,Color colorText, float fontSize, String text) {
	// TODO Auto-generated constructor stub

       try {
		font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/retro.ttf"));
	   } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (FontFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
       font=font.deriveFont(fontSize);
		this.colorBox =colorBox;
		this.colorText =colorText;
	       this.dialogBoxX=dialogBoxX;
	       this.dialogBoxY=dialogBoxY;
	       this.widthBox= widthBox;
	       this.heightBox= heightBox;
	       this.fontSize= fontSize;
	       this.text=text;
   }
   public void setText(String text) {
	this.text = text;
   }
   public void setThick(boolean thick) {
	this.thick = thick;
   }
   public void drawDialogBox(Graphics2D g2) {
	// TODO Auto-generated method stub

		g2.setColor(colorBox);
		if (thick) 
			g2.fillRect(dialogBoxX, dialogBoxY, widthBox, heightBox);
		else g2.drawRect(dialogBoxX, dialogBoxY, widthBox,heightBox);
		g2.setColor(colorText);
		g2.setFont(font);
		g2.drawString(text, dialogBoxX, dialogBoxY+tileSize/2+fontSize/2);
   }
}
