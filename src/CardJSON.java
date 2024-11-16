import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CardJSON {
    String[] cardData;
    String name;
    Long hp;
    String type;
    String rarity;
    Long retreatCost;
    String weakness;
    ArrayList<String> moves;
    String filePath = "src\\pokedex.json";


    public CardJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray pokedex = (JSONArray) parser.parse(new FileReader("src/pokedex.json")); //this is one slash bc I was working on macOS its two backslashes on win
        Random pokeIndex = new Random();
        int randPokemon = pokeIndex.nextInt(pokedex.toArray().length);
            JSONObject pokemon = (JSONObject) pokedex.toArray()[randPokemon];

            name = (String) pokemon.get("Name");
            System.out.println(name);

            hp = (Long) pokemon.get("HP");
            System.out.println(hp);

            type = (String) pokemon.get("Type");
            System.out.println(type);

            rarity = (String) pokemon.get("Rarity");
            System.out.println(rarity);

            retreatCost = (Long) pokemon.get("Retreat Cost");
            System.out.println(retreatCost);

            weakness = (String) pokemon.get("Weakness");
            System.out.println(weakness);

            moves = (ArrayList<String>) pokemon.get("Moves");

            for (Object c : moves)
            {
                System.out.println(c+"");
            }
    }
}

