package View;

import java.util.*;
import java.util.stream.Stream;

public class View {
    private ValidatorInput validatorInput;
	private static final ArrayList<String> MAIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Login", "Shop without logging", "Exit"));


    public View(){
        this.validatorInput = new ValidatorInput();
    }

    public int getUserMainMenuChoice(){
	    return getUserMenuChoice("Login menu", MAIN_MENU_OPTIONS);
    }

	public int getUserMenuChoice(String menuTitle, List<String> menuOptions){
		showMenuFromTitleList(menuTitle, menuOptions);
		System.out.print("Please select menu option:");
		return validatorInput.getIntInput(1, menuOptions.size());
	}

	public String getName(){
		System.out.println("Name: ");
		return validatorInput.getUserName();
	}

	public String getPassword(){
		System.out.println("Password: ");
		return validatorInput.getUserName();
	}

	public void displayInvalidNameOrPassword() {
		System.out.println("Invalid Name or Password");
	}


    private void showMenuFromTitleList(String menuTitle, List<String> menuOptions){
        System.out.println(menuTitle);
        for (int i = 0; i < menuOptions.size();i++){
            int optionNumber = i+1;
            System.out.println(optionNumber + ". " + menuOptions.get(i));
        }
    }






	public void printString(String string) {

	}

	public void printTable(Collections collections, List listHeaders) {

	}

}
