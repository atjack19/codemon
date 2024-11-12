import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    File myObj = new File("src\\pokemonInfo.txt");
    Scanner myScanner = new Scanner(myObj);

    public Card(int pokedexNumber) throws FileNotFoundException {

        int lineCounter = 1;
        while (lineCounter < pokedexNumber) {
            myScanner.nextLine();
            lineCounter++;
        }
        String desiredLine = myScanner.nextLine();
        String regex = ",";
        String[] pokeInfo = desiredLine.split(regex);
        name = pokeInfo[0];
        hp = Integer.parseInt(pokeInfo[1]);
        type = pokeInfo[2];
        rarity = pokeInfo[3];
        retreatCost = Integer.parseInt(pokeInfo[4]);
        weaknesses = pokeInfo[5];
        int counter = 6;
        while (pokeInfo.length > counter) {
            moves.add(pokeInfo[counter]);
            counter++;
        }
    }
    public int getPokedexLength() {
        int lineCounter = 0;
        while (myScanner.hasNextLine()) {
            lineCounter++;
            myScanner.nextLine();
        }
        return lineCounter;
    }
}
