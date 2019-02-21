package DAO;

import Model.Category;
import Model.Feedback;
import Model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO implements InterfaceDAO<Product> {
    private SQLConnector sqlConnector;

    public ProductsDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

    public List<Product> getAll() {

        sqlConnector.setResultSetByQuery("SELECT * FROM Products " +
                "INNER JOIN Categories " +
                "ON Products.CATEGORYID = Categories.CATEGORYID");
        List<Product> productList = new ArrayList<>();

        try {
            while (sqlConnector.getResultSet().next()) {
                productList.add(productByCurrentResultSet());
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void add(Product product) {
        String addProduct =
                "INSERT INTO Products (NAME, PRICE, AMOUNT, CATEGORYID) " +
                        "VALUES (" +
                        "'" + product.getName() + "'," +
                        "'" + product.getPrice() + "'," +
                        "'" + product.getAmount() + "'," +
                        "'" + product.getCategory().getId() + "'" +
                        ");";
        sqlConnector.executeUpdateOnDB(addProduct);
    }

    public void createProductsTable() {
        String createProductsTable =
                "CREATE TABLE Products(" +
                        "PRODUCTID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NAME VARCHAR," +
                        "PRICE REAL," +
                        "AMOUNT INTEGER," +
                        "CATEGORYID INTEGER," +
                        "FOREIGN KEY(CATEGORYID) REFERENCES Categories(CATEGORYID)" +
                        ");";
        sqlConnector.executeUpdateOnDB(createProductsTable);
    }

    public Product getProductById(int productId) throws SQLException{
            String getByIDQuery = "SELECT * FROM Products LEFT JOIN CATEGORIES" +
                    " ON CATEGORIES.CATEGORYID = PRODUCTS.CATEGORYID WHERE PRODUCTID = " +
                    productId + ";";
            sqlConnector.setResultSetByQuery(getByIDQuery);
            return productByCurrentResultSet();
    }


    public List<Product> getProductByCategory(int categoryID) {

        sqlConnector.setResultSetByQuery("SELECT * FROM Products WHERE categoryID =" + categoryID);
        List<Product> productList = new ArrayList<>();

        try {
            while (sqlConnector.getResultSet().next()) {
                productList.add(productByCurrentResultSet());
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public void update(int id, Product updatedProduct) {
        String updateProduct =
                "UPDATE Products SET" +
                        " NAME = '" + updatedProduct.getName() + "'," +
                        " PRICE = " + updatedProduct.getPrice().floatValue() + "," +
                        " AMOUNT = " + updatedProduct.getAmount() + "," +
                        " CATEGORYID = " + updatedProduct.getCategory().getId() +
                        " WHERE PRODUCTID = " + String.valueOf(id) + ";";
        sqlConnector.executeUpdateOnDB(updateProduct);
    }

    public void delete(Product product) {
        String deleteProduct =
                "DELETE FROM Products WHERE PRODUCTID = " +
                        product.getId() + ";";
        sqlConnector.executeUpdateOnDB(deleteProduct);
    }

    private Product productByCurrentResultSet() throws SQLException {
        ResultSet resultSet = sqlConnector.getResultSet();

            Category category =
                    new Category(resultSet.getInt("CATEGORYID"),
                            resultSet.getString("CATEGORYNAME"),
                            resultSet.getInt("ISAVAILABLE"));

            Product resultProduct = new Product(
                    resultSet.getInt("PRODUCTID"),
                    resultSet.getString("NAME"),
                    resultSet.getBigDecimal("PRICE"),
                    resultSet.getInt("AMOUNT"),
                    category);

            return resultProduct;
    }
}
