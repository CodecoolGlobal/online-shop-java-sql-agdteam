package Service;

import DAO.*;
import Model.*;
import View.View;
import View.ViewCustomer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static View.View.pause;

public class ServiceUtilityCustomer {
    private CustomerDAO customerDAO;
    private FeedbackDAO feedbackDAO;
    private OrdersDAO ordersDAO;
    private ProductsDAO productsDAO;
    private Customer customer;
    private ViewCustomer view;
    private OrderedItemsDAO orderedItemsDAO;

    public ServiceUtilityCustomer(CustomerDAO customerDAO, FeedbackDAO feedbackDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO, OrderedItemsDAO orderedItemsDAO, Customer customer, ViewCustomer view) {
        this.customerDAO = customerDAO;
        this.feedbackDAO = feedbackDAO;
        this.ordersDAO = ordersDAO;
        this.productsDAO = productsDAO;
        this.orderedItemsDAO = orderedItemsDAO;
        this.customer = customer;
        this.view = view;
    }

    void showBasket() {
        if (customer.isAnonymous()) {
            view.showPleaseLoginMessage();
        } else {
            List<Product> basketProducts = customer.getBasket().getProducts();
            if (basketProducts.size() == 0) {
                view.printString("Your basket is empty");
            }
            for (int i = 0; i < basketProducts.size(); i++) {
                view.printSingleProduct(basketProducts.get(i), i + 1);
            }
        }
    }

    void addProductToBasket() {
        if (customer.isAnonymous()) {
            view.showPleaseLoginMessage();
        } else {
            List<Product> allProducts = productsDAO.getAll();
            for (int i = 0; i < allProducts.size(); i++) {
                view.printSingleProduct(allProducts.get(i), i + 1);
            }
            int itemId = view.getIdOfItem(allProducts.size()) - 1;
            Product chosenProduct = allProducts.get(itemId);
            int totalAmount = chosenProduct.getAmount();
            int itemAmount = view.getAmountOfItem(chosenProduct.getAmount());
            customer.addToBasket(chosenProduct, itemAmount);
            Product updatedProduct = new Product(chosenProduct.getName(), chosenProduct.getPrice(), totalAmount - itemAmount, chosenProduct.getCategory());
            productsDAO.update(chosenProduct.getId(), updatedProduct);
        }
    }

    void placeOrder() {
        if (customer.isAnonymous()) {
            view.showPleaseLoginMessage();
        } else {
            ordersDAO.add(new Order(customer, OrderStatus.SUBMIT));
            customer.getBasket().getProducts().forEach((prod) -> orderedItemsDAO.add(prod));
            customer.getBasket().getProducts().clear();
            System.out.println("Your products have been ordered ");
            pause();
        }
    }

    public void showOrderHistory() throws SQLException {
        List<Integer> ordersNumbers = ordersDAO.getOrdersByUserID(customer);

        if(ordersNumbers.size()>0) {
            for (Integer orderIndex : ordersNumbers) {
                System.out.printf("\n***Zamówienie nr %d***\n", orderIndex);
                for (OrderedItems items : orderedItemsDAO.getOrderedItemsByOrderID(orderIndex)) {
                    String productName = productsDAO.getProductNameById(items.getOrderID());
                    view.printSingleOrderDetails(items, productName);
                }
            }
        }else {
            System.out.println("No orders!");
        }
    }

    public void crudBasket() {

    }

    public void rateProductsFromOrder() {

    }

}
