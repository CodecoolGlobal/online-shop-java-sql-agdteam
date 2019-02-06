package View;

import java.util.Scanner;

public class ValidatorInput {
    private Scanner inputScanner;

    public ValidatorInput() {
        inputScanner = new Scanner(System.in);
    }

    public int getIntInput(int minimum, int maximum) {
        boolean inputCorrect = false;
        while (!inputCorrect) {
            try {
                int input = Integer.parseInt(inputScanner.next());
                if (input >= minimum && input <= maximum) {
                    return input;
                } else {
                    System.out.println("Incorrect choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("This is not a number, please try again");
            }
        } return 0;
    }

    public String getUserName(){ //todo validate
        return inputScanner.nextLine();
    }

    public String getUserPassword(){
        return inputScanner.nextLine();
    }
}
