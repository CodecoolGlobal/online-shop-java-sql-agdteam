import DAO.*;
import Model.Basket;
import Model.Customer;
import Model.Feedback;
import Service.ServiceAdmin;
import Service.ServiceCustomer;
import View.View;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
	private ServiceAdmin serviceAdmin;
	private ServiceCustomer serviceCustomer;
	private SQLConnector sqlConnector;
	private ProductsDAO productsDAO;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private View view;

	private static final ArrayList<String> MAIN_MENU_OPTIONS = new ArrayList<>(Arrays.asList("Login", "Shop without logging", "Exit"));
	private Customer customer;


	public Controller(){
		this.view = new View();
	}

	public void mainLoop() {
		boolean appIsOn = true;
		while (appIsOn){
			int userOption = view.getUserMenuChoice("Login Menu", MAIN_MENU_OPTIONS);
			switch (userOption){
				case 1:
					//TODO: login menu & select customer or admin
					Basket userBasket = new Basket();

					Customer loggedAdminUser = new Customer(1, true, "dummyUser", "dummyLogin", "userName", userBasket);
					serviceAdmin = new ServiceAdmin(loggedAdminUser, customerDAO, feedbackDAO, ordersDAO, productsDAO);
					serviceAdmin.serviceAdminRun();
					break;
				case 2:
					//TODO: login as anonymous customer
					break;
				case 3:
					appIsOn = false;
					break;
			}
		}
	}

	public boolean loginRecognizer() {

		return false;
	}

	private boolean loginAsCustomer(){

		return false;
	}

	private boolean loginAsAdmin(){

		return false;
	}



}
