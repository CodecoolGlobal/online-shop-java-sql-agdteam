import DAO.*;
import Model.Customer;
import Service.*;

public class Controller {
	private ServiceAdmin serviceAdmin;
	private ServiceCustomer serviceCustomer;
	private SQLConnector sqlConnector;
	private ProductsDAO productsDAO;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private Customer customer;


	public void mainRun() {

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
