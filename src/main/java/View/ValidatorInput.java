package View;

import java.math.BigDecimal;
import java.util.Scanner;

public class ValidatorInput {
    private Scanner inputScanner;

    public ValidatorInput() {
        inputScanner = new Scanner(System.in);
    }

    public int getIntInput( int maximum) {
        boolean inputCorrect = false;
        while (!inputCorrect) {
            try {
                int input = Integer.parseInt(inputScanner.next());
                if (input >= 0 && input <= maximum) {
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
        return inputScanner.next();
    }

    public String getUserLogin(){
        return inputScanner.next();
    }

    public BigDecimal getBigDecimal(){
        return new BigDecimal(inputScanner.next());
    }

    public String getWord(){
        return inputScanner.next();
    }

    public String getUserPassword(){ //todo validate
        return inputScanner.nextLine();
    }

    public int getIdOfItem(){ return Integer.parseInt(inputScanner.next());}

    public String inputFeedback(){
        return inputScanner.nextLine();
    }
}
