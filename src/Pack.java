import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Pack {
    ArrayList<Card> pack = new ArrayList<>();
    String[] rarities = {"1D","2D","3D","4D","1S","2S","3S","Crown"};
    Random rand = new Random();
    //3 cards are guaranteed to be 1D, then 4th and 5th cards have the special cards rate
    //odds are listed from least to most
    double[] rarityOdds4thCard = {0.000,90.000,5.000,1.666,2.572,0.500,0.222,0.040};
    double[] rarityOdds5thCard = {0.000,60.000,20.000,6.664,10.288,2.000,0.888,0.160};

    public Pack() throws IOException, ParseException {
        System.out.println("Pack Opening time!!!");
        pack.add(new Card(rarities[0]));
        pack.add(new Card(rarities[0]));
        pack.add(new Card(rarities[0]));

        // generate 4th card

        double randomRarity = rand.nextDouble()*100;
        int rarityIndex = 0;
        double rarityScore = 0;
        while (randomRarity > rarityScore) {
            rarityIndex++;
            rarityScore += rarityOdds4thCard[rarityIndex];
        }
        pack.add(new Card(rarities[rarityIndex]));

        // generate 5th card

        randomRarity = rand.nextDouble()*100;
        rarityIndex = 0;
        rarityScore = 0;
        while (randomRarity > rarityScore) {
            rarityIndex++;
            rarityScore += rarityOdds5thCard[rarityIndex];
        }
        pack.add(new Card(rarities[rarityIndex]));
        for (Card cardJSON : pack) {
            cardJSON.saveCardAsJSON("collection");
        }
        addToCollection();
        display();
    }

    public void display() {
        for (Card card : pack) {
            switch (card.getRarity()) {
                case "1D" -> {
                    delay(1500);
                    card.simplePackDisplay();
                }
                case "2D" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    card.simplePackDisplay();
                }
                case "3D" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    card.simplePackDisplay();
                }
                case "4D" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    System.out.println("..!");
                    delay(2000);
                    card.simplePackDisplay();
                }
                case "1S" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    System.out.println("..!");
                    delay(2000);
                    System.out.println(".?!");
                    delay(2000);
                    card.simplePackDisplay();
                }
                case "2S" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    System.out.println("..!");
                    delay(2000);
                    System.out.println(".?!");
                    delay(2000);
                    System.out.println(".!!");
                    delay(3000);
                    card.simplePackDisplay();
                }
                case "3S" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    System.out.println("..!");
                    delay(2000);
                    System.out.println(".?!");
                    delay(2000);
                    System.out.println(".!!");
                    delay(3000);
                    System.out.println("?!!");
                    delay(3000);
                    card.simplePackDisplay();
                }
                case "Crown" -> {
                    delay(1000);
                    System.out.println("...");
                    delay(1000);
                    System.out.println("..?");
                    delay(2000);
                    System.out.println("..!");
                    delay(2000);
                    System.out.println(".?!");
                    delay(2000);
                    System.out.println(".!!");
                    delay(3000);
                    System.out.println("?!!");
                    delay(3000);
                    System.out.println("!!!");
                    delay(3000);
                    card.simplePackDisplay();
                }
            }
        }
    }

    public void addToCollection() throws IOException, ParseException {
        for (Card cardJSON : pack) {
            cardJSON.saveCardAsJSON("collection");
        }
    }
    public void delay(int ms) {
        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - ms);
    }




}
