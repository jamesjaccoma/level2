package approach_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktabb on 5/22/16.
 */
public class Location {

    String name;
    String description;
    List<String> actions;

    public void addAction(String action) {
        if (!actions.contains(action)) {
            actions.add(action);
        }
    }

    // CONSTRUCTORS:

    public Location(String name) {
        this.name = name;
        actions = new ArrayList<>();
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        actions = new ArrayList<>();
    }

    public Location(String name, String description, List<String> actions) {
        this.name = name;
        this.description = description;
        this.actions = actions;
    }

    // GETTERS AND SETTERS:

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

}
