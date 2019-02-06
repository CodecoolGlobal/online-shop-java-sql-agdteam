package DAO;

import Model.Category;
import Model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
	private SQLConnector sqlConnector;

	public ProductsDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Product> getListAll(){

		return new ArrayList<Product>();
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
}
