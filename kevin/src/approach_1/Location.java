package approach_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ktabb on 5/16/16.
 */
public class Location {

    // name of the location, to be displayed to user
    private String name;

    // description of the location, to be displayed to user
    // defaults to value indicating no description has been set (must call setDescription function)
    private String description = "No description available";

    // this is a set containing all of the neighbors to this location
    public Set<Location> neighbors;

    /**
     * Constructor 1 takes 1 parameter
     * @param name - name of this location, to be displayed to user
     */
    public Location(String name) {
        this.name = name;
        neighbors = new HashSet<>();
    }

    /**
     * Constructor 2 takes 2 parameters
     * @param name - name of this location, to be displayed to user
     * @param startingNeighbors set of all neighboring locations
     */
    public Location(String name, Set<Location> startingNeighbors) {
        this.name = name;
        neighbors = startingNeighbors;
    }

    // given a neighbor location, add it to this location's set of neighbors
    public void addNeighbor(Location neighbor) {
        neighbors.add(neighbor);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    // GETTERS AND SETTERS:
    // these functions are just used to get the value and set the value of properties on the class
    // this is standard practice - keep variables private generally and expose them through getters and setters
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Set<Location> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Location> neighbors) {
        this.neighbors = neighbors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
