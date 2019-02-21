package View;

import DAO.ProductsDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
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
                int input = Integer.parseInt(inputScanner.nextLine());
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

    public int getInt(ProductsDAO productsDAO){
        while (true){
            try {
                int input = Integer.parseInt(inputScanner.nextLine());
                if (productsDAO.getProductById(input) != null) {
                    return input;
                } else {
                    System.out.println("Incorrect choice");
                }
            } catch (NumberFormatException | SQLException e) {
                System.out.println("This is not a number, please try again");
            }
        }
    }

    public String getUserName(){ //todo validate
        return inputScanner.nextLine();
    }

    public String getUserLogin(){
        return inputScanner.nextLine();
    }

    public BigDecimal getBigDecimal(){
        return new BigDecimal(inputScanner.nextLine());
    }

    public String getWord(){
        return inputScanner.nextLine();
    }

    public String getUserPassword(){ //todo validate
        return inputScanner.nextLine();
    }

    public int getIdOfItem(){ return Integer.parseInt(inputScanner.nextLine());}
//    public int getIdOfItem(){ return Integer.parseInt(inputScanner.next());}

    public String inputFeedback(){
        return inputScanner.nextLine();
    }
}
