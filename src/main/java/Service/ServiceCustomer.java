package Service;

import DAO.*;
import Model.Customer;
import Model.Order;
import Model.OrderStatus;
import Model.Product;
import View.View;
import View.ViewCustomer;
import View.ViewAdmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceCustomer {
	private ServiceUtilityCustomer serviceUtilityCustomer;
	private ViewCustomer viewCustomer;
	private View view;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private Customer customer;
	private OrderedItemsDAO orderedItemsDAO;

	private static final ArrayList<String> CUSTOMER_MENU_OPTIONS =
			new ArrayList<>(Arrays.asList(
					"Show all products",
					"Show My Basket",
					"Add product to My Basket",
					"Place an order",
					"Send feedback"
			));

	public ServiceCustomer(Customer customer, CustomerDAO customerDAO, SQLConnector sqlConnector, View view) {
		this.customer = customer;
		this.customerDAO = customerDAO;
		this.feedbackDAO = new FeedbackDAO(sqlConnector);
		this.ordersDAO = new OrdersDAO(sqlConnector);
		this.productsDAO = new ProductsDAO(sqlConnector);
		this.orderedItemsDAO = new OrderedItemsDAO(sqlConnector);
		this.view = view;
		this.serviceUtilityCustomer = new ServiceUtilityCustomer(customerDAO, feedbackDAO, ordersDAO, productsDAO, customer);
	}

	public void run() {
		int choice;
		do {
			choice = view.getUserMenuChoice("Customer Menu", CUSTOMER_MENU_OPTIONS);
			switch (choice){
				case 1:
					List<Product> allProd = productsDAO.getAll().stream().filter(e -> e.getAmount() > 0).collect(Collectors.toList());
					new ViewAdmin().showAllList(allProd);
					break;
				case 2:
					List<Product> basketProducts = customer.getBasket().getProducts();
				    if (basketProducts.size() == 0){ view.printString("Your basket is empty");}
					for (int i =0; i < basketProducts.size();i++){
					    view.printSingleProduct(basketProducts.get(i), i);
                    }
					break;
				case 3:
                    List<Product> allProducts = productsDAO.getAll();
				    for (int i = 0; i < allProducts.size(); i++){
				    view.printSingleProduct(allProducts.get(i) , i);
                    }
					int itemId = view.getIdOfItem(allProducts.size());
				    Product chosenProduct = allProducts.get(itemId);
				    int totalAmount = chosenProduct.getAmount();
				    int itemAmount = view.getAmountOfItem(chosenProduct.getAmount());
				    customer.addToBasket(chosenProduct, itemAmount);
                    Product updatedProduct = new Product(chosenProduct.getName(), chosenProduct.getPrice(), totalAmount - itemAmount, chosenProduct.getCategory());
					productsDAO.update(chosenProduct.getId(), updatedProduct);
                    break;
				case 4:
					ordersDAO.add(new Order(customer, OrderStatus.SUBMIT));
					customer.getBasket().getProducts().forEach((prod)->orderedItemsDAO.add(prod));
					customer.getBasket().getProducts().clear();
					//todo: jakies info ze zlozono zamowienie itp;
					break;
				case 5:
					//send feedback
					break;
				case 0:
					break;
			}
		} while (choice != 0);
	}
}
