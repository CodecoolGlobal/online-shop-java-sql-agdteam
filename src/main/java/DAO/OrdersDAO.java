package DAO;

import Model.Customer;
import Model.Order;
import Model.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO implements InterfaceDAO<Order> {
	private SQLConnector sqlConnector;

	public OrdersDAO(SQLConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}

	public List<Order> getAll(){

		sqlConnector.setResultSetByQuery("SELECT * FROM Orders " +
				"INNER JOIN Customer " +
				"ON Orders.ORDERID = Customer.ID");

		List<Order> ordersList = new ArrayList<>();

		try{
			while (sqlConnector.getResultSet().next()){
				ordersList.add(orderByCurrentResultSet());
			}
			return ordersList;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return ordersList;
	}

	public void createOrdersTable(){
		String createOrdersTable =
				"CREATE TABLE Orders(" +
						"ORDERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
						"CUSTOMERID INTEGER, " +
						"ORDERSTATUS VARCHAR, " +
						"ORDERCREATEDATE VARCHAR, " +
						"FOREIGN KEY (CUSTOMERID) REFERENCES Customer(ID)" +
						");";
		sqlConnector.executeUpdateOnDB(createOrdersTable);
	}


	public void add(Order order) {

		String addOrder =
				"INSERT INTO Orders (CUSTOMERID, ORDERSTATUS, ORDERCREATEDATE)" +
						"VALUES (" +
						"'" + order.getCustomer().getId() + "'," +
						"'" + order.getOrderStatus().toString() + "'," +
						"'" + order.getOrderCreateDate() + "'" +
						");";
		sqlConnector.executeUpdateOnDB(addOrder);
	}

	public void update(int index, Order updatedOrder) {
		String updateOrder =
				"UPDATE Orders SET" +
						" CUSTOMERID = " + updatedOrder.getCustomer().getId() + "," +
						" ORDERSTATUS = '" + updatedOrder.getOrderStatus().toString() + "," +
						" ORDERCREATEDATE = '" + updatedOrder.getOrderCreateDate().toString() +
						" WHERE ORDERID = " + String.valueOf(index) + ";";
		sqlConnector.executeUpdateOnDB(updateOrder);
	}

	public void delete(Order order) {
		String deleteOrder =
				"DELETE FROM Orders WHERE ORDERID = " +
					order.getId() + ";";
		sqlConnector.executeUpdateOnDB(deleteOrder);
	}

	private Order orderByCurrentResultSet() throws SQLException{
		ResultSet resultSet = sqlConnector.getResultSet();

		try{
			LocalDate orderCreatedDate = LocalDate.parse(resultSet.getString("ORDERCREATEDATE"));

			Customer resultCustomer = new Customer(
					resultSet.getInt("CUSTOMERID"),
					resultSet.getInt("ISADMIN"),
					resultSet.getString("LOGIN"),
					resultSet.getString("PASSWORD"),
					resultSet.getString("NAME")
			);

			OrderStatus resultStatus = OrderStatus.valueOf(resultSet.getString("ORDERSTATUS"));

			Order resultOrder = new Order(
					resultSet.getInt("ORDERID"),
					resultCustomer,
					resultStatus,
					orderCreatedDate
			);
			return resultOrder;
		} catch (SQLException e){
			e.printStackTrace();
		} throw new SQLException("DB Connection issue - Orders table");
	}

}
