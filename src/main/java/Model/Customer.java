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
    private List<Feedback> feedback;
//TODO: konstruktor bez password
    public Customer(int id,
                    int isAdmin,
                    String login,
                    String password,
                    String name,
                    Basket basket,
                    List<Order> orders,
                    List<Feedback> feedback) {
        this.id = id;
        this.isAdmin = isAdmin == 1;
        this.login = login;
        this.password = password;
        this.name = name;
        this.basket = basket;
        this.orders = orders;
        this.feedback = feedback;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean getIsAdmin() { return isAdmin; }
    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public List<Feedback> getFeedback() { return feedback; }
    public void setFeedback(List<Feedback> feedback) { this.feedback = feedback; }

    public void addToBasket(Product product, int amount) { basket.addProduct(product, amount); }
    public Basket getBasket() { return basket; }
    public void removeFromBasket(Product product) { basket.deleteProduct(product); }
    public void updateBasket(Basket basket) { this.basket = basket; }
    public void clearBasket() { basket = new Basket(); }

    public void addFeedback(Feedback feedbackToAdd) { feedback.add(feedbackToAdd); }
}