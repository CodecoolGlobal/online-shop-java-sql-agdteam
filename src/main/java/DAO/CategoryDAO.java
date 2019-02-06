package DAO;

import Model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private SQLConnector sqlConnector;

    public CategoryDAO(SQLConnector sqlConnector){
        this.sqlConnector = sqlConnector;
    }

    public List<Category> getAllCategoryList(){

        sqlConnector.setResultByQuery("SELECT * FROM Categories");
        List<Category> categoryList = new ArrayList<>();

        return categoryList;
    }

    public Category getCategoryById(int categoryId){
        String getByIdQuery = "SELECT * FROM Categories WHERE CATEGORYID = " + categoryId + ";";
        sqlConnector.setResultByQuery(getByIdQuery);
        return categoryByCurrentResultSet();

    }

    private Category categoryByCurrentResultSet(){
        ResultSet resultSet = sqlConnector.getResultSet();

        try {
            Category resultCategory = new Category(
                    resultSet.getInt("CATEGORYID"),
                    resultSet.getString("NAME"),
                    resultSet.getInt("ISAVAILABLE")
            );
            return resultCategory;
        } catch (SQLException e){
            e.printStackTrace();
        } return null;
    }
}
