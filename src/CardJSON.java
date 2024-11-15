import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardJSON {
    String[] cardData;
    String name;
    int hp;
    String type;
    String rarity;
    int retreatCost;
    String weaknesses;
    ArrayList<String> moves = new ArrayList<>();
    String filePath = "src\\pokedex.json";


    public CardJSON() throws IOException, ParseException {
        try (FileReader reader = new FileReader(filePath)) {
            // read the json file


            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            Object firstName = jsonObject.get(1);
            System.out.println(firstName);
        }
    }
}

