import java.util.ArrayList;

public class Mage extends Character {
    /* ATTRIBUTES */


    /* CONSTRUCTOR(S) */
    public Mage() {
        this.energyPoints = 50;
        this.healthPoints = 100;

        abilities = new ArrayList<Ability>();
        this.abilities.add(new Ability("Arcane Bolt"));
        this.abilities.get(0).setDescription("Launch a basic magical projectile that deals 20 arcane damage to the target.");
        this.abilities.get(0).setEPCost(5);
        this.abilities.get(0).setAttackDamage(20);

        this.abilities.add(new Ability("Arcane Blast"));
        this.abilities.get(1).setDescription("Unleash a burst of fiery energy, dealing 65 arcan damage to the target.");
        this.abilities.get(1).setEPCost(30);
        this.abilities.get(1).setAttackDamage(65);

        this.abilities.add(new Ability("Mana Channel"));
        this.abilities.get(2).setDescription("Draw upon ambient magical energy to restore your own. Restores 15.EP");
        this.abilities.get(2).setEPCost(0);
        this.abilities.get(2).setAttackDamage(0);

        this.abilities.add(new Ability("Lesser Heal"));
        this.abilities.get(3).setDescription("Weave a minor healing spell to mend your wounds. Restores 40HP.");
        this.abilities.get(3).setEPCost(15);
        this.abilities.get(3).setAttackDamage(0);

        this.abilities.add(new Ability("Arcane Shield"));
        this.abilities.get(4).setDescription("Conjure a protective barrier of mystical energy around yourself. You do not take damage for the round");
        this.abilities.get(4).setEPCost(20);
        this.abilities.get(4).setAttackDamage(0);
    }
    
    public Mage(String name) {
        this(); 
        this.name = name;
    }


    /* GETTERS & SETTERS */

    /* METHODS */
    public void arcaneBolt(Player player1, Player player2) {
        player2.getChosenCharacter().setHP(player2.getChosenCharacter().getHP() - 20);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 5);
    }

    public void arcaneBlast(Player player1, Player player2) {
        player2.getChosenCharacter().setHP(player2.getChosenCharacter().getHP() - 65);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 30);
    }

    public void manaChannel(Player player1) {
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getHP() + 15);
    }

    public void lesserHeal(Player player1) {
        player1.getChosenCharacter().setHP(player1.getChosenCharacter().getHP() + 40);
        player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() - 15);
    }

    // this approach +s player1's life based on player2's attack | ex: P2 attack -30 P1 heatlh +30
    public void arcaneShield(Player player1, Player player2, int move) {
        player1.getChosenCharacter().setHP(player1.getChosenCharacter().getHP() + player2.getChosenCharacter().abilities.get(move).getAttackDamage());
    }
}