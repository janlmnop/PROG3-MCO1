import java.util.ArrayList;

public class Warrior extends Character {
    /* ATTRIBUTES */


    /* CONSTRUCTOR(S) */
    public Warrior() {
        this.energyPoints = 50;
        this.healthPoints = 100;

        abilities = new ArrayList<Ability>();
        this.abilities.add(new Ability("Cleave"));
        this.abilities.get(0).setDescription("A sweeping strike that deals 20 physical damage.");
        this.abilities.get(0).setEPCost(5);
        this.abilities.get(0).setAttackDamage(20);

        this.abilities.add(new Ability("Shield Bash"));
        this.abilities.get(1).setDescription("Slam your shield into your opponent, dealing 35 physical damage.");
        this.abilities.get(1).setEPCost(15);
        this.abilities.get(1).setAttackDamage(35);

        this.abilities.add(new Ability("Ironclad Defense"));
        this.abilities.get(2).setDescription("Brace yourself, effectively taking no damage for the current round.");
        this.abilities.get(2).setEPCost(15);
        this.abilities.get(2).setAttackDamage(0);

        this.abilities.add(new Ability("Bloodlust"));
        this.abilities.get(3).setDescription("Tap into your inner fury, restoring a small amount of health. Restores 30 HP.");
        this.abilities.get(3).setEPCost(12);
        this.abilities.get(3).setAttackDamage(0);

        this.abilities.add(new Ability("Rallying Cry"));
        this.abilities.get(4).setDescription("Let out a powerful shout, inspiring yourself and recovering 12 EP.");
        this.abilities.get(4).setEPCost(0);
        this.abilities.get(4).setAttackDamage(0);
    }
    
    public Warrior(String name) {
        this(); 
        this.name = name;
    }

    /* GETTERS & SETTERS */

    /* METHODS */
    public void cleave(Player player1, Player player2) {
        player2.getChosenCharacter().setHP(player2.getChosenCharacter().getHP() - 20);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 5);
    }

    public void shieldBash(Player player1, Player player2) {
        player2.getChosenCharacter().setHP(player2.getChosenCharacter().getHP() - 35);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 15);
    }

    public void ironcladDefense(Player player1, Player player2, int move) {
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 15);
        player1.getChosenCharacter().setHP(player1.getChosenCharacter().getHP() + player2.getChosenCharacter().abilities.get(move).getAttackDamage());
    }

    public void bloodlust(Player player1) {
        player1.getChosenCharacter().setHP(player1.getChosenCharacter().getHP() + 30);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 12);
    }

    public void rallyingCry(Player player1) {
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() + 12);
    }
}