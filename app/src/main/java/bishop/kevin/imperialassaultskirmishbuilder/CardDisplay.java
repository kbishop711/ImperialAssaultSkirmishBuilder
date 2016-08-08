package bishop.kevin.imperialassaultskirmishbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class CardDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_display);

        // Database test
        DBHandler db = new DBHandler(this);

        // Inserting Cards/Rows
        Log.d("Insert: ", "Inserting ..");

        db.addCard(new Card(1, "Luke Skywalker", "Hero of the Rebellion", "{Rebel}", "YES", "Elite",
                "Small", 1, 10, -1, "Force User", 10, 5, "{White}", "{Ranged}",
                "{Blue}{Green}{Yellow}",
                "+1{Block}; {Surge}: +2{Damage}; {Surge}: Recover 2{Damage}; {Surge}: +2 Accuracy",
                "{Action} Saber Strike: Perform a {Melee} attack using 1 red and 1 yellow die. This attack gains Pierce 3."));

        // Reading all cards
        Log.d("Reading: ", "Reading all cards ..");
        List<Card> cards = db.getAllCards();

        for (Card card: cards) {
            String log = "Id: " + card.getId() + " ,Name: " + card.getName() + " ,Title: "
                    + card.getTitle();
            Log.d("Card::", log);
        }
    }
}
