package approach_2;

/**
 * Created by ktabb on 5/24/16.
 */
public class RunGame2 {
    public static void main(String[] args) {
        String[][] locations = new String[2][2];

        locations[0][0] = "Farm";
        locations[0][1] = "Town";
        locations[1][0] = "Cabin";
        locations[1][1] = "Bar";

        Game game = new Game(locations);

        game.map[0][0].setDescription("Dozens of men are tending the vast fields of corn."); // Farm
        game.map[0][1].setDescription("The town is bustling with drunk people stumbling out of bars left and right."); // Town
        game.map[1][0].setDescription("The cabin looks abandoned. It is old and full of cobwebs."); // Cabin
        game.map[1][1].setDescription("The bar is loud and rowdy. People are drunk and fighting."); // Bar

        game.Run();
    }
}
