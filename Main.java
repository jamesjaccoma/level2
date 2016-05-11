

import javax.swing.*;

/*
NEXT TASK: set up the 2d array and modify the heading function to change the display!
*/

public class Main {

	
	public ImageIcon hillSide = new ImageIcon("hillSide.gif");
	public ImageIcon darkField = new ImageIcon("darkField.gif");
	public ImageIcon darkTrail = new ImageIcon("darkTrail.gif");
	public ImageIcon snowyTree = new ImageIcon("snowyTree.gif");
	public static Scene[][] coords = new Scene[10][10];
	
	public static int x = 1;
	public static int y = 2;
	private static Scene currentScene;
	



	static String north = new String(">north");
	static String east = new String(">east");
	static String south = new String(">south");
	static String west = new String(">west");
	static String n = new String(">n");
	static String e = new String(">e");
	static String s = new String(">s");
	static String w = new String(">w");
	static Dir northOpen = new Dir();
	static Dir eastOpen = new Dir();
	static Dir southOpen = new Dir();
	static Dir westOpen = new Dir();


	public Main(){
		parserdemo gui = new parserdemo();
		createScenes();
		changeScene(coords, x, y);
		displayScene();
		//I STILL DONT UNDERSTAND. before  when I had display scene take a scene as a parameter  why would it not work???

	}

	private void createScenes() {

		Scene hillSideSc, darkFieldSc, darkTrailSc, snowyTreeSc;

		hillSideSc = new Scene(hillSide, "E, S");
	 	hillSideSc.setExits(null, eastOpen, southOpen, null);
	 	
	 	darkFieldSc = new Scene(darkField, "N, E");
	 	darkFieldSc.setExits(northOpen, eastOpen, null, null);
	 	
	 	darkTrailSc = new Scene(darkTrail, "W");
	 	darkTrailSc.setExits(null, null, null, westOpen);

	 	snowyTreeSc = new Scene(snowyTree, "W");
	 	snowyTreeSc.setExits(null, null, null, westOpen);

	 	//currentScene = hillSideSc; I THOUGHT this would 

	 	coords[1][1] = hillSideSc;
	 	coords[1][2] = darkFieldSc;
	 	coords[2][1] = darkTrailSc;
	 	coords[2][2] = snowyTreeSc;
	}

	public static void displayScene() {

		currentScene.getDirectionString();
		currentScene.getVideo();
        parserdemo.output.setText(currentScene.directionString);
        parserdemo.videoField.setIcon(currentScene.sceneVideo);

    }

    public static void changeScene(Scene[][] coords, int x, int y) {
    	currentScene = coords[x][y];
    }


     public static void processInput(JTextField parser){
		String input = parser.getText();
		if (input.equals(north) || input.equals(n)) {
			
			if (northOpen != null) {
				y--;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(east) || input.equals(e)) {
			
			if (eastOpen != null) {
				x++;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(south) || input.equals(s)) {
	 		
	 		if (southOpen != null) {
				y++;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(west) || input.equals(w)) {
	 		
	 		if (westOpen != null) {
				x--;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}

			parser.setText(">");
	 	} 


	 	else {
	 		parser.setText(">");
	 	}

	 	


}
/*
   public void goNorth() {
    	if (northOpen == true) {
    		changeScene(coords, x, y);
    		displayScene();
    	}
    }
*/



	 private static void createAndShowGUI() {
        
       new Main();

    }

       public static void main(String[] args) {

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}