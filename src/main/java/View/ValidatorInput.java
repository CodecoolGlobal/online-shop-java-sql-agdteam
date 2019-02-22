package View;

import DAO.CategoryDAO;
import DAO.ProductsDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class ValidatorInput {
    private Scanner inputScanner;

    public ValidatorInput() {
        inputScanner = new Scanner(System.in);
    }

    public String getInputCategory(CategoryDAO categoryDAO){
        int numberCategory;
        String category = "";
        do {
            try {
                System.out.print("Category: ");
                numberCategory = Integer.parseInt(inputScanner.nextLine());
                category = categoryDAO.getCategoryById(numberCategory).getName();
            } catch (SQLException | NumberFormatException m) {
                System.out.println("There is not that category or wrong input, please try again");
            }
        } while (category.equals(""));
        return category;
    }

    public int getIdOfProduct(ProductsDAO productsDAO){
        while (true){
            try {
                System.out.print("Please select item ID: ");
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

    public int getIntInput(int maximum) throws NumberFormatException, IndexOutOfBoundsException{
            try {
                String number = inputScanner.nextLine();
                if (number.equals("")) {
                    return -2;
                }else {
                    int input = Integer.parseInt(number);
                    if (input >= 0 && input <= maximum) {
                        return input;
                    } else {
                        throw new IndexOutOfBoundsException("Number out of range, please try again");
                    }
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("This is not a number, please try again");
            }
    }





    public String getUserName(){ //todo validate
        return inputScanner.nextLine();
    }

    public String getUserLogin(){
        return inputScanner.nextLine();
    }

    public BigDecimal getBigDecimal() throws NumberFormatException{
        String input = inputScanner.nextLine();
        return new BigDecimal((input.equals("")? "-2": input));
    }

//    public BigDecimal getForEditBigDecimal() throws NumberFormatException{
//        String input = inputScanner.nextLine();
//        if (input.length() == 0) {
//            return new BigDecimal(-2);
//        }
//        return new BigDecimal(input);
//    }

    public String getWords(){
        return inputScanner.nextLine();
    }

    public String getUserPassword(){ //todo validate
        return inputScanner.nextLine();
    }

    public int getIdOfItem(){ return Integer.parseInt(inputScanner.nextLine());}

    public int getIdOfProduct(){ return Integer.parseInt(inputScanner.next());}

    public String inputFeedback(){
        return inputScanner.nextLine();
    }
}
