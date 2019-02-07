package Model;

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


}
