import java.util.*;
import java.util.Set;
import java.util.Iterator;
import javax.swing.*;


import java.io.*;//ADDED FOR SOUND TEST





public class Main {

	public ImageIcon rustyDome = new ImageIcon("gifslite/rustyDomeLite.gif");
	public ImageIcon hillSide = new ImageIcon("gifslite/hillSide2Lite.gif");
	public ImageIcon darkField = new ImageIcon("gifslite/darkFieldLite.gif");
	public ImageIcon darkTrail = new ImageIcon("gifslite/darkTrailLite.gif");
	public ImageIcon antsBuck1 = new ImageIcon("gifslite/antsBuck1Lite.gif");
	public ImageIcon spinWheel = new ImageIcon("gifslite/spinWheelLite.gif");
	
	public ImageIcon snowyTree = new ImageIcon("gifslite/snowyTreeLite.gif");
	public ImageIcon snowyHalfTree = new ImageIcon("gifslite/snowyHalfTreeLite.gif");
	public ImageIcon snowyTrail1 = new ImageIcon("gifslite/snowyTrail1Lite.gif");
	public ImageIcon snowyTrail2 = new ImageIcon("gifslite/snowyTrail2Lite.gif");

	public ImageIcon concreteArea = new ImageIcon("gifslite/concreteAreaLite.gif");
	public ImageIcon antsAgain = new ImageIcon("gifslite/antsAgainLite.gif");
	public ImageIcon backStairs = new ImageIcon("gifslite/backStairsLite.gif");
	public ImageIcon hillSled = new ImageIcon("gifslite/hillSideSledLite.gif");
	public ImageIcon hillStone = new ImageIcon("gifslite/hillSideStoneLite.gif");
	public ImageIcon hillStick = new ImageIcon("gifslite/hillSideStickLite.gif");
	
	public ImageIcon spikyPlantClose = new ImageIcon("gifslite/spikyPlantCloseLite.gif");
	public ImageIcon spikyPlant = new ImageIcon("gifslite/spikyPlantLite.gif");

	public static ImageIcon pylonActive = new ImageIcon("gifslite/pylonActiveLite.gif"); //had to make this static so I could call it from the processcommand function
	public ImageIcon pylonUnactive = new ImageIcon("gifslite/pylonInactiveLite.gif");
	
	public ImageIcon sunBeam1 = new ImageIcon("gifslite/sunBeam1Lite.gif");
	public ImageIcon sunBeam2 = new ImageIcon("gifslite/sunBeam2Lite.gif");
	public ImageIcon redTree = new ImageIcon("gifslite/redTreeLite.gif");
	public ImageIcon treeLine = new ImageIcon("gifslite/treeLineLite.gif");
	public ImageIcon bigTreeLean = new ImageIcon("gifslite/bigTreeLeanLite.gif");
	
	public ImageIcon forest1 = new ImageIcon("gifslite/forest1Lite.gif");
	public ImageIcon washerMeditate = new ImageIcon("gifslite/washerSittingLite.gif");
	public ImageIcon washerWalk1 = new ImageIcon("gifslite/washerWalk1Lite.gif");
	public ImageIcon washerWalk2 = new ImageIcon("gifslite/washerWalk2Lite.gif");
	public ImageIcon washerWashing = new ImageIcon("gifslite/washerWashingLite.gif");
	
	public ImageIcon vibrantField = new ImageIcon("gifslite/vibrantFieldLite.gif");
	public ImageIcon upTree = new ImageIcon("gifslite/upTreeLite.gif");
	public ImageIcon twoTreeScreen = new ImageIcon("gifslite/twoTreeScreenLite.gif");
	public ImageIcon leanScreen = new ImageIcon("gifslite/leanScreenLite.gif");
	public ImageIcon deadTreeScreen = new ImageIcon("gifslite/deadTreeScreenLite.gif");

	public ImageIcon pictoScreen = new ImageIcon("gifslite/pictoScreenLite2.png");
	public ImageIcon mapScreen1 = new ImageIcon("gifslite/mapScreen1Lite2.png");
	public ImageIcon mapScreen2 = new ImageIcon("gifslite/mapScreen2Lite2.png");
	public ImageIcon numeralScreen = new ImageIcon("gifslite/numeralScreenLite2.png");

	public static ImageIcon helpScreen = new ImageIcon("gifslite/help.png");

	public static File soundTest1 = new File("audio/soundTest1.wav");
	public static File soundTest2 = new File("audio/soundTest2.wav");
	public static File soundTest1quiet = new File("audio/soundTest1quiet.wav");
	public static File soundTest2quiet = new File("audio/soundTest2quiet.wav");

	public static Scene[][] coords = new Scene[15][15];
	
	public static int x = 3;
	public static int y = 6;
	private static Scene currentScene;

	static String north = new String("north");
	static String east = new String("east");
	static String south = new String("south");
	static String west = new String("west");
	static String nChar = new String("n");
	static String eChar = new String("e");
	static String sChar = new String("s");
	static String wChar = new String("w");

	static String victoryCode = new String("347769206255");
	static String help = new String("?");
	static String back = new String("back");

	static Dir northOpen = new Dir();
	static Dir eastOpen = new Dir();
	static Dir southOpen = new Dir();
	static Dir westOpen = new Dir();

	public Main(){
		Gui gui = new Gui();
		Gui.parser.requestFocus();
		createScenes();
		changeScene(coords, x, y);
		displayScene();
	}



	private void createScenes() {

		//Scene rustyDomeSc, hillSideSc, darkFieldSc, darkTrailSc, snowyTreeSc, antsBuckSc, wavesLappingSc;
		
		//VANTAGES
	 	Scene topStairsAntsVa = new Scene(antsAgain, "0, 2", null, null, null, null);
		Scene antsBuckVa = new Scene(antsBuck1, "0", null, null, null, null);
		Scene hillSledVa = new Scene(hillSled, "0", null, null, null, null);
		Scene hillStoneVa = new Scene(hillStone, "0", null, null, null, null);
		Scene hillStickVa = new Scene(hillStick, "0", null, null, null, null);
		//Scene pyreCloseupVa = new Scene(pyreCloseup, "0", null, null, null, null);
		Scene spikyPlantCloseVa = new Scene(spikyPlantClose, "0", null, null, null, null);
		Scene pictoScreenVa = new Scene(pictoScreen, "0", null, null, null, null);
		Scene numeralScreenVa = new Scene(numeralScreen, "0", null, null, null, null);
		Scene mapScreen1Va = new Scene(mapScreen1, "0", null, null, null, null);
		Scene mapScreen2Va = new Scene(mapScreen2, "0", null, null, null, null);
		


	 	//PROPER SCENES
		Scene rustyDomeSc = new Scene(rustyDome, "East", null, eastOpen, null, null);

		Scene hillSideSc = new Scene(hillSide, "North, South, 3, 6, 11", northOpen, null, southOpen, null);
	 	
	 	Scene darkFieldSc = new Scene(darkField, "North, East, South", northOpen, eastOpen, southOpen, null);
	 	
	 	Scene darkTrailSc = new Scene(darkTrail, "North, South, West", northOpen, null, southOpen, westOpen);

	 	Scene leanScreenSc = new Scene(leanScreen, "North, East, 1", northOpen, eastOpen, null, null);

	 	Scene twoTreeScreenSc = new Scene(twoTreeScreen, "North, West, 4, 12", northOpen, null, null, westOpen);

	 	Scene deadTreeScreenSc = new Scene(deadTreeScreen, "North, East, West, 7", northOpen, eastOpen, null, westOpen);

	 	Scene redTreeSc = new Scene(redTree, "East, West", null, eastOpen, null, westOpen);

	 	Scene upTreeSc = new Scene(upTree, "East", null, eastOpen, null, null);

	 	


	 	Scene sunBeam1Sc = new Scene(sunBeam1, "East, South", null, eastOpen, southOpen, null);
	 	
	 	Scene sunBeam2Sc = new Scene(sunBeam2, "West", null, null, null, westOpen);

		Scene pylonSc = new Scene(pylonUnactive, "South", null, null, southOpen, null, soundTest2quiet);
		
		Scene spinWheelSc = new Scene(spinWheel, "South, West", null, null, southOpen, westOpen);

		Scene snowyTreeSc = new Scene(snowyTree, "West", null, null, null, westOpen);

		Scene snowyTrail1Sc = new Scene(snowyTrail1, "North, East, West", northOpen, eastOpen, null, westOpen);
		
		Scene snowyTrail2Sc = new Scene(snowyTrail2, "East, West", null, eastOpen, null, westOpen);
		
		Scene snowyHalfTreeSc = new Scene(snowyHalfTree, "South, West", null, null, southOpen, westOpen);
		
		



		Scene washerWalk1Sc = new Scene(washerWalk1, "East, South, West", null, eastOpen, southOpen, westOpen);

		Scene washerWalk2Sc = new Scene(washerWalk2, "East, South", null, eastOpen, southOpen, null);

		Scene washerWashingSc = new Scene(washerWashing, "North", northOpen, null, null, null);

		Scene washerMeditateSc = new Scene(washerMeditate, "South, West", null, null, southOpen, westOpen);

		Scene forest1Sc = new Scene(forest1, "North, East", northOpen, eastOpen, null, null);

		Scene treeLineSc = new Scene(treeLine, "East", null, eastOpen, null, null);

		Scene backStairsSc = new Scene(backStairs, "North, East, South", northOpen, eastOpen, southOpen, null);

		Scene spikyPlantSc = new Scene(spikyPlant, "North, 3", northOpen, null, null, null);

		//Scene topofStairsSc = new Scene(topofStairs, "North, South, 1", northOpen, null, southOpen, null);

		//Scene pyreSc = new Scene(pyre, "North", northOpen, null, null, null);

		Scene vibrantFieldSc = new Scene(vibrantField, "North, West", northOpen, null, null, westOpen);

		Scene bigTreeLeanSc = new Scene(bigTreeLean, "East, South, West", null, eastOpen, southOpen, westOpen);

		Scene concreteAreaSc = new Scene(concreteArea, "West, 1", null, null, null, westOpen);


		







	 	

	 	//ASSIGN VANTAGES
	 	hillSideSc.addVantage("3", hillStoneVa);
	 	hillSideSc.addVantage("6", hillSledVa);
	 	hillSideSc.addVantage("11", hillStickVa);

	 	concreteAreaSc.addVantage("1", topStairsAntsVa);
	 	topStairsAntsVa.addVantage("2", antsBuckVa);

	 	spikyPlantSc.addVantage("3", spikyPlantCloseVa);
	 	
	 	twoTreeScreenSc.addVantage("12", numeralScreenVa);
	 	twoTreeScreenSc.addVantage("4", mapScreen2Va);

	 	leanScreenSc.addVantage("1", mapScreen1Va);

	 	deadTreeScreenSc.addVantage("7", pictoScreenVa);


	 	


	 	//RETURN FROM VANTAGES
	 	hillStoneVa.addVantage("0", hillSideSc);
	 	hillSledVa.addVantage("0", hillSideSc);
	 	hillStickVa.addVantage("0", hillSideSc);

	 	spikyPlantCloseVa.addVantage("0", spikyPlantSc);

	 	topStairsAntsVa.addVantage("0", concreteAreaSc);
	 	antsBuckVa.addVantage("0", topStairsAntsVa);

	 	numeralScreenVa.addVantage("0", twoTreeScreenSc);
	 	mapScreen2Va.addVantage("0", twoTreeScreenSc);

	 	mapScreen1Va.addVantage("0", leanScreenSc);

	 	pictoScreenVa.addVantage("0", deadTreeScreenSc);
	 	
	 	//COORD MAP
	 
	 	coords[2][9] = spikyPlantSc;
	 	coords[2][8] = backStairsSc;
	 	coords[3][8] = concreteAreaSc;
	 	
	 	coords[2][7] = sunBeam1Sc;
		coords[3][7] = vibrantFieldSc;
	 	coords[4][7] = leanScreenSc;
	 	coords[5][7] = sunBeam2Sc;
	 	 	
	 	coords[4][1] = pylonSc;
	 	coords[5][1] = washerWalk2Sc;
	 	coords[6][1] = washerMeditateSc;
	 	
	 	coords[2][2] = treeLineSc;
		coords[3][2] = washerWalk1Sc;
		coords[4][2] = deadTreeScreenSc;
		coords[5][2] = twoTreeScreenSc;
		coords[6][2] = washerWashingSc;

		coords[3][3] = forest1Sc;
		coords[4][3] = snowyHalfTreeSc;

		coords[2][4] = rustyDomeSc;
		coords[3][4] = bigTreeLeanSc;
	 	coords[4][4] = snowyTrail1Sc;
	 	coords[5][4] = snowyTrail2Sc;
		coords[6][4] = snowyTreeSc;
		
		coords[3][5] = darkFieldSc;
		coords[4][5] = spinWheelSc;
		
		coords[1][6] = upTreeSc;
	 	coords[2][6] = redTreeSc; 	
		coords[3][6] = darkTrailSc;
		coords[4][6] = hillSideSc;

	 }
////////FOR SOUND TEST//////////

	public static File currentAudio; 

	public static void playSceneSound() {

		if (currentScene.soundFile != null) {
			
			currentAudio = currentScene.getSoundFile();
			SoundHandler2.playLoop(currentScene.soundFile);
		
		} else {
			if (currentAudio != null){ //Without this, you get a null pointer exception, because playStop() is trying to reference something that doesn't exist. 
										//It's trying to stop something that hasn't been started. When a file is played it's stored in the currentAudio variable.

			SoundHandler2.playStop();
				}
			}
		
		
	}

	/*TEMP STORAGE FOR CODE, This was a previous attempt.
	public static void playSceneSound() {

		if (currentScene.soundFile != null) {
			
			currentAudio = currentScene.getSoundFile();
			SoundHandler2.playLoop(currentScene.soundFile);
		
		} else if (currentScene.soundFile == null) {
			if (currentAudio != null) {

			SoundHandler2.playStop(currentAudio);
			}
		}
		
	}

	*/
/////////////////////////////////
	
	public static void displayScene() {

		currentScene.getDirectionString();
		currentScene.getVideo();
        Gui.output.setText(currentScene.directionString);
        Gui.videoField.setIcon(currentScene.sceneVideo);

        playSceneSound(); /////////////FOR SOUND TEST

      
    }

    public static void changeScene(Scene[][] coords, int x, int y) {
    	currentScene = coords[x][y];
    	
    }

    public static void changeVantage(Scene vantage) {
    	currentScene = vantage;
	}

	public static void processEscKey() {
	        Icon i = Gui.videoField.getIcon(); //This works, but before I had [ImageIcon i] and it said imageIcon cant be converted to Icon. What the hell is Icon? Well whatever.
	        System.out.println("F1 pressed");

	         
	         if (i.equals(helpScreen)) {

            displayScene();
         }
	}

	public static void processInput(JTextField parser){
		String input = parser.getText().toLowerCase();
		
		if (input.equals(north) || input.equals(nChar)) {
			
			if (currentScene.northOpen != null) {
				y--;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText("");
	 	} 
	 	if (input.equals(east) || input.equals(eChar)) {
			
			if (currentScene.eastOpen != null) {
				x++;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText("");
	 	} 
	 	if (input.equals(south) || input.equals(sChar)) {
	 		
	 		if (currentScene.southOpen != null) {
				y++;
				changeScene(coords, x, y);
				displayScene();
			} 
			
			parser.setText("");
	 	} 
	 	if (input.equals(west) || input.equals(wChar)) {
	 		
	 		if (currentScene.westOpen != null) {
				x--;
				changeScene(coords, x, y);
				displayScene();
			}

			parser.setText("");
	 	} 
	 	if (input.equals(victoryCode) && currentScene == coords[4][1]) { 
	 	//I can't reference the scene object pylonSc itself, I have to instead reference it's index on the map. I guess because it was created in a private method?
	 		coords[4][1].setVideo(pylonActive);
	 		coords[4][1].setSoundFile(soundTest1quiet);
	 		
	 		SoundHandler2.playStop();
	 		displayScene();
			/*for whatever reason when the victoryCode is entered, the soundFile for pylonSc changes, but on every other scene that soundTest2 plays. why? 
			with the addition of SoundHandler2.playStop(); this problem is fixed, but I'm too tired to figure out why.
	 		
	 		*/
	 	}

	 	if (input.equals(help))	{
	 		Gui.videoField.setIcon(helpScreen);
	 		parser.setText("");
	 	}

	 	if (input.equals(back)) {
	 		Icon i = Gui.videoField.getIcon();
	 		System.out.println("back typed");
	 		parser.setText("");

		 		if (i.equals(helpScreen)) {

	            displayScene();
	         }
	 	}
	 	
/*VICTORY CONDITION
	 	if (input.equals(victoryCode)) {
	 		if (currentScene.equals(pylonUnactiveSc)){
	 			currentScene = pylonActiveSc;
	 			displayScene();
	 		}
	 	}
*/
	 	else {
	 		processInputCode(parser);
	 	}
}

public static void processInputCode(JTextField parser) {
	 		String input = parser.getText();
	 		Map<String, Scene> map = currentScene.vantages;
	 		Iterator<Map.Entry<String, Scene>> entries = map.entrySet().iterator();
				
				while (entries.hasNext()) {
				    Map.Entry<String, Scene> entry = entries.next();
				    if (input.equals(entry.getKey())) {
				    		System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				    	changeVantage(entry.getValue());
				    	displayScene();
				    	parser.setText("");
				    	return;
					}
					
				}

			}

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

	 	