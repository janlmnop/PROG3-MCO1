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
}