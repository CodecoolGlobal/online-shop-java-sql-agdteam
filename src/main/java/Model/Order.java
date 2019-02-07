package Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Order {
	private int id;
	private Customer customer;
	private OrderStatus orderStatus;
	private LocalDate orderCreateDate;

	// Constructor for importing from database where id has been assigned
	public Order(int id, Customer user, OrderStatus orderStatus, LocalDate orderCreateDate) {
		this(user, orderStatus);
		this.id = id;
	}

	// Constructor for creation of the new order
	public Order(Customer user, OrderStatus orderStatus) {
		this.customer = user;
		this.orderStatus = orderStatus;
		orderCreateDate = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public LocalDate getOrderCreateDate() {
		return orderCreateDate;
	}
//	public boolean pay() {
//		orderPayAt = getLocalDateInDateFormat();
//		return true;
//	}

	private Date getLocalDateInDateFormat() {
		return Date.from(LocalDate
						.now()
						.atStartOfDay(ZoneId.systemDefault())
						.toInstant());
	}
}
