package View;

import Model.Product;

import DAO.CategoryDAO;
import DAO.ProductsDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class View {
    protected ValidatorInput validatorInput;
	private static final ArrayList<String> MAIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Login", "Create account", "Shop without logging"));
	private static final ArrayList<String> ADMIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Show all Product", "Show Product By Category", "Show all feedback", "Crud product"));
	private static final ArrayList<String> USER_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Show all Product", "Show Basket", "Add Product to basket", "Add feedback", "Remove Product from basket", "Buy"));
	protected static final ArrayList<String> CRUD_PRODUCT_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Add", "Del", "Update"));


    public View(){
        this.validatorInput = new ValidatorInput();
    }

    public int getMainMenuChoice(){
	    return getUserMenuChoice("Login menu:", MAIN_MENU_OPTIONS);
    }

	public int getAdminMenuChoice() {
		return getUserMenuChoice("Admin menu:", ADMIN_MENU_OPTIONS);
	}

	public int getAdminCrudMenuChoice() {
		return getUserMenuChoice("Admin Crud:", CRUD_PRODUCT_MENU_OPTIONS);
	}

	public int getUserMenuChoice(String menuTitle, List<String> menuOptions){
		System.out.print("\033[H\033[2J");
		showMenuFromTitleList(menuTitle, menuOptions);
		int choice = -1;
		do {
			try {
				System.out.print("Please select menu option:");
				choice = validatorInput.getIntInput(menuOptions.size());
			} catch (NumberFormatException | IndexOutOfBoundsException m) {
				System.out.println(m.getMessage());
			}
		} while (choice < 0);
		return choice;
	}

	public BigDecimal getPrice(){
    	BigDecimal bigDecimal = new BigDecimal(-1);
		do {
			try {
				System.out.print("Price: ");
				bigDecimal = validatorInput.getBigDecimal();
				if (bigDecimal.compareTo(new BigDecimal(0)) < 0) {
					System.out.println("Price should be grater or equals 0");
				}
			} catch (NumberFormatException m) {
				System.out.println("Invalid input, please try again");
			}
		} while (bigDecimal.equals(new BigDecimal(-1)));
		return bigDecimal;
	}

	public BigDecimal getForEditPrice() {
		BigDecimal bigDecimal = new BigDecimal(-1);
		do {
			try {
				System.out.print("Price: ");
				bigDecimal = validatorInput.getForEditBigDecimal();
				if (bigDecimal.compareTo(new BigDecimal(0)) < 0 && !bigDecimal.equals(new BigDecimal(-2))) {
					System.out.println("Price should be grater or equals 0");
				}
			} catch (NumberFormatException m) {
				System.out.println("Invalid input, please try again");
			}
		} while (bigDecimal.equals(new BigDecimal(-1)));
		return bigDecimal;

	}

	public int getForEditAmount(){
    	int amount = -1;
		do {
			try {
				System.out.print("Amount:");
				amount = validatorInput.getIntInput(1000);
			} catch (NumberFormatException | IndexOutOfBoundsException m) {
				System.out.println(m.getMessage());
			}
		} while (amount < 0 && amount != -2);
		return amount;
	}

	public int getAmount(){
		int amount = -1;
		do {
			try {
				System.out.print("Amount:");
				amount = validatorInput.getIntInput(1000);
			} catch (NumberFormatException | IndexOutOfBoundsException m) {
				System.out.println(m.getMessage());
			}
		} while (amount < 0);
		return amount;
	}

	public String getName(){
		System.out.print("Name: ");
		return validatorInput.getUserName();
	}

	public String getProductName(){
		System.out.print("Product name: ");
		return validatorInput.getWords();
	}


	public String getLogin(){
		System.out.print("Login: ");
		return validatorInput.getUserLogin();
	}

	public String getPassword(){
		System.out.print("Password: ");
		return validatorInput.getUserName();
	}

	public Integer getId(int max){
		System.out.print("Id: ");
		return validatorInput.getIntInput(max);
	}

	public Integer getIdProduct(ProductsDAO productsDAO){
//		System.out.print("Id: ");
		return validatorInput.getIdOfProduct(productsDAO);
	}


	public String getString(String string){
		System.out.println(string);
		return validatorInput.getWords();
	}

	public String getCategoryName(){
		System.out.print("Category name :");
		return validatorInput.getWords();
	}


	public void displayInvalidNameOrPassword() {
		System.out.println("Invalid Name or Password");
		pause();
	}

	public String getCategoryName(CategoryDAO categoryDAO) {
		categoryDAO.getAll().stream().map(e -> e.getId() + " : " + e.getName()).forEach(System.out::println);
		return validatorInput.getInputCategory(categoryDAO);
	}

	public String getCategoryNameEdit(CategoryDAO categoryDAO) {
		categoryDAO.getAll().stream().map(e -> e.getId() + " : " + e.getName()).forEach(System.out::println);
		do {
			System.out.print("Category: ");
			String category = validatorInput.getWords();
			if (category.equals("")) {
				return "";
			} else {
				try {
					category = categoryDAO.getCategoryById(Integer.parseInt(category)).getName();
					return category;
				} catch (SQLException | NumberFormatException m) {
					System.out.println("There is not that category or wrong input, please try again");
				}
			}
		} while (true);
	}

	public void showEditMessage(){
		System.out.println("If you press ENTER, then won't be edit. ");
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

	public static void pause() {
		System.out.println("Press Enter");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public void printSingleProduct(Product product, int id){
        String printProduct = String.format(
                "Id: %d - %s - Price = %.2f, Amount = %d",
                id,
                product.getName(),
                product.getPrice(),
                product.getAmount());
        System.out.println(printProduct);
    }

    public int getIdOfItem(int max){
        System.out.println("Please select id of item you want to buy");
        return validatorInput.getIntInput(max);
    }

    public int getAmountOfItem(int max){
        System.out.println("Please specify quantity you want to buy");
        return validatorInput.getIntInput(max);
    }
}
