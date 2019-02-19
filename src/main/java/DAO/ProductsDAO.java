package DAO;

import Model.Category;
import Model.Feedback;
import Model.Product;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
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
        return getProducts();
    }

    public void add(Product product) {
        try {
            PreparedStatement myStmt = sqlConnector.getConnection()
                    .prepareStatement("INSERT INTO Products (NAME, PRICE, AMOUNT, CATEGORYID) VALUES (?,?,?,?);");
            myStmt.setString(1, product.getName());
            myStmt.setBigDecimal(2, product.getPrice());
            myStmt.setInt(3, product.getAmount());
            myStmt.setInt(4, product.getCategory().getId());

            myStmt.executeUpdate();
            sqlConnector.getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

    public Product getProductById(int productId) {

        try {
            PreparedStatement myStmt = sqlConnector.getConnection()
                    .prepareStatement("SELECT * FROM Products LEFT JOIN CATEGORIES ON " +
                                    "CATEGORIES.CATEGORYID = PRODUCTS.CATEGORYID WHERE PRODUCTID = ?");
            myStmt.setInt(1, productId);

            myStmt.executeQuery();
            sqlConnector.setResultSetByQuery(myStmt.toString());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productByCurrentResultSet();
    }


    public List<Product> getProductByCategory(int categoryID) {
        try {
            PreparedStatement myStmt = sqlConnector.getConnection()
                    .prepareStatement("SELECT * FROM Products WHERE categoryID =?");
            myStmt.setInt(1, categoryID);
            myStmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return getProducts();
    }


    private List<Product> getProducts() {
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


    public void update(int id, Product updatedProduct) {


        try{
            PreparedStatement myStmt = sqlConnector.getConnection()
                    .prepareStatement("UPDATE Products SET NAME = ?, PRICE = ?, AMOUNT = ?, CATEGORYID = ?, " +
                            "WHERE PRODUCTID = ?;");
            myStmt.setString(1, updatedProduct.getName());
            myStmt.setFloat(2, updatedProduct.getPrice().floatValue());
            myStmt.setInt(3, updatedProduct.getAmount());
            myStmt.setInt(4,updatedProduct.getCategory().getId());
            myStmt.setString(5,String.valueOf(id));

            myStmt.executeUpdate();
            sqlConnector.getConnection().commit();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void delete(Product product) {
        try{
            PreparedStatement myStmt = sqlConnector.getConnection()
            .prepareStatement("DELETE FROM Products WHERE PRODUCTID = ? ;");

            myStmt.setInt(1, product.getId());

            myStmt.executeUpdate();
            sqlConnector.getConnection().commit();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private Product productByCurrentResultSet() {
        ResultSet resultSet = sqlConnector.getResultSet();

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
