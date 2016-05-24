
import java.util.*;
import java.util.Set;
import java.util.Iterator;
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
	public ImageIcon antsBuck1 = new ImageIcon("gifs/antsBuck1.gif");
	public ImageIcon wavesLapping = new ImageIcon("gifs/waveslapping.gif");

	public static Scene[][] coords = new Scene[10][10];
	
	public static int x = 1;
	public static int y = 2;
	private static Scene currentScene;



	static String north = new String("north");
	static String east = new String("east");
	static String south = new String("south");
	static String west = new String("west");
	static String nChar = new String("n");
	static String eChar = new String("e");
	static String sChar = new String("s");
	static String wChar = new String("w");
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

		Scene rustyDomeSc, hillSideSc, darkFieldSc, darkTrailSc, snowyTreeSc, antsBuckSc, wavesLappingSc;
		//VANTAGES
	 	wavesLappingSc = new Scene(wavesLapping, "0", null, null, null, null);
		antsBuckSc = new Scene(antsBuck1, "0", null, null, null, null);

	 	///////////////////////////////////////////////////////

	 	//PROPER SCENES
		rustyDomeSc = new Scene(rustyDome, "S, 1, 5", null, null, southOpen, null);

		hillSideSc = new Scene(hillSide, "N, E, S", northOpen, eastOpen, southOpen, null);
	 	
	 	darkFieldSc = new Scene(darkField, "N, E", northOpen, eastOpen, null, null);
	 	
	 	darkTrailSc = new Scene(darkTrail, "W", null, null, null, westOpen);

	 	snowyTreeSc = new Scene(snowyTree, "W", null, null, null, westOpen);

	 	///////////////////////////////////////////////////////

	 	//ASSIGN VANTAGES
	 	
	 	rustyDomeSc.addVantage("5", antsBuckSc);
	 	rustyDomeSc.addVantage("1", wavesLappingSc);
	 	

	 	//RETURN FROM VANTAGES
	 	antsBuckSc.addVantage("0", rustyDomeSc);
	 	wavesLappingSc.addVantage("0", rustyDomeSc);

	 		
	 	coords[1][0] = rustyDomeSc;
	 	coords[1][1] = hillSideSc;//THIS GIF IS TOO LONG, CAUSES CRASH
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

    public static void changeVantage(Scene vantage) {
    	currentScene = vantage;
	}


     public static void processInput(JTextField parser){
		String input = parser.getText().substring(1);
		if (input.equals(north) || input.equals(nChar)) {
			
			if (currentScene.northOpen != null) {
				y--;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText(">");
	 	} 
	 	if (input.equals(east) || input.equals(eChar)) {
			
			if (currentScene.eastOpen != null) {
				x++;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText(">");
	 	} 
	 	if (input.equals(south) || input.equals(sChar)) {
	 		
	 		if (currentScene.southOpen != null) {
				y++;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText(">");
	 	} 
	 	if (input.equals(west) || input.equals(wChar)) {
	 		
	 		if (currentScene.westOpen != null) {
				x--;
				changeScene(coords, x, y);
				displayScene();
			}

			parser.setText(">");
	 	} 


	 	else {
	 		processInputCode(parser);
	 	}




}
/*
//WHAT I"M TRYING TO DO is iterate over the current hashmap values to see if the user input matches any of them.
//PROBLEM LIST. First problem was getting the Object recognized as a Scene Object. OBJECT CANNOT BE CONVERTED TO SCENE.
2nd problem: Typing >1 as input would system.out.println the info, but broke the parser, other commands stopped working. 
3rd problem: Now that's fixed when displayScene() was added, but I HAVE NO CLUE WHY.
4th problem: >1 works as it should, but >5 has no effect. It seems like it's only checking one of the entries on input, 
	and it's always the >1, unless i delete that one, then it's >5
SO I NEED to get the user input, then iterate over the entries to see if it matches one of the keys, then get the value associated with said key. 
		PROBLEM WAS FIXED WHEN I ADDED continue; before when it was return, i think it would check the first entry, and then the loop would end if it
		didn't match. now it's fixed. ALTERNATIVELY, I could just not have the else statement after IF. For simplicitys sake ill leave it like this.
*/
	 	public static void processInputCode(JTextField parser) {
	 		String input = parser.getText().substring(1);
	 		Map<String, Scene> map = currentScene.vantages;
	 		Iterator<Map.Entry<String, Scene>> entries = map.entrySet().iterator();
				
				while (entries.hasNext()) {
				    Map.Entry<String, Scene> entry = entries.next();
				    if (input.equals(entry.getKey())) {
				    		System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); //purely for testing purposes.
				    	changeVantage(entry.getValue());
				    	displayScene();
				    	return;
					}
					
				}

			}

/*BACKUP COPY HERE
		while (entries.hasNext()) {
				    Map.Entry<String, Scene> entry = entries.next();
				    if (input.equals(entry.getKey())) {
				    	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				    	changeVantage(entry.getValue());
				    	displayScene();
				    	return;
					}
					else{
						continue;
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