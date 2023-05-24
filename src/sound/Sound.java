package sound;

import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;
import javax.sound.sampled.Clip;

public class Sound implements ISound{
	
	private String pathToFile;
	private Clip clip;
	private AudioInputStream audioInputStream;
	
	public Sound(String pathToFile) {
		this.pathToFile = pathToFile;
		setFile();
	}
	
	private void setFile() {
		try {
			File file = new File(pathToFile);
			audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
		} catch (Exception e ) {
			System.out.println("Could not play sound, exception: " + e.toString() );
		}
	}
	
	public void start() {
		clip.start();
	}

	public void stop() throws IOException {
		audioInputStream.close();
		clip.close();
		clip.stop();
	}
	
}