package View;

import Model.Product;

import java.util.*;
import java.util.stream.Stream;

public class View {
    private ValidatorInput validatorInput;
	private static final ArrayList<String> MAIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Login", "Shop without logging"));


    public View(){
        this.validatorInput = new ValidatorInput();
    }

    public int getUserMainMenuChoice(){
	    return getUserMenuChoice("Login menu", MAIN_MENU_OPTIONS);
    }

	public int getUserMenuChoice(String menuTitle, List<String> menuOptions){
		System.out.print("\033[H\033[2J");
		showMenuFromTitleList(menuTitle, menuOptions);
		System.out.print("Please select menu option:");
		return validatorInput.getIntInput(menuOptions.size());
	}

	public String getName(){
		System.out.print("Name: ");
		return validatorInput.getUserName();
	}

	public String getPassword(){
		System.out.print("Password: ");
		return validatorInput.getUserName();
	}

	public void displayInvalidNameOrPassword() {
		System.out.println("Invalid Name or Password");
	}


    private void showMenuFromTitleList(String menuTitle, List<String> menuOptions){
        System.out.println(menuTitle);
        for (int i = 0; i < menuOptions.size(); i++){
	        System.out.println(i + 1  + ". " + menuOptions.get(i));

        }
	    System.out.println("0. Exit");
    }

	public void showAllList(List<?> productList) {
		productList.forEach(System.out::println);

	}

	public void printString(String string) {

	}

	public void printTable(Collections collections, List listHeaders) {

	}

}
