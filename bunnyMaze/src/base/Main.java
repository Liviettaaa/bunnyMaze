package base;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window= new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Gioco Coniglio");
		window.setLocationRelativeTo(null);
		GamePanel gm= new GamePanel();
		window.add(gm);
		window.pack();
		window.setVisible(true);
		gm.startGameThread();
	}

}
