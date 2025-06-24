// DUE :  June 28, 2025 (Sa) 2100

// TASKS
// [ ] Player selection ? like from a list (file manipulation)
// [D] Player 1 character selection
//      [D] view characters (list)
//          [D] view characters (in detail)
//          [D] character selection
//      [D] create character
//          [D] class selection
//          [D] class ability selection
//          [D] name character
//          [D] option to add description
//      [D] edit character
//      [D] delete characters
// [D] Player 2 character selection (same process)
// [ ] Fight!
//      [D] +5 EP at the start of each round (ideally after round 1)
//      [D] prompt players to choose from moves (loops until input is valid)
//      [D] execute moves (deal damages, change health, subtract from EP and HP)
//      [D] losing sequence
// [ ] Miscellaneous
//      [ ] add new attributes and methods to UML
//      [ ] documenation
//      [ ] make sure code follows Java best practices

// reminders: 
// - character names should be unique (make a checker)
// - test invalid inputs


import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // // testing purposes
        // ArrayList<Character> roster1 = new ArrayList<Character>();
        // roster1.add(new Character("Dog"));
        // roster1.getFirst().setType("Warrior");
        // Warrior w = new Warrior();
        // roster1.get(0).abilities.add(0, w.abilities.get(1));
        // roster1.get(0).abilities.add(1, w.abilities.get(2));
        // roster1.get(0).abilities.add(2, w.abilities.get(3));
        // roster1.add(new Character("Hamster"));
        // roster1.get(1).setType("Mage");
        // Mage m = new Mage();
        // roster1.get(1).abilities.add(0, m.abilities.get(0));
        // roster1.get(1).abilities.add(1, m.abilities.get(1));
        // roster1.get(1).abilities.add(2, m.abilities.get(2));


        // ArrayList<Character> roster2 = new ArrayList<Character>();
        // roster2.add(new Character("Cat"));
        // roster2.getFirst().setType("Rogue");
        // Rogue r = new Rogue();
        // roster2.get(0).abilities.add(0, r.abilities.get(0));
        // roster2.get(0).abilities.add(1, r.abilities.get(1));
        // roster2.get(0).abilities.add(2, r.abilities.get(2));

        // Player player1 = new Player(roster1);
        // Player player2 = new Player(roster2);

        Player player1 = new Player();
        Player player2 = new Player();

        // this is where the Driver methods are stored (for now)
        Methods funcs = new Methods();

        // to get user inputs
        Scanner nameSC = new Scanner(System.in);
        Scanner numSC = new Scanner(System.in);
        Scanner charSC = new Scanner(System.in);

        // opening sequence -> make creative
        System.out.println("Fatal Fantasy");

        // Player 1 Character Selection
        System.out.println("\n[Player 1] ");
        funcs.characterManagement(player1, nameSC, numSC, charSC);

        // Player 2 Character Selection
        funcs.quitFlag = false;
        System.out.println("\n[Player 2] ");
        funcs.characterManagement(player2, nameSC, numSC, charSC);

        // Fight! : game proper
        funcs.gameProper(player1, player2, numSC); 

        // close Scanners
        nameSC.close();
        numSC.close();
        charSC.close();
    }
}