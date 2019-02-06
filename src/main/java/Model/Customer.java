package Model;

import java.util.List;

public class Customer {
    private int id;
    private boolean isAdmin;
    private String login;
    private String password;
    private String name;
    private Basket basket;
    private List<Order> orders;
    private List<Feedback> feedbacks;

    public Customer(int id,
                    int isAdmin,
                    String login,
                    String password,
                    String name,
                    Basket basket,
                    List<Order> orders,
                    List<Feedback> feedbacks) {
        this.id = id;
        this.isAdmin = isAdmin == 1;
        this.login = login;
        this.password = password;
        this.name = name;
        this.basket = basket;
        this.orders = orders;
        this.feedbacks = feedbacks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean getIsAdmin() { return isAdmin; }
    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPasswordt(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

    // Basket CRUD
    public void addToBasket(Product product, int amount) { basket.addProduct(product, amount); }
    public Basket getBasket() { return basket; }
    public void removeFromBasket(Product product) { basket.deleteProduct(product); }
    public void updateBasket(Basket basket) { this.basket = basket; }
    public void clearBasket() { basket = new Basket(); }

    // Feedback
    public void addFeedback(Feedback feedbackToAdd) { feedbacks.add(feedbackToAdd); }
}