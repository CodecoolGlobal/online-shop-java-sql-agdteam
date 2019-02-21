package Model;

import DAO.ProductsDAO;
import DAO.SQLConnector;

import java.math.BigDecimal;

public class OrderedItems {

    private int orderID;
    private int productID;
    private int quantity;
    private BigDecimal price;

    public OrderedItems(int orderID, int productID, int quantity, BigDecimal price) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
