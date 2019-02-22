package DAO;

import Model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements InterfaceDAO<Category> {
	private SQLConnector sqlConnector;

	public CategoryDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Category> getAll() {

		sqlConnector.setResultSetByQuery("SELECT * FROM Categories");
		List<Category> categoryList = new ArrayList<>();

		try {
			while (sqlConnector.getResultSet().next()) {
				categoryList.add(categoryByCurrentResultSet());
			}
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	public Category getCategoryById(int categoryId) throws SQLException{
		String getByIdQuery = "SELECT * FROM Categories WHERE CATEGORYID = "
				+ categoryId + ";";
		sqlConnector.setResultSetByQuery(getByIdQuery);
		return categoryByCurrentResultSet();
	}

	public void update(int id, Category updatedCategory) {

	}

	public void add(Category category) {
		int isAvailable = category.isAvailable() ? 1 : 0;
		String addCategory =
				"INSERT INTO Categories (CATEGORYNAME, ISAVAILABLE) " +
						"VALUES (" +
						"'" + category.getName() + "'," +
						"'" + isAvailable + "'" +
						");";
		sqlConnector.executeUpdateOnDB(addCategory);
	}

	public void createCategoriesTable() {
		String createFeedbackTable =
				"CREATE TABLE Categories(" +
						"CATEGORYID INTEGER PRIMARY KEY AUTOINCREMENT," +
						"CATEGORYNAME VARCHAR," +
						"ISAVAILABLE INTEGER," +
						"EXPIRATIONDATE STRING" +
						");";
		sqlConnector.executeUpdateOnDB(createFeedbackTable);
	}

	public void delete(Category category) {
		String deleteCategory =
				"DELETE FROM Categories WHERE CATEGORYID = " +
						category.getId() + ";";
		sqlConnector.executeUpdateOnDB(deleteCategory);
	}

	private Category categoryByCurrentResultSet() throws SQLException{
		ResultSet resultSet = sqlConnector.getResultSet();
		Category resultCategory = new Category(
				resultSet.getInt("CATEGORYID"),
				resultSet.getString("CATEGORYNAME"),
				resultSet.getInt("ISAVAILABLE")
		);
		return resultCategory;
	}
}