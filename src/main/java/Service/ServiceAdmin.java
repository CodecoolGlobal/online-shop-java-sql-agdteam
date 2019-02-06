package Service;

import DAO.*;
import Model.Customer;
import View.View;
import View.ViewAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServiceAdmin {
	private ServiceUtilityAdmin serviceUtilityAdmin;
	private ViewAdmin viewAdmin;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer adminUser;

	private static final ArrayList<String> ADMIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Test", "Show All Customers", "Logout"));

	public ServiceAdmin(Customer adminUser, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.adminUser = adminUser;
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.viewAdmin = new ViewAdmin();
		this.view = view;
	}


	public void run() {
		int choice;
		END:
		do {
			choice = viewAdmin.getUserMenuChoice("Admin menu", ADMIN_MENU_OPTIONS);
			switch (choice) {
				case 1:
					System.out.println(adminUser.getName() + "<--- Admin name");
					pause();
					//TODO: CustomerDAO - get all customers
					break;
				case 0:
					break END;
			}
		} while (choice != 0);
	}




	public static void pause() {
		System.out.println("test <--------------");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}

