package Service;

import DAO.*;
import Model.*;
import View.*;

import java.math.BigDecimal;
import java.sql.SQLException;

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

	public void crudProduct(){
		int choice;
		do {
			viewAdmin.showAllList(productsDAO.getAll());
			choice = view.getAdminCrudMenuChoice();
			switch (choice) {
				case 1: {
					addProduct();
					pause();
					break;
				}
				case 2:	{
					delProduct();
					break;
				}
				case 3:{
					viewAdmin.showAllList(productsDAO.getAll());
					int id = view.getIdProduct(productsDAO);
					try {
						String name = view.getProductName();
						name = (name.length() == 0) ? productsDAO.getProductById(id).getName() : name;
						BigDecimal price = view.getPrice();
						price = (price.equals(new BigDecimal("-2"))) ? productsDAO.getProductById(id).getPrice() : price;
						int amount = view.getAmount();
						amount = (amount == -2) ? productsDAO.getProductById(id).getAmount() : amount;
						String categoryName = view.getCategoryNameEdit(categoryDAO);
						Category category;
						if (categoryName.equals("")) {
							category = productsDAO.getProductById(id).getCategory();
						} else {
							category = categoryDAO.getAll().stream().filter(e -> e.getName().equals(categoryName)).findFirst().get();
						}
						productsDAO.update(id, new Product(name, price, amount, category));

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} while (choice != 0);
	}

	private void addProduct() {
		String name = view.getProductName();
		BigDecimal price = view.getPrice();
		int amount = view.getAmount();
		String categoryName = view.getCategoryName(categoryDAO);
		Category category = categoryDAO.getAll().stream().filter(e -> e.getName().equals(categoryName)).findFirst().get();
		productsDAO.add(new Product(name, price, amount, category));
	}

	private void delProduct() {
		int productId = view.getIdProduct(productsDAO);
		Product productToDelete = null;
		try {
			productToDelete = productsDAO.getProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		productsDAO.delete(productToDelete);
	}


	public void showProductByCategory(){
		String category = view.getCategoryName(categoryDAO);
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
