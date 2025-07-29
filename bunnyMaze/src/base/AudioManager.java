
package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioManager {
	
	private AudioInputStream wallIn;
    private AudioInputStream musicIn;
    private AudioInputStream winIn;
    private Clip wallSound;
    private Clip music;
    private Clip win;
	
	public AudioManager()  {
		// TODO Auto-generated constructor stub


	    try {
			wallIn= AudioSystem.getAudioInputStream( new File("music/wall.wav"));
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			musicIn= AudioSystem.getAudioInputStream( new File("music/music.wav"));
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			winIn= AudioSystem.getAudioInputStream( new File("music/win.wav"));
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			wallSound=AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			music=AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			win=AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			wallSound.open(wallIn);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			music.open(musicIn);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			win.open(winIn);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void playWall() {

			wallSound.start();
	}
		
	
	void playMusic(){

			music.start();
			music.loop(-1);
		}


		
	void playWin() {

			win.start();
	
		}
	void stopWall() {

	    wallSound.stop();
	}
	void stopMusic() {

		music.stop();
		music.setFramePosition(0);
		}
	void stopWin(){

		win.stop();
		win.setFramePosition(0);
		}
	void resetWall() {
		if (wallSound.getFrameLength()==wallSound.getFramePosition())
		{
		wallSound.stop();
		wallSound.setFramePosition(0);
		}
	}
	boolean winIsRunning()
		{
		
		if (win.getFrameLength()==win.getFramePosition()) return false;
		else return true;
		
		}
		

	}
	

