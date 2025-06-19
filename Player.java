import java.util.ArrayList;

public class Player {
    /* ATTRIBUTES */
    private String name;
    private ArrayList<Character> roster = new ArrayList<>(3);       // player's list of characters (maximum of 3)
    private Character chosenCharacter;                                              // player's character that will enter the game

    /* CONSTRUCTOR(S) */
    public Player() {
        // would ideally set the player's characters; not sure if that is a file thing
    }

    public Player(ArrayList<Character> roster) {
        this.roster = roster;
    }

    public Player(String name, ArrayList<Character> roster) {
        this.name = name;
        this.roster = roster;
    }
    

    /* GETTERS & SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getChosenCharacter() {
        return chosenCharacter;
    }

    public void setChosenCharacter(Character character) {
        this.chosenCharacter = character;
    }

    public ArrayList<Character> getRoster() {
        return roster;
    }

    
    /* METHODS */
    public void displayRoster() {
        if (roster != null) {
            for (int i=0; i<roster.size(); i++)
                System.out.println("[" + i + "] " + roster.get(i).getName());
        } else {
            System.out.println("Invalid Input!");
        }
    }
}