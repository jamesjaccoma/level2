package approach_2;

import java.awt.Point;
import java.util.*;

/**
 * Created by ktabb on 5/22/16.
 */
public class Game {
    Location[][] map;

    Point currLocation;

    public Game(String[][] locNames) {
        map = new Location[locNames.length][locNames[0].length];
        currLocation = new Point(0, 0);

        // initialize each location
        for (int k = 0; k < locNames.length; k++) {
            for (int e = 0; e < locNames[k].length; e++) {
                map[k][e] = new Location(locNames[k][e]);
            }
        }
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        while (true) { // loop infinitely, asking for user input

            Location currentLocation = map[currLocation.x][currLocation.y];
            System.out.printf("\n");
            System.out.println(currentLocation.getName());
            System.out.println(currentLocation.getDescription());
            System.out.println("Places you can go from here: ");

            Map<String, Point> potentialLocations = new HashMap<>();
            List<String> potentialActions = new ArrayList<>();
            if (currLocation.y > 0) {
                System.out.println("NORTH: " + map[currLocation.x][currLocation.y - 1].getName());
                potentialLocations.put("n", new Point(currLocation.x, currLocation.y - 1));
                potentialLocations.put("north", new Point(currLocation.x, currLocation.y - 1));
            }
            if (currLocation.y < map[currLocation.x].length - 1) {
                System.out.println("SOUTH: " + map[currLocation.x][currLocation.y + 1].getName());
                potentialLocations.put("s", new Point(currLocation.x, currLocation.y + 1));
                potentialLocations.put("south", new Point(currLocation.x, currLocation.y + 1));
            }
            if (currLocation.x < map.length - 1) {
                System.out.println("EAST: " + map[currLocation.x + 1][currLocation.y].getName());
                potentialLocations.put("e", new Point(currLocation.x + 1, currLocation.y));
                potentialLocations.put("east", new Point(currLocation.x + 1, currLocation.y));
            }
            if (currLocation.x > 0) {
                System.out.println("WEST: " + map[currLocation.x - 1][currLocation.y].getName());
                potentialLocations.put("w", new Point(currLocation.x - 1, currLocation.y));
                potentialLocations.put("west", new Point(currLocation.x - 1, currLocation.y));
            }

            List<String> actions = currentLocation.getActions();
            if (actions.isEmpty()) {
                System.out.println("No actions can be taken at this location");
            } else {
                System.out.println("Actions you can take: ");
                actions.forEach(action -> System.out.println(action));
                potentialActions.addAll(actions);
            }

            System.out.printf("\n");
            String input = scanner.next();
            processInput(input, potentialLocations, potentialActions);

        }
    }

    private void processInput(String input, Map<String, Point> potentialLocations, List<String> potentialActions) {
        String lowercaseInput = input.toLowerCase();
        if (potentialLocations.containsKey(lowercaseInput)) {
            this.currLocation = potentialLocations.get(lowercaseInput);
        } else if (potentialActions.contains(lowercaseInput)) {
            System.out.println("You do the action " + lowercaseInput);
        }
    }

}
