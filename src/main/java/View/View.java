package View;

import java.util.*;

public class View {
    private ValidatorInput validatorInput;
	private static final ArrayList<String> MAIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Login", "Create account", "Shop without logging"));
	private static final ArrayList<String> ADMIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Show all Product", "Show Product By Category", "Show all feedback", "Edit By ID", "Remove All Unavailable"));
	private static final ArrayList<String> USER_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Show all Product", "Show Basket", "Add Product to basket", "Add feedback", "Remove Product from basket", "Buy"));


    public View(){
        this.validatorInput = new ValidatorInput();
    }

    public int getMainMenuChoice(){
	    return getUserMenuChoice("Login menu", MAIN_MENU_OPTIONS);
    }

	public int getAdminMenuChoice() {
		return getUserMenuChoice("Admin menu", ADMIN_MENU_OPTIONS);
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

	public String getLogin(){
		System.out.print("Login: ");
		return validatorInput.getUserLogin();
	}

	public String getPassword(){
		System.out.print("Password: ");
		return validatorInput.getUserName();
	}

	public void displayInvalidNameOrPassword() {
		System.out.println("Invalid Name or Password");
		pause();
	}


    private void showMenuFromTitleList(String menuTitle, List<String> menuOptions){
        System.out.println(menuTitle);
        for (int i = 0; i < menuOptions.size(); i++){
	        System.out.println(i + 1  + ". " + menuOptions.get(i));
        }
	    System.out.println("0. Exit");
    }






	public void printString(String string) {

	}

	public void printTable(Collections collections, List listHeaders) {

	}

	public static void pause() {
		System.out.println("Press Enter");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

}
