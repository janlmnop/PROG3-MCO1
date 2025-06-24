import java.util.*;

public class Character {
    /* ATTRIBUTES */
    protected String name;
    protected String type;                  // Character type: Mage, Warrior, or Rogue
    protected String details;               // Character description
    protected int energyPoints;
    protected int healthPoints;
    protected ArrayList<Ability> abilities; // Character's abilitiess

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
        System.out.println("3 | Defend\t\t | 5       | 0");
        System.out.println("--+----------------------+---------+--------");
        System.out.println("4 | Recharge\t\t | 0       | 0");
        System.out.println("--+----------------------+---------+--------");
    }
    
    
    public void executeMove(Player player1, Player player2, int move) {
        if (player1.getChosenCharacter().getType() == "Mage")
            executeMageAbilites(player1, player2, move);
        else if (player1.getChosenCharacter().getType() == "Rogue")
            executeRogueAbilites(player1, player2, move);
        else if (player1.getChosenCharacter().getType() == "Warrior")
            executeWarriorAbilites(player1, player2, move);
    }

    public static void executeMageAbilites(Player player1, Player player2, int move) {
        Mage m = new Mage();

        switch (player1.getChosenCharacter().getAbilities().get(move).getName()) {
            case "Arcane Bolt" : m.arcaneBolt(player1, player2); break;
            case "Arcane Blast" : m.arcaneBlast(player1, player2); break;
            case "Mana Channel" : m.manaChannel(player1); break;
            case "Lesser Heal" : m.lesserHeal(player1); break;
            case "Arcane Shield" : m.arcaneShield(player1, player2, player2.getMove()); break;
            case "Defend" : m.defend(player1, player2); break;
            case "Recharge" : m.recharge(player1);
        }
    }

    public static void executeRogueAbilites(Player player1, Player player2, int move) {
        Rogue r = new Rogue();

        switch (player1.getChosenCharacter().getAbilities().get(move).getName()) {
            case "Shiv" : r.shiv(player1, player2); break;
            case "Backstab" : r.backstab(player1, player2); break;
            case "Focus" : r.focus(player1); break;
            case "Smoke Bomb" : r.smokeBomb(player1, player2, player2.getMove()); break;
            case "Sneak Attack" : r.sneakAttack(player1, player2, player2.getMove()); break;
            case "Defend" : r.defend(player1, player2); break;
            case "Recharge" : r.recharge(player1); break;
        }
    }

    public static void executeWarriorAbilites(Player player1, Player player2, int move) {
        Warrior w = new Warrior();

        switch (player1.getChosenCharacter().getAbilities().get(move).getName()) {
            case "Cleave" : w.cleave(player1, player2); break;
            case "Shield Bash" : w.shieldBash(player1, player2); break;
            case "Ironclad Defense" : w.ironcladDefense(player1, player2, player2.getMove()); break;
            case "Bloodlust" : w.bloodlust(player1); break;
            case "Rallying Cry" : w.rallyingCry(player1); break;
            case "Defend" : w.defend(player1, player2); break;
            case "Recharge" : w.recharge(player1); break;
        }
    }

    public void defend(Player player1, Player player2) {
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 15);
        player1.getChosenCharacter().setHP(player1.getChosenCharacter().getHP() - (player2.getChosenCharacter().abilities.get(player2.getMove()).getAttackDamage()/2));
    }

    public void recharge(Player player1) {
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() + 5);
    }
}