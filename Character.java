import java.util.*;

public class Character {
    /* ATTRIBUTES */
    protected String name;
    protected String type;                  // Character Type: Mage, Warrior, or Rogue
    protected String details;               // Character description
    protected int energyPoints;
    protected int healthPoints;
    protected ArrayList<Ability> abilities; // Character's abilities (3)

    /* CONSTRUCTOR(S) */
    public Character() {
        abilities = new ArrayList<Ability>();
        this.energyPoints = 50;
        this.healthPoints = 100;
    }
    
    public Character(String name) {
        this(); 
        this.name = name;
    }


    /* GETTERS & SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getEP() {
        return energyPoints;
    }

    public void setEP(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public int getHP() {
        return healthPoints;
    }

    public void setHP(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }


    /* METHODS */
    // prints the list of abilities of a Character child class
    public void printAbilityOptions() {
        for (int i=0; i<5; i++) {
            if (abilities.get(i).getName().length() > 11) 
                System.out.println(i + " | " + abilities.get(i).getName() + "\t | " + abilities.get(i).getDescription());
            else 
                System.out.println(i + " | " + abilities.get(i).getName() + "\t\t | " + abilities.get(i).getDescription());
            System.out.println("--+----------------------+-----------------------------------------------------------------------------------");
        }
    }

    // prints the ability pool that a player selected for a Character
    public void printAbilityPool() {
        for (int i=0; i<3; i++)
            System.out.println("[" + i + "] " + abilities.get(i).getName());
    }

    // displays the chosenCharacter's list of moves
    public void displayMoves() {
        System.out.println("--+----------------------+---------+--------");
        System.out.println("i | Abilities\t\t | EP Cost | Damage");
        System.out.println("--+----------------------+---------+--------");
        for (int i=0; i<3; i++) {
            if (abilities.get(i).getName().length() > 11) 
                System.out.println(i + " | " + abilities.get(i).getName() + "\t | " + abilities.get(i).getEPCost() + "\t   | " + abilities.get(i).getAttackDamage());
            else 
                System.out.println(i + " | " + abilities.get(i).getName() + "\t\t | " + abilities.get(i).getEPCost() + "\t   | " + abilities.get(i).getAttackDamage());
            System.out.println("--+----------------------+---------+--------");
        }
        System.out.println("4 | Defend\t\t | 5       | 0");
        System.out.println("--+----------------------+---------+--------");
        System.out.println("5 | Recharge\t\t | 0       | 0");
        System.out.println("--+----------------------+---------+--------");
    }

    public void defend () {
        // not sure yet
    }

    public void recharge () {
        // not sure yet
    }
}