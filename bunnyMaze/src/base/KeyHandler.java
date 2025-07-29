package base;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private boolean upPress,downPress,leftPress,rightPress,enterPress;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
			if (code==KeyEvent.VK_ENTER) enterPress=true;
			else	if (code==KeyEvent.VK_W) upPress=true;
			else  if (code==KeyEvent.VK_A) leftPress=true;
			else if (code==KeyEvent.VK_S) downPress=true;
			else  if (code==KeyEvent.VK_D) rightPress=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
			if (code==KeyEvent.VK_ENTER) enterPress=false;
			if (code==KeyEvent.VK_W) upPress=false;
	        if (code==KeyEvent.VK_A) leftPress=false;
	    	if (code==KeyEvent.VK_S) downPress=false;
	        if (code==KeyEvent.VK_D) rightPress=false;

	}

	public boolean isUpPress() {
		return upPress;
	}

	public boolean isDownPress() {
		return downPress;
	}
	public boolean isLeftPress() {
		return leftPress;
	}
	public boolean isRightPress() {
		return rightPress;
	}
	public boolean isEnterPress() {
		return enterPress;
	}
}
