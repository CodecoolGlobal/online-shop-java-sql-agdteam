package Model;

public class Customer {
    private int id;
    private boolean isAdmin;
    private String login;
    private String password;
    private String name;
    private Basket basket;

    public Customer(int isAdmin,
                    String login,
                    String password,
                    String name) {
        this.isAdmin = isAdmin == 1;
        this.login = login;
        this.password = password;
        this.name = name;
        this.basket = new Basket();
    }


    public Customer(int id,
                    int isAdmin,
                    String login,
                    String password,
                    String name) {
        this.id = id;
        this.isAdmin = isAdmin == 1;
        this.login = login;
        this.password = password;
        this.name = name;
        this.basket = new Basket();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean isAdmin() { return isAdmin; }
    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addToBasket(Product product, int amount) { basket.addProduct(product, amount); }
    public Basket getBasket() { return basket; }
    public void removeFromBasket(Product product) { basket.deleteProduct(product); }
    public void updateBasket(Basket basket) { this.basket = basket; }
    public void clearBasket() { basket = new Basket(); }

}