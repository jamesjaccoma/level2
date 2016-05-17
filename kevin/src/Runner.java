import approach_1.Location;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ktabb on 5/16/16.
 */
public class Runner {
    public static void main(String[] args) {

        // instantiate locations
        Location woods = new Location("Woods");
        Location barn = new Location("Barn");
        Location cave = new Location("Cave");
        Location lake = new Location("Lake");

        // set neighbors
        // this mapping should be stored in a file for large and complex maps
        woods.addNeighbor(barn);
        woods.addNeighbor(lake);
        barn.addNeighbor(woods);
        barn.addNeighbor(lake);
        cave.addNeighbor(lake);
        lake.addNeighbor(cave);
        lake.addNeighbor(woods);
        lake.addNeighbor(barn);

        // set descriptions
        // these could be stored in files if they are long
        woods.setDescription("Dark, dreary, and cold. You can see a lake through a small clearing off to the east.");
        barn.setDescription("The door creaks and there are cobwebs everywhere. Looks like nobody has been here in a long time.");
        cave.setDescription("Stalagmites ominously poke out of the floor and ceiling of the cave.");
        lake.setDescription("The sun glistens off of the lake. There is a small group of ducks by the shore.");

        Location currentLocation = woods;
        Scanner scanner = new Scanner(System.in);
        while (true) { // loop infinitely, asking for user input

            System.out.printf("\n");
            System.out.println(currentLocation.getName());
            System.out.println(currentLocation.getDescription());
            System.out.println("Places you can go from here: ");

            // this is a lambda expression, and it's one way of looping through a collection
            currentLocation.getNeighbors().forEach(tempNeighbor -> System.out.printf("%s\n", tempNeighbor.getName()));

            String newLocation = scanner.next();
            // another way is with an iterator
            Iterator<Location> iterator = currentLocation.getNeighbors().iterator();
            while(iterator.hasNext()) {
                // here, we keep looping to check the user input against the neighbors of the current location
                Location neighbor = iterator.next();
                if (newLocation.toLowerCase().equals(neighbor.getName().toLowerCase())) {
                    currentLocation = neighbor;
                    break;
                }
            }
        }

    }
}
