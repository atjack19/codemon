import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Card {
    String name;
    Long hp;
    String type;
    String rarity;
    Long retreatCost;
    String weakness;
    ArrayList<String> moves;
    String filePath = "src/pokedex.json";
    JSONParser parser = new JSONParser();
    JSONArray pokedex = (JSONArray) parser.parse(new FileReader(filePath));

    public Card(String rarity) throws IOException, ParseException {

        Random pokeIndex = new Random();
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
    public String getRarity() {
        return rarity;
    }

    public void saveCardAsJSON(String fileName) throws IOException, ParseException {
        boolean dupeFound = false;                                    // this whole "is file empty" thing is all kind of scuffed way of dealing with everything. Basically, if you try to parse an empty file, it shits itself. So, I make it so when it created a file for the first time, it doesn't have to parse the file. That being said, if someone were to manually add an empty file with that name, we'd be fucked.
        JSONArray preexistingCollection = null;
        JSONArray collection = new JSONArray();                       // TL;DR, it works, but barely
        File f = new File("src/"+fileName+".json");            // Its also in the same format as the general Pokédex, so it can be read the same way

        boolean emptyFile = f.createNewFile();
        // checks if file exists, and sets flag to true
        if (!emptyFile) {  // if the file exists
            preexistingCollection = (JSONArray) parser.parse(new FileReader("src/collection.json")); //open file for reading
            for (int i = 0; i < preexistingCollection.size(); i++) {  //itterating over array to find any dupes
                JSONObject pokemon = (JSONObject) preexistingCollection.toArray()[i];
                if (pokemon.get("Name").toString().equals(name)) {  //if dupe found
                    if (pokemon.get("Amount") == null) { //edge case
                        pokemon.put("Amount", 1);
                    }
                    dupeFound = true;
                    pokemon.put("Amount", Integer.parseInt(pokemon.get("Amount").toString())+1); //increment the amount value
                }
            }
            if (!dupeFound) {
                JSONObject card = new JSONObject();  //if no dupes, do this
                card.put("Name", name);
                card.put("HP", hp);
                card.put("Type", type);
                card.put("Rarity", rarity);
                card.put("Retreat Cost", retreatCost);
                card.put("Weakness", weakness);
                card.put("Moves", moves);
                card.put("Amount", 1);
                preexistingCollection.add(card);
            }
        }
        else { //if the file is new, do this


            JSONObject card = new JSONObject();
            card.put("Name", name);
            card.put("HP", hp);
            card.put("Type", type);
            card.put("Rarity", rarity);
            card.put("Retreat Cost", retreatCost);
            card.put("Weakness", weakness);
            card.put("Moves", moves);
            card.put("Amount", 1);
            collection.add(card);
        }


        try {
            FileWriter fileWriter = new FileWriter("src/"+fileName+".json");
            if (!emptyFile) {
                fileWriter.append(preexistingCollection + "\n");
            }
            else {
                fileWriter.append(collection + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

