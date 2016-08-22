package bishop.kevin.imperialassaultskirmishbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CardDisplay extends AppCompatActivity {

    private boolean visible = true;

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

        // Display an individual card's stats in text from the db
        TextView name = (TextView) findViewById(R.id.name_title_unique_faction);
        Card card = db.getCard(1);
        name.setText(card.getName() + " - " + card.getTitle() + " - " + card.getUnique() + " - " +
                card.getAffiliation());

        TextView traits = (TextView) findViewById(R.id.training_traits);
        traits.setText(card.getTraining() + " - " + card.getTraits());

        TextView costs = (TextView) findViewById(R.id.cost_cost_group);
        costs.setText(card.getCostMajor() + " / " + card.getCostMinor() + " ( Group Size " +
                card.getGroupSize() + " )");

        TextView stats = (TextView) findViewById(R.id.numerical_stats);
        stats.setText("Health: " + card.getHealth() + ", Speed: " + card.getSpeed() + ", Defense: "
                + card.getDefense() + ", Attack: " + card.getAttackType() + card.getAttackDice());

        TextView shortAbilities = (TextView) findViewById(R.id.short_abilites);
        shortAbilities.setText(card.getShortAbilities());

        TextView longAbilities = (TextView) findViewById(R.id.long_abilites);
        longAbilities.setText(card.getLongAbilities());
    }

    public void toggleText(View view) {
        ImageButton card = (ImageButton) findViewById(R.id.card_picture);
        visible = !visible;
        if(visible) card.setVisibility(View.VISIBLE);
        else card.setVisibility(View.INVISIBLE);
    }
}
