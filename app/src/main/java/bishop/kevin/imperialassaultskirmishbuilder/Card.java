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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public void setCostMajor(int costMajor) {
        this.costMajor = costMajor;
    }

    public void setCostMinor(int costMinor) {
        this.costMinor = costMinor;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public void setAttackDice(String attackDice) {
        this.attackDice = attackDice;
    }

    public void setShortAbilities(String shortAbilities) {
        this.shortAbilities = shortAbilities;
    }

    public void setLongAbilities(String longAbilities) {
        this.longAbilities = longAbilities;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAffiliation() {
        return this.affiliation;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public String getTraining() {
        return this.training;
    }

    public String getSize() {
        return this.size;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public int getCostMajor() {
        return this.costMajor;
    }

    public int getCostMinor() {
        return this.costMinor;
    }

    public String getTraits() {
        return this.traits;
    }

    public int getHealth() {
        return this.health;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getDefense() {
        return this.defense;
    }

    public String getAttackType() {
        return this.attackType;
    }

    public String getAttackDice() {
        return this.attackDice;
    }

    public String getShortAbilities() {
        return this.shortAbilities;
    }

    public String getLongAbilities() {
        return this.longAbilities;
    }



}
