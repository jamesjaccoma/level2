import java.io.*;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
This is a pared down version of the SoundHandler i wrote. 

sources:
example found on www.codejava.net, 
a tutorial page written by Chua Hock-Chuan (ehchua@ntu.edu.sg) in 2008,
the Clip javadocs on oracle.
*/

public class SoundHandler2 {

	public static File currentAudio;
	public static Clip clip;

	static void playLoop(File audio) {
	

		try {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(audio);
		clip = AudioSystem.getClip(); //BEFORE this was 'Clip clip = Audiosys..etc' by NOT creating a new clip object each time we store the last clip used in the clip variable declared above.
										//When it's written 'Clip clip..' I get a null pointer exception when I exit the scene with the audio, ie when clip.stop is called. 
										//I think this is because the Clip object clip that's created is disposed of after the method executes. 
		clip.open(audioIn);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
       catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }

	}

//MAYBE ADD SOMETHING FOR VOLUME SPECIFICATION?
/*
	static void playStop(File audio) {
		try {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(audio);
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.stop();
	}
       catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }

	}
*/


	static void playStop() {
		clip.stop();
	}















}
	//add a function for stopping playback

/*
///////////////////////////////////////////////////////////
	public static Clip clip;

	public static File soundFile = new File ("audio/soundTest2.wav");

	static void loadSound(File audio) {
		try {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(audio);
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		}
		catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
	}

	static void playSound() {
		clip.start();
	}


public static void main(String[] args) {
	loadSound(soundFile);
	playSound();
}

*/


