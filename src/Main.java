import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("bibbidy babbidy booo");
        File myObj = new File("pokemonInfo.txt");
        Scanner myScanner = new Scanner(myObj);
        while (myScanner.hasNextLine()) {
            String data = myScanner.nextLine();
            System.out.println(data);
        }

        }
    }
