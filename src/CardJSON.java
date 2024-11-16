import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
    String filePath = "src/pokedex.json";


    public CardJSON(String rarity) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray pokedex = (JSONArray) parser.parse(new FileReader(filePath)); //this is one slash bc I was working on macOS its two backslashes on win
        Random pokeIndex = new Random();                                        //It works like this on windows too, so i guess its fine like this
        
        int randPokemon = 0;
        boolean correctRarity = false;
        while (!correctRarity) {
            randPokemon = pokeIndex.nextInt(pokedex.toArray().length);
            JSONObject pokemon = (JSONObject) pokedex.toArray()[randPokemon];
            if (pokemon.get("Rarity").toString().equals(rarity)) {
                correctRarity = true;
            }
        }

            JSONObject pokemon = (JSONObject) pokedex.toArray()[randPokemon];

            name = (String) pokemon.get("Name");
            hp = (Long) pokemon.get("HP");
            type = (String) pokemon.get("Type");
            this.rarity = (String) pokemon.get("Rarity");
            retreatCost = (Long) pokemon.get("Retreat Cost");
            weakness = (String) pokemon.get("Weakness");
            moves = (ArrayList<String>) pokemon.get("Moves");

    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Type: " + type);
        System.out.println("Rarity: " + rarity);
        System.out.println("Retreat Cost: " + retreatCost);
        System.out.println("Weakness: " + weakness);
        System.out.println("Move List");
        for (String move : moves) {
            System.out.println(move);
        }
        System.out.println(" ");
    }
    public void simplePackDisplay() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Rarity: " + rarity);
        System.out.println(" ");
    }
}

