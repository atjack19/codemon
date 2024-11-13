import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Card {
    int pokedexLength;
    String name;
    int hp;
    String type;
    String rarity;
    int retreatCost;
    String weaknesses;
    ArrayList<String> moves = new ArrayList<>();
    File thePokedex = new File("src\\pokemonInfo.txt");


//    public Card(int pokedexNumber) throws FileNotFoundException {    old solution
//        Scanner myScanner = new Scanner(thePokedex);
//        int lineCounter = 1;
//        while (lineCounter < pokedexNumber) {
//            myScanner.nextLine();
//            lineCounter++;
//        }
//        String desiredLine = myScanner.nextLine();
//        String regex = ",";
//        String[] pokeInfo = desiredLine.split(regex);
//        name = pokeInfo[0];
//        hp = Integer.parseInt(pokeInfo[1]);
//        type = pokeInfo[2];
//        rarity = pokeInfo[3];
//        retreatCost = Integer.parseInt(pokeInfo[4]);
//        weaknesses = pokeInfo[5];
//        int counter = 6;
//        while (pokeInfo.length > counter) {
//            moves.add(pokeInfo[counter]);
//            counter++;
//        }
//    }

    // new solution, make cards based on rarity
    public Card(String rarity) throws FileNotFoundException {
        Scanner myScanner = new Scanner(thePokedex);
    // make an arraylist of the Pokédex
        ArrayList<String[]> pokedex = new ArrayList<>();
        int lineCounter = 0;
        while (lineCounter < getPokedexLength()) {
            String currentLine = myScanner.nextLine();
            String regex = ",";
            String[] pokeInfo = currentLine.split(regex);
            pokedex.add(pokeInfo);
            lineCounter++;
        }
        for (int i = 0; i < pokedex.size(); i++) {
            System.out.println(pokedex.get(i)[0]);
        }
        System.out.println(rarity);

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
