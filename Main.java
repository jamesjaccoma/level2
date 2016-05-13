

import javax.swing.*;

/*
NEXT TASK: set up the 2d array and modify the heading function to change the display!
*/

public class Main {

	public ImageIcon rustyDome = new ImageIcon("gifs/rustyDome.gif");
	public ImageIcon hillSide = new ImageIcon("gifs/hillSide.gif");
	public ImageIcon darkField = new ImageIcon("gifs/darkField.gif");
	public ImageIcon darkTrail = new ImageIcon("gifs/darkTrail.gif");
	public ImageIcon snowyTree = new ImageIcon("gifs/snowyTree.gif");
	public static Scene[][] coords = new Scene[10][10];
	
	public static int x = 1;
	public static int y = 2;
	private static Scene currentScene;
	



	static String north = new String(">north");
	static String east = new String(">east");
	static String south = new String(">south");
	static String west = new String(">west");
	static String nChar = new String(">n");
	static String eChar = new String(">e");
	static String sChar = new String(">s");
	static String wChar = new String(">w");
	static Dir northOpen = new Dir();
	static Dir eastOpen = new Dir();
	static Dir southOpen = new Dir();
	static Dir westOpen = new Dir();


	public Main(){
		Gui gui = new Gui();
		createScenes();
		changeScene(coords, x, y);
		displayScene();
		//I STILL DONT UNDERSTAND. before  when I had display scene take a scene as a parameter  why would it not work???

	}

	private void createScenes() {

		Scene rustyDomeSc, hillSideSc, darkFieldSc, darkTrailSc, snowyTreeSc;

		rustyDomeSc = new Scene(rustyDome, "S", null, null, southOpen, null);
	 	//rustyDomeSc.setExits(null, null, southOpen, null);

		hillSideSc = new Scene(hillSide, "N, E, S", northOpen, eastOpen, southOpen, null);
	 	//hillSideSc.setExits(northOpen, eastOpen, southOpen, null);
	 	
	 	darkFieldSc = new Scene(darkField, "N, E", northOpen, eastOpen, null, null);
	 	//darkFieldSc.setExits(northOpen, eastOpen, null, null);
	 	
	 	darkTrailSc = new Scene(darkTrail, "W", null, null, null, westOpen);
	 	//darkTrailSc.setExits(null, null, null, westOpen);

	 	snowyTreeSc = new Scene(snowyTree, "W", null, null, null, westOpen);
	 	//snowyTreeSc.setExits(null, null, null, westOpen);

	 	/*currentScene = hillSideSc; I THOUGHT this might fix the memory leak but i dont know why it would necessarily. 
	 	I think possibly the issue is that the hillside gif is TOO LONG?
		File size is more than double that of all other gifs so that probably is the issue. increase max memory storage??

		*/
	 	coords[1][0] = rustyDomeSc;
	 	coords[1][1] = hillSideSc;
	 	coords[1][2] = darkFieldSc;
	 	coords[2][1] = darkTrailSc;
	 	coords[2][2] = snowyTreeSc;
	}

	public static void displayScene() {

		currentScene.getDirectionString();
		currentScene.getVideo();
        Gui.output.setText(currentScene.directionString);
        Gui.videoField.setIcon(currentScene.sceneVideo);

    }

    public static void changeScene(Scene[][] coords, int x, int y) {
    	currentScene = coords[x][y];
    	//currentScene.setExits(northOpen, , Dir, Dir);
    }


     public static void processInput(JTextField parser){
		String input = parser.getText();
		if (input.equals(north) || input.equals(nChar)) {
			
			if (currentScene.northOpen != null) {
				y--;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(east) || input.equals(eChar)) {
			
			if (currentScene.eastOpen != null) {
				x++;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(south) || input.equals(sChar)) {
	 		
	 		if (currentScene.southOpen != null) {
				y++;
				changeScene(coords, x, y);
				displayScene();
			} else {
				return;
			}
			
			parser.setText(">");
	 	} 
	 	if (input.equals(west) || input.equals(wChar)) {
	 		
	 		if (currentScene.westOpen != null) {
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