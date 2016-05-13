

import javax.swing.*;

public class Scene {

	public ImageIcon sceneVideo;
	public String directionString;

	 Dir northOpen = new Dir();
	 Dir eastOpen = new Dir();
	 Dir southOpen = new Dir();
	 Dir westOpen = new Dir();
/*
	public static Scene[][] coords = new Scene[10][10];
	public static ImageIcon hillSide = new ImageIcon("hillSide.gif");
	public static ImageIcon darkField = new ImageIcon("darkField.gif");
	public static ImageIcon darkTrail = new ImageIcon("darkTrail.gif");



	public void createScenes(){
	//CREATE SCENES\
		Scene hillSideSc = new Scene(hillSide, "E, S");
	 	hillSideSc.setExits(false, true, true, false);
	 	
	 	Scene darkFieldSc = new Scene(darkField, "E, S, W");
	 	darkFieldSc.setExits(false, true, true, true);
	 	
	 	Scene darkTrailSc = new Scene(darkTrail, "W");
	 	darkTrailSc.setExits(false, false, false, true);
	 	
	 	//ASSIGN SCENES TO COORDS
	 	coords[1][1] = hillSideSc;
	 	coords[2][1] = darkFieldSc;
	 	coords[3][1] = darkTrailSc;

	 }

	 	public static void displayScene(Scene[][] scene, int x, int y) {

        parserdemo.output.setText(scene[x][y].directionString);
        parserdemo.videoField.setIcon(scene[x][y].sceneVideo);

    }
*/


	public Scene(ImageIcon sceneVideo, String directionString, Dir northOpen, Dir eastOpen, Dir southOpen, Dir westOpen)
		{
			
			this.sceneVideo = sceneVideo;
			this.directionString = directionString;
			this.northOpen = northOpen;
			this.eastOpen = eastOpen;
			this.southOpen = southOpen;
			this.westOpen = westOpen;
		
		}

	public void setExits(Dir northOpen, Dir eastOpen, Dir southOpen, Dir westOpen){
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




	 
	

/*
//this should be abstract i think.
class Heading {
	public Heading(){
	}
}

*/