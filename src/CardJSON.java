import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.*;
import java.util.ArrayList;

public class CardJSON{
    String[] cardData;
    String name;
    int hp;
    String type;
    String rarity;
    int retreatCost;
    String weaknesses;
    ArrayList<String> moves = new ArrayList<>();
    File thePokedex = new File("src\\pokemonInfo.txt");
    JSONParser parser = new JSONParser();
}

