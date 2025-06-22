/**
 * Driver Methods (modularization so it looks cleaner)
*/
import java.util.*;

public class Methods {
    public boolean quitFlag = false;

    /* CHARACTER SELECTION & MANAGEMENT PORTION */
    public void characterManagement(Player player, Scanner nameSC, Scanner numSC, Scanner charSC) {
        System.out.print("Enter name: ");
        String name = nameSC.nextLine(); 
        player.setName(name);
        System.out.println("Greetings! " + player.getName());

        int option; 
        do {
            printManagementOptions();
            System.out.print(">> ");
            option = numSC.nextInt();

            switch (option) {
                case 1 : viewCharacters(player,numSC); break;
                case 2 : createCharacter(player, numSC, nameSC); break; 
                case 3 : editCharacter(player, numSC); break;
                case 4 : deleteCharacter(player, numSC, charSC); break;
                default: System.out.println("Invalid Input!");
            }
        } while (quitFlag != true);       
    }


    public void printManagementOptions() {
        System.out.println("\nSelect from the following options: ");        
            System.out.println("[1] view character(s)");
            System.out.println("[2] create character");
            System.out.println("[3] edit character");
            System.out.println("[4] delete character");
    }


    public void viewCharacters(Player thisPlayer, Scanner numSC) {
        System.out.println("\n[View Characters]");
        System.out.println(thisPlayer.getName() + "'s Characters:");
        thisPlayer.displayRoster();
        System.out.println();
        System.out.print(">> ");
        int option1 = numSC.nextInt();

        System.out.println("\n[0] Select this character");
        System.out.println("[1] View this character in detail");
        System.out.println("[2] Back");
        System.out.print(">> ");
        int option2 = numSC.nextInt();

        if (option2 == 0) {
            System.out.println(thisPlayer.getName() + " selected " + thisPlayer.getRoster().get(option1).getName());
            thisPlayer.setChosenCharacter(thisPlayer.getRoster().get(option1));
            thisPlayer.getChosenCharacter().abilities.add(new Ability("defend"));
            thisPlayer.getChosenCharacter().abilities.add(new Ability("defend"));
            quitFlag = true;
        } else if (option2 == 1) {
            System.out.println("\nName: " + thisPlayer.getRoster().get(option1).getName());
            System.out.println("Description: " + thisPlayer.getRoster().get(option1).getDetails());
            System.out.println("Type: " + thisPlayer.getRoster().get(option1).getType());
            thisPlayer.getRoster().get(option1).printAbilityPool();
        }
    }


    public void createCharacter(Player thisPlayer, Scanner numSC, Scanner nameSC) {
        System.out.println("\n[Create Character]");
        System.out.println("\nSelect from the following: ");
        System.out.println("[1] Mage");
        System.out.println("[2] Rogue");
        System.out.println("[3] Warrior");
        System.out.print(">> ");
        int option = numSC.nextInt();

        if (option == 1) {
            Mage newCharacter = new Mage();
            thisPlayer.getRoster().add(newCharacter);
            newCharacter.setType("Mage");
            selectAbilities(thisPlayer, newCharacter, numSC, nameSC);
            
        } else if (option == 2) {
            Rogue newCharacter = new Rogue();
            thisPlayer.getRoster().add(newCharacter);
            newCharacter.setType("Rogue");
            selectAbilities(thisPlayer, newCharacter, numSC, nameSC);

        } else if (option == 3) {
            Warrior newCharacter = new Warrior();
            thisPlayer.getRoster().add(newCharacter);
            newCharacter.setType("Warrior");
            selectAbilities(thisPlayer, newCharacter, numSC, nameSC);

        } else {
            System.out.println("Invalid Input!");
        }

        System.out.print("Character name: ");
        String name = nameSC.nextLine();
        thisPlayer.getRoster().getLast().setName(name);

        System.out.print("Character description: ");
        String description = nameSC.nextLine();
        thisPlayer.getRoster().getLast().setDetails(description);
    }


    public void editCharacter(Player thisPlayer, Scanner numSC) {
        System.out.println("\n[Edit Character]");
        System.out.println("\n" + thisPlayer.getName() + "'s Characters");
        thisPlayer.displayRoster();
        
        System.out.print("Which charcter would you like to edit: ");
        int charToEdit = numSC.nextInt();
        
        System.out.println("\nEdit Options:");
        System.out.println("[0] Change Character Class");
        System.out.println("[1] Change Character Abilities");
        System.out.print(">> ");
        int option = numSC.nextInt();

        if (option == 0) {
            System.out.println("\nSelect a Class: ");
            System.out.println("[0] Mage");
            System.out.println("[1] Rogue");
            System.out.println("[2] Warrior");
            System.out.print(">> ");
            option = numSC.nextInt();

            if (option == 0) 
                thisPlayer.getRoster().get(charToEdit).setType("Mage");
            else if (option == 1)
                thisPlayer.getRoster().get(charToEdit).setType("Rogue");
            else if (option == 2)
                thisPlayer.getRoster().get(charToEdit).setType("Warrior");
            else
                System.out.println("Invalid Input!");

            selectAbilities(thisPlayer, thisPlayer.getRoster().get(charToEdit), numSC, numSC);
        } else if (option == 1) {
            selectAbilities(thisPlayer, thisPlayer.getRoster().get(charToEdit), numSC, numSC);
        } else 
            System.out.println("Invalid Input!");
    }


    public void deleteCharacter(Player thisPlayer, Scanner numSC, Scanner charSC) {
        System.out.println("\n[Delete Character]");
        System.out.println("\n Select a charter to delete:");
        System.out.println("" + thisPlayer.getName() + "'s Characters");
        thisPlayer.displayRoster();
        System.out.print(">> ");
        int option = numSC.nextInt();

        System.out.print("\nDo you wish to delete " + thisPlayer.getRoster().get(option).getName() + " completely? (y/n): ");
        char choice = charSC.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {
            thisPlayer.getRoster().remove(thisPlayer.getRoster().get(option));
            System.out.println("Remaining Character(s): ");
            thisPlayer.displayRoster();
        } else if (choice == 'n' || choice == 'N') {
            System.out.println("Great!");
        } else {
            System.out.println("Invalid Input!");
        }
    }


    public static void selectAbilities(Player thisPlayer, Character newCharacter, Scanner numSC, Scanner nameSC) {
        Mage m = new Mage();
        Rogue r = new Rogue();
        Warrior w = new Warrior();

        System.out.println("\nSelect from the following abilities (choose 3): ");
        if (thisPlayer.getRoster().getLast().getType() == "Mage") {
            m.printAbilityOptions();
            for (int i=0; i<3; i++) {
                System.out.print("Ability #" + i + ": ");
                int option = numSC.nextInt();
                newCharacter.abilities.set(i, m.abilities.get(option));
            }
        } else if (thisPlayer.getRoster().getLast().getType() == "Rogue") {
            r.printAbilityOptions();
            for (int i=0; i<3; i++) {
                System.out.print("Ability #" + i + ": ");
                int option = numSC.nextInt();
                newCharacter.abilities.set(i, r.abilities.get(option));
            }
        } else if (thisPlayer.getRoster().getLast().getType() == "Warrior") {
            w.printAbilityOptions();
            for (int i=0; i<3; i++) {
                System.out.print("Ability #" + i + ": ");
                int option = numSC.nextInt();
                newCharacter.abilities.set(i, w.abilities.get(option));
            }
        } 
    
        System.out.println("\nSelected Abilities:");
        newCharacter.printAbilityPool();
    }
    


    

    /* FIGHT! OR GAME PROPER PORTION */
    public void gameProper(Player player1, Player player2, Scanner numSC) {
        System.out.println("\nFIGHT!");

        int i=1;
        do {
            if (i > 1) {
                player1.getChosenCharacter().setEP(player1.getChosenCharacter().getEP() + 5);
                player2.getChosenCharacter().setEP(player2.getChosenCharacter().getEP() + 5);
            }

            System.out.println("\nROUND " + i);
            displayStats(player1, player2);

            System.out.println("\n[Player 1's Move]");
            System.out.println("Select from the following moves:");
            player1.getChosenCharacter().displayMoves();
            int p1Move;
            do {
                System.out.print("Move: ");
                p1Move = numSC.nextInt();
            } while (isValidMove(player1, player1.getChosenCharacter(), p1Move) != false);

            System.out.println("\n[Player 2's Move]");
            System.out.println("Select from the following moves:");
            player2.getChosenCharacter().displayMoves();
            int p2Move;
            do {
                System.out.print("Move: ");
                p2Move = numSC.nextInt();
            } while (isValidMove(player2, player2.getChosenCharacter(), p2Move) != false);

            // execute move
            player1.getChosenCharacter().executeMove(player1, player2, p1Move);
            player2.getChosenCharacter().executeMove(player2, player1, p2Move);

            displayStats(player1, player2);
            
            i++;
        } while (player1.getChosenCharacter().getHP() > 0 && player2.getChosenCharacter().getHP() > 0);

        if (player1.getChosenCharacter().getHP() > player2.getChosenCharacter().getHP()) {
            System.out.println(player1.getName() + " Won!");
        }
    }

    // checks for valid moves | if epcost is gt ep ng character
    public boolean isValidMove(Player player, Character playerCharacter, int move) {
        if(playerCharacter.abilities.get(move).getEPCost() > player.getChosenCharacter().getEP())
            return true;
        if(move < 0)
            return false;
        if(move > 4)
            return false;
        else 
            return false;
    }
    
    public void displayStats(Player player1, Player player2) {
        System.out.println("✧˖ °. ݁₊ ⊹ . ݁˖ . ݁‧₊˚ ☾.  ݁₊ ⊹ . ݁˖ . ݁˖°✧");
        System.out.println("STATS:");
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Character: " + player1.getChosenCharacter().getName());
        System.out.println("Energy Points: " + player1.getChosenCharacter().getEP());
        System.out.println("Health Points: " + player1.getChosenCharacter().getHP());
        System.out.println("\nPlayer 2: " + player2.getName());
        System.out.println("Character: " + player2.getChosenCharacter().getName());
        System.out.println("Energy Points: " + player2.getChosenCharacter().getEP());
        System.out.println("Health Points: " + player2.getChosenCharacter().getHP());
        System.out.println("✧˖ °. ݁₊ ⊹ . ݁˖ . ݁‧₊˚ ☾.  ݁₊ ⊹ . ݁˖ . ݁˖°✧");
    }
}