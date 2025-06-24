public class Ability {
    /* ATTRIBUTES */
    private String name;
    private String description;
    private int EPcost;
    private int attackDamage;

    /* CONSTRUCTOR(S) */
    public Ability(String name) {
        this.name = name;
    }


    /* GETTERS & SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEPCost() {
        return EPcost;
    }

    public void setEPCost(int EPcost) {
        this.EPcost = EPcost;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }


    /* METHODS */
}