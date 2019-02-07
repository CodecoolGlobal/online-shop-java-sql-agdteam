package DAO;

import Model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
	private SQLConnector sqlConnector;

	public OrdersDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Order> getListAll(){
		sqlConnector.setResultSetByQuery("SELECT * FROM Orders");
		List<Order> orderList = new ArrayList<>();
		try{
			while(sqlConnector.getResultSet().next()){
				orderList.add(orderByCurrentResultSet());
			}
		}catch (SQLException ex){
			ex.printStackTrace();
		}

		return orderList;
	}

	public void createTable(){
		String createTableSqlOrders =
				"CREATE TABLE Orders(" +
						"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
						"USER TEXT" +
						"ORDERSTATUS TEXT," +
						"ORDERCREATEAT TEXT," +
						"ORDERPAYAT INTEGER" +
						");";
//		executeUpdateAndCommit(createTableSqlOrders);
	}


	public void add(Order product) {

	}

	public Order get(int index) {

		return null;
	}

	public void update(int index) {

	}

	public void del(int index) {

	}

	private Order orderByCurrentResultSet(){
		ResultSet resultSet = sqlConnector.getResultSet();

		try{
			LocalDate createDate = LocalDate.parse(resultSet.getString("ORDERCREATEAT"));
			LocalDate payDate = LocalDate.parse(resultSet.getString("ORDERPAYAT"));
//
//			return  new Order(
//					resultSet.getInt("ID"),
//					null, //resultSet.getString("BASKET"),
//					null,//resultSet.getString("USER"),
//					null,//resultSet.getString("ORDERSTATUS"),
//					null,//createDate,
//					null//payDate
//			);

		}catch (SQLException  ex){
			ex.printStackTrace();
		}
		return  null;
	}

}
