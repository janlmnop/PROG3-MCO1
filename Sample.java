// DUE :  June 28, 2025 (Sa) 2100

// TASKS
// [ ] player 1 chooses from the options
// [ ] player 2 chooses from the options
// [ ] program proper

import java.util.*;

public class Sample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;


        do {
            System.out.println("Select from the following options: ");        
            System.out.println("[1] view character");
            System.out.println("[2] create character");
            System.out.println("[3] edit character");
            System.out.println("[4] delete character");
            // should there be an exit option
            System.out.print(">> ");
            option = input.nextInt();

            switch (option) {
                case 1 : System.out.println("option 1"); break;
                case 2 : System.out.println("option 2"); break; 
                case 3 : System.out.println("option 3"); break;
                case 4 : System.out.println("option 4"); break;
            }
        } while (option > 0 && option < 5);

        input.close();
    }
}