package ca.timnorman.semesterscheduler;

import java.util.Scanner;

/**
 * A class to prompt the user on what to do when the program runs. Options include:
 * Creating a new schedule,
 * reading an old schedule,
 * writing existing schedule.
 */
public class StartPrompt {

    public void promptUserForCommand() {

        System.out.printf("Enter the character for what you would like to do:%n" +
                "(N) New Schedule %n" +
                "(R) Read Existing Schedule %n" +
                "(S) Save Current Schedule %n" +
                "Your selection: ");
        validateUserSelection();
    }

    private void validateUserSelection() {
        Scanner keyboard = new Scanner(System.in);
        boolean doContinue = true;

        do {
            String userInput = keyboard.nextLine();
            switch (userInput.toUpperCase()) {
                case "N":
                    // Create new schedule
                    new Schedule().createNew();
                    doContinue = false;
                    break;

                case "R":
                    // Read existing schedule
                    System.out.println("Read existing schedule");
                    doContinue = false;
                    break;

                case "S":
                    // Save current schedule
                    System.out.println("Save current schedule");
                    doContinue = false;
                    break;

                default:
                    System.out.print("Not a valid selection, please try again: ");
            }

        } while (doContinue == true);
    }
}
