import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Card {
    String[] cardData;
    String name;
    int hp;
    String type;
    String rarity;
    int retreatCost;
    String weaknesses;
    ArrayList<String> moves = new ArrayList<>();
    File thePokedex = new File("src\\pokemonInfo.txt");


    // new solution, make cards based on rarity
    public Card(String rarity) throws FileNotFoundException {
        boolean cardFound = false;
        Random rand = new Random();
        // picking a random card
        // Pick a random slot until desired rarity is found
        while (!cardFound) {
            int rarityCheck = rand.nextInt(getPokedexLength());
            String checkCardRarity = Pokedex().get(rarityCheck)[3];
            if (checkCardRarity.equals(rarity)) {
                cardData = Pokedex().get(rarityCheck);
                cardFound = true;
            }
        }
        System.out.println(cardData[0]);
        System.out.println(rarity);

    }

    public ArrayList<String[]> Pokedex() throws FileNotFoundException {
        Scanner myScanner = new Scanner(thePokedex);
        ArrayList<String[]> pokedex = new ArrayList<>();
        int lineCounter = 0;
        while (lineCounter < getPokedexLength()) {
            String currentLine = myScanner.nextLine();
            String regex = ",";
            String[] pokeInfo = currentLine.split(regex);
            pokedex.add(pokeInfo);
            lineCounter++;
        }
        return pokedex;
    }

    public int getPokedexLength() throws FileNotFoundException {
        Scanner lineCounterr = new Scanner(thePokedex);
        int lineCounter = 0;
        while (lineCounterr.hasNextLine()) {
            lineCounter++;
            lineCounterr.nextLine();
        }
        return lineCounter;
    }
}
