import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Collection {
    /*
     used to manipulate and display the collection of various users
     need to add things like:
     - displaying collections
     - sorting collections
     - user input to have different collections
     - method to delete collections easily
     */
    String username;
    String name;
    Long hp;
    String type;
    String rarity;
    Long retreatCost;
    String weakness;
    ArrayList<String> moves;
    String filePath;
    JSONParser parser = new JSONParser();
    JSONArray pokedex;

    public Collection (String username) {
        this.username = username;

    }
}
