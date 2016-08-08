package bishop.kevin.imperialassaultskirmishbuilder;

/**
 * Created by Kevin on 8/8/2016.
 */
public class Card {
    // Basic information
    private String name;
    private String title;
    private String affiliation;
    private boolean unique;
    private String training; // Could be a boolean since options are elite/regular
    private String size;
    private int groupSize;
    private int costMajor;
    private int costMinor;
    private String traits;

    // Stats
    private int health;
    private int speed;
    private String defense;
    private String attackType; // Could be boolean since options are ranged/melee
    private String attackDice;

    // Short abilities
    private String shortAbilities; // Current plan is to separate all abilities with semicolons

    // Long Abilities
    private String longAbilities; // Current plan is to separate the list with semicolons

    public Card(){
    }

    public Card(String name, String title, String affiliation, boolean unique, String training,
                String size, int groupSize, int costMajor, int costMinor, String traits, int health,
                int speed, String defense, String attackType, String attackDice,
                String shortAbilities, String longAbilities) {
        this.name = name;
        this.title = title;
        this.affiliation = affiliation;
        this.unique = unique;
        this.training = training;
        this.size = size;
        this.groupSize = groupSize;
        this.costMajor = costMajor;
        this.costMinor = costMinor;
        this.traits  = traits;

        this.health = health;
        this.speed = speed;
        this.defense = defense;
        this.attackType = attackType;
        this.attackDice = attackDice;

        this.shortAbilities = shortAbilities;

        this.longAbilities = longAbilities;
    }



}
