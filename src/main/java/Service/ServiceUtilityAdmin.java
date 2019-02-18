package Service;

import DAO.*;
import Model.Category;
import Model.Product;
import View.View;
import View.ViewAdmin;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

import static View.View.pause;

public class ServiceUtilityAdmin {
	private ViewAdmin viewAdmin;
	private CustomerDAO customerDAO;
	private FeedbackDAO feedbackDAO;
	private OrdersDAO ordersDAO;
	private ProductsDAO productsDAO;
	private CategoryDAO categoryDAO;
	private View view;

	public ServiceUtilityAdmin(CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO, CategoryDAO categoryDAO, View view) {
		this.customerDAO = customerDAO;
		this.feedbackDAO = feedbackDAO;
		this.ordersDAO = ordersDAO;
		this.productsDAO = productsDAO;
		this.viewAdmin = new ViewAdmin();
		this.categoryDAO = categoryDAO;
		this.view = view;
	}

	public void crudProducts() {

	}

	public void crudCategories(){
		int choice;
		do {
			choice = view.getAdminCrudMenuChoice();
			switch (choice) {
				case 1: {
					addOrUpdateProduct();
					pause();
					break;
				}
				case 2:	{
//					System.out.println("test <---------");
//					System.out.println(productsDAO.getProductById(1).getName());
//					System.out.println(productsDAO.getProductById(view.getId(productsDAO.getAll().size())));
					productsDAO.delete(productsDAO.getProductById(view.getId(productsDAO.getAll().size())));
					break;
				}
				case 3:{
					addOrUpdateProduct(view.getId(productsDAO.getAll().size()));
				}
			}


		} while (choice != 0);
	}

	private void addOrUpdateProduct(int id) {
		String name = view.getProductName();
		BigDecimal price = new BigDecimal(String.valueOf(view.getPrice()));
		int amount = view.getAmount();
		categoryDAO.getAll().stream().map(Category::getName).forEach(System.out::println);
		String categoryChoice = view.getCategoryName();
		Category category = categoryDAO.getAll().stream().filter(e -> e.getName().equals(categoryChoice)).findFirst().get();
		if ((id == -1)) {
			productsDAO.add(new Product(name, price, amount, category));
		} else {
			productsDAO.update(id, new Product(id, name, price, amount, category));
		}
	}

	private void addOrUpdateProduct(){
		addOrUpdateProduct(-1);
	}

	public void showProductByCategory(){
//		categoryDAO.getAll().stream().forEach(System.out::println);
		String category = view.getIdCategory(categoryDAO);
		productsDAO.getAll().stream().filter(e -> e.getCategory().getName().equals(category)).forEach(System.out::println);
		pause();
	}

	public void crudCustomers(){

	}

	public void showOrders(){

	}

	public void showFeedback(){

	}

}
