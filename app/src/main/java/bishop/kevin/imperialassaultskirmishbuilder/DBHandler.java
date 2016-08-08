package bishop.kevin.imperialassaultskirmishbuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 7;
    // Database Name
    private static final String DATABASE_NAME = "imperialAssaultCards";
    // Unit Cards Table Name
    private static final String TABLE_UNIT_CARDS = "unitCards";
    // Unit Cards Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AFFILIATION = "affiliation";
    private static final String KEY_UNIQUE = "is_unique";
    private static final String KEY_TRAINING = "training";
    private static final String KEY_SIZE = "size";
    private static final String KEY_GROUP_SIZE = "group_size";
    private static final String KEY_COST_MAJOR = "cost_major";
    private static final String KEY_COST_MINOR = "cost_minor";
    private static final String KEY_TRAITS = "traits";
    private static final String KEY_HEALTH = "health";
    private static final String KEY_SPEED = "speed";
    private static final String KEY_DEFENSE = "defense";
    private static final String KEY_ATTACK_TYPE = "attack_type";
    private static final String KEY_ATTACK_DICE = "attack_dice";
    private static final String KEY_SHORT_ABILITIES = "short_abilities";
    private static final String KEY_LONG_ABILITIES = "long_abilities";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_UNIT_CARDS_TABLE = "CREATE TABLE " + TABLE_UNIT_CARDS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_TITLE + " TEXT, "
                + KEY_AFFILIATION + " TEXT, " + KEY_UNIQUE + " TEXT, " + KEY_TRAINING + " TEXT, "
                + KEY_SIZE + " TEXT, " + KEY_GROUP_SIZE + " INTEGER, " + KEY_COST_MAJOR + " INTEGER, "
                + KEY_COST_MINOR + " INTEGER, " + KEY_TRAITS + " TEXT, " + KEY_HEALTH + " INTEGER, "
                + KEY_SPEED + " INTEGER, " + KEY_DEFENSE + " TEXT, " + KEY_ATTACK_TYPE + " TEXT, "
                + KEY_ATTACK_DICE + " TEXT, " + KEY_SHORT_ABILITIES + " TEXT, "
                + KEY_LONG_ABILITIES + " TEXT)";
        db.execSQL(CREATE_UNIT_CARDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNIT_CARDS);

        // Creating tables again
        onCreate(db);
    }

    // Adding a new card
    public void addCard(Card card) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, card.getId());
        values.put(KEY_NAME, card.getName());
        values.put(KEY_TITLE, card.getTitle());
        values.put(KEY_AFFILIATION, card.getAffiliation());
        values.put(KEY_UNIQUE, card.getUnique());
        values.put(KEY_TRAINING, card.getTraining());
        values.put(KEY_SIZE, card.getSize());
        values.put(KEY_GROUP_SIZE, card.getGroupSize());
        values.put(KEY_COST_MAJOR, card.getCostMajor());
        values.put(KEY_COST_MINOR, card.getCostMinor());
        values.put(KEY_TRAITS, card.getTraits());

        values.put(KEY_HEALTH, card.getHealth());
        values.put(KEY_SPEED, card.getSpeed());
        values.put(KEY_DEFENSE, card.getDefense());
        values.put(KEY_ATTACK_TYPE, card.getAttackType());
        values.put(KEY_ATTACK_DICE, card.getAttackDice());

        values.put(KEY_SHORT_ABILITIES, card.getShortAbilities());
        values.put(KEY_LONG_ABILITIES, card.getLongAbilities());

        // Inserting Row
        db.insert(TABLE_UNIT_CARDS, null, values);
        db.close(); // Closing database connection
    }

    // Getting one card
    // TODO: Get this with name instead of index.
    public Card getCard(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_UNIT_CARDS, null, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Card card = new Card(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                cursor.getString(6), Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)),
                cursor.getString(10), Integer.parseInt(cursor.getString(11)),
                Integer.parseInt(cursor.getString(12)), cursor.getString(13), cursor.getString(14),
                cursor.getString(15), cursor.getString(16), cursor.getString(17));

        return card;
    }

    // Getting all cards
    public List<Card> getAllCards() {
        List<Card> cardList = new ArrayList<Card>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_UNIT_CARDS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // loop through all rows, adding to list
        if (cursor.moveToFirst()){
            do {
                Card card = new Card(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), Integer.parseInt(cursor.getString(7)),
                        Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)),
                        cursor.getString(10), Integer.parseInt(cursor.getString(11)),
                        Integer.parseInt(cursor.getString(12)), cursor.getString(13), cursor.getString(14),
                        cursor.getString(15), cursor.getString(16), cursor.getString(17));

                cardList.add(card);
            } while(cursor.moveToNext());
        }

        return cardList;
    }

    // Getting cards Count
    public int getCardsCount() {
        String countQuery = "SELECT * FROM " + TABLE_UNIT_CARDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int updateCard(Card card) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, card.getName());
        values.put(KEY_TITLE, card.getTitle());
        values.put(KEY_AFFILIATION, card.getAffiliation());
        values.put(KEY_UNIQUE, card.getUnique());
        values.put(KEY_TRAINING, card.getTraining());
        values.put(KEY_SIZE, card.getSize());
        values.put(KEY_GROUP_SIZE, card.getGroupSize());
        values.put(KEY_COST_MAJOR, card.getCostMajor());
        values.put(KEY_COST_MINOR, card.getCostMinor());
        values.put(KEY_TRAITS, card.getTraits());

        values.put(KEY_HEALTH, card.getHealth());
        values.put(KEY_SPEED, card.getSpeed());
        values.put(KEY_DEFENSE, card.getDefense());
        values.put(KEY_ATTACK_TYPE, card.getAttackType());
        values.put(KEY_ATTACK_DICE, card.getAttackDice());

        values.put(KEY_SHORT_ABILITIES, card.getShortAbilities());
        values.put(KEY_LONG_ABILITIES, card.getLongAbilities());

        // Updating row
        return db.update(TABLE_UNIT_CARDS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(card.getId())});
    }

    // Deleting a Card
    public void deleteCard(Card card) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_UNIT_CARDS, KEY_ID + " = ?", new String[] { String.valueOf(card.getId())});
        db.close();
    }

}
