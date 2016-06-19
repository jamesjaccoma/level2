import javax.swing.*;
import java.util.HashMap;
import java.util.Set;

import java.io.*;//ADDED FOR SOUNDTEST

public class Scene {

	public ImageIcon sceneVideo;
	public String directionString;
	public HashMap<String, Scene> vantages;

	public File soundFile;//ADDED FOR SOUNDTEST

	 Dir northOpen = new Dir();
	 Dir eastOpen = new Dir();
	 Dir southOpen = new Dir();
	 Dir westOpen = new Dir();

	public Scene(ImageIcon sceneVideo, String directionString, Dir northOpen, Dir eastOpen, Dir southOpen, Dir westOpen)
		{
			
			this.sceneVideo = sceneVideo;
			this.directionString = directionString;
			this.northOpen = northOpen;
			this.eastOpen = eastOpen;
			this.southOpen = southOpen;
			this.westOpen = westOpen;
			vantages = new HashMap<String, Scene>();
			
		}

//ADDED FOR SOUNDTEST/////////////
	public Scene(ImageIcon sceneVideo, String directionString, Dir northOpen, Dir eastOpen, Dir southOpen, Dir westOpen, File soundFile)
			{
			
			this.sceneVideo = sceneVideo;
			this.directionString = directionString;
			this.northOpen = northOpen;
			this.eastOpen = eastOpen;
			this.southOpen = southOpen;
			this.westOpen = westOpen;
			this.soundFile = soundFile;
			vantages = new HashMap<String, Scene>();

			
		}
	
	public File getSoundFile() {
		return this.soundFile;
	}

	public void setSoundFile(File soundFile) {
		this.soundFile = soundFile;
	}


///////////////////////////////////////


	public void addVantage(String code, Scene vantage) {
		vantages.put(code, vantage);
	}

	public HashMap<String, Scene> getVantages() {
       return vantages;
    }
   	
   	public void setVantages(HashMap<String, Scene> vantages) {
       this.vantages = vantages;
    }

	public void setVideo(ImageIcon sceneVideo) {
        this.sceneVideo = sceneVideo;
    }

    public ImageIcon getVideo() {
    	return this.sceneVideo;
    }

    public void setDirectionString(String directionString) {
        this.directionString = directionString;
    }

    public String getDirectionString() {
    	return this.directionString;
    }

}

class Dir{
	public Dir() {
	}
}


