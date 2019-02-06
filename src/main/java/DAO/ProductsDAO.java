package DAO;

import Model.Category;
import Model.Feedback;
import Model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
    private SQLConnector sqlConnector;

    public ProductsDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    public List<Product> getAllProductsList() {

        sqlConnector.setResultSetByQuery("SELECT * FROM Products");
        List<Product> productList = new ArrayList<>();

        try {
            while (sqlConnector.getResultSet().next()) {
                productList.add(productByCurrentResultSet());
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Product product) {

    }

    public Product get(int index) {

        return null;
    }

    public void update(int index) {

    }

    public void del(int index) {

    }

    private Product productByCurrentResultSet() {
        ResultSet resultSet = sqlConnector.getResultSet();

        try {
            CategoryDAO categoryDAO = new CategoryDAO(sqlConnector);
            Category category = categoryDAO.getCategoryById(resultSet.getInt("CATEGORYID"));

            Product resultProduct = new Product(
                    resultSet.getString("NAME"),
                    resultSet.getBigDecimal("PRICE"),
                    resultSet.getInt("AMOUNT"),
                    category);

            return resultProduct;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
