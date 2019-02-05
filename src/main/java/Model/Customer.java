package Model;

import java.util.List;

public class Customer {
    private boolean isAdmin;
    private String login;
    private String name;
    private Basket basket;
    private List<Order> orders;
    private List<Feedback> feedbacks;

    public Customer(boolean isAdmin,
                    String login,
                    String name,
                    Basket basket,
                    List<Order> orders,
                    List<Feedback> feedbacks) {
        this.isAdmin = isAdmin;
        this.login = login;
        this.name = name;
        this.basket = basket;
        this.orders = orders;
        this.feedbacks = feedbacks;
    }

    // Getters & Setters
    public boolean getIsAdmin() { return isAdmin; }
    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

    // Basked CRUD
    public void addToBasket(Product product, int amount) { basket.addProduct(product, amount); }
    public Basket getBasket() { return basket; }
    public void removeFromBasket(Product product) { basket.deleteProduct(product); }
    public void updateBasket(Basket basket) { this.basket = basket; }
    public void clearBasket() { basket = new Basket(); }

    // Feedback
    public void addFeedback() {

    }
}