import java.util.ArrayList;

public class Rogue extends Character {
    /* ATTRIBUTES */


    /* CONSTRUCTOR(S) */
    public Rogue() {
        this.energyPoints = 50;
        this.healthPoints = 100;

        abilities = new ArrayList<Ability>();
        this.abilities.add(new Ability("Shiv"));
        this.abilities.get(0).setDescription("A quick, precise stab that deals 20 physical damage.");
        this.abilities.get(0).setEPCost(5);
        this.abilities.get(0).setAttackDamage(20);
        
        this.abilities.add(new Ability("Backstab"));
        this.abilities.get(1).setDescription("Strike a vital point and deal 35 points of physical damage.");
        this.abilities.get(1).setEPCost(35);
        this.abilities.get(1).setAttackDamage(15);
        
        this.abilities.add(new Ability("Focus"));
        this.abilities.get(2).setDescription("Take a moment to concentrate, restoring your mental energy. Restores 10 EP.");
        this.abilities.get(2).setEPCost(0);
        this.abilities.get(2).setAttackDamage(0);

        this.abilities.add(new Ability("Smoke Bomb"));
        this.abilities.get(3).setDescription("Throw a smoke bomb, making you harder to hit. You have a 50% chance of evading any incoming attacks in the current round.");
        this.abilities.get(3).setEPCost(15);
        this.abilities.get(3).setAttackDamage(0);

        this.abilities.add(new Ability("Sneak Attack"));
        this.abilities.get(4).setDescription("You rely on your agility to evade your opponent, taking no damage from any of their attacks, while you deal 45 physical damage to them.");
        this.abilities.get(4).setEPCost(25);
        this.abilities.get(4).setAttackDamage(45);
    }
    
    public Rogue(String name) {
        this(); 
        this.name = name;
    }

    /* GETTERS & SETTERS */

    /* METHODS */
}