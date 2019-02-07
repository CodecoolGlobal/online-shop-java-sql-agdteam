package DAO;

import Model.Order;
import Model.OrderedItems;
import Model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedItemsDAO {

    private SQLConnector sqlConnector;

    public OrderedItemsDAO(SQLConnector sqlConnector){
        this.sqlConnector = sqlConnector;
    }

    public void createOrderedItemsTable(){
        String createOITable =
                "CREATE TABLE OrderedItems(" +
                        "OrderID INTEGER, " +
                        "ProductID INTEGER, " +
                        "Quantity INTEGER, " +
                        "Price REAL," +
                        "FOREIGN KEY (OrderID) references Orders(OrderID), " +
                        "FOREIGN KEY (ProductID) references Products(ProductID)," +
                        "PRIMARY KEY (OrderID, ProductID) )";
        sqlConnector.executeUpdateOnDB(createOITable);

    }

    public List<OrderedItems> getAll() {

        sqlConnector.setResultSetByQuery("SELECT * FROM OrderedItems");

        List<OrderedItems> orderedItems = new ArrayList<>();

        try{
            while (sqlConnector.getResultSet().next()){
                orderedItems.add(orderByCurrentResultSet());
            }
            return orderedItems;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void add(Product product) {

            sqlConnector.setResultSetByQuery("SELECT * FROM Orders " +
                    "ORDER BY ORDERID DESC LIMIT 1;");

            ResultSet resultSet = sqlConnector.getResultSet();

        try {

            Integer orderID = 1;
            if (resultSet!=null){
                orderID = resultSet.getInt("ORDERID");
            }
            String addProduct =
                    "INSERT INTO OrderedItems (OrderID, ProductID, Quantity, Price) " +
                            "VALUES (" +
                            "'" + orderID + "'," +
                            "'" + product.getId() + "'," +
                            "'" + product.getAmount() + "'," +
                            "'" + (product.getPrice().multiply(new BigDecimal(product.getAmount())) ) + "'" +
                            ");";
            sqlConnector.executeUpdateOnDB(addProduct);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void delete(OrderedItems instance) {

    }

    public void update(int id, OrderedItems instance) {

    }

    private OrderedItems orderByCurrentResultSet(){
        ResultSet resultSet = sqlConnector.getResultSet();

        try{
            return new OrderedItems(
                    resultSet.getInt("OrderId"),
                    resultSet.getInt("ProductID"),
                    resultSet.getInt("Quantity"),
                    resultSet.getBigDecimal("Price")
            );
        } catch (SQLException e){
            e.printStackTrace();
        } return null;
    }
}
