package Model;

import java.math.BigDecimal;
import java.util.List;

public class Customer {
	private String name;
	private String login;
	private List<Basket> basketList;
	private boolean isAdmin;
	private List<Basket> orders;
	private List<Feedback> feedbackList;

	public Customer(String name, String login, List<Basket> basketList, boolean isAdmin, List<Basket> orders, List<Feedback> feedbackList) {
		this.name = name;
		this.login = login;
		this.basketList = basketList;
		this.isAdmin = isAdmin;
		this.orders = orders;
		this.feedbackList = feedbackList;
	}

	public void addToBasket(Product product) {

	}

	public Product getFromBasket(int index){

		return new Product("pan", new BigDecimal(123), 132, new Category("Category"));
	}

	public void del(int index) {

	}

	public void updateBasket(int index) { //todo where I find date to update

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Basket> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<Basket> basketList) {
		this.basketList = basketList;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public List<Basket> getOrders() {
		return orders;
	}

	public void setOrders(List<Basket> orders) {
		this.orders = orders;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
}
