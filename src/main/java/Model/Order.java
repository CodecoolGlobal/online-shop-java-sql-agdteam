package Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Order {
	private int id;
	private Basket basket;
	private Customer user;
	private OrderStatus orderStatus;
	private Date orderCreateAt;
	private Date orderPayAt;

	// Constructor for importing from database where id has been assigned
	public Order(int id, Basket basket, Customer user, OrderStatus orderStatus, Date orderCreateAt, Date orderPayAt) {
		this(basket, user, orderStatus);
		this.orderPayAt = orderPayAt;
		this.id = id;
	}

	// Constructor for creation of the new order
	public Order(Basket basket, Customer user, OrderStatus orderStatus) {
		this.basket = basket;
		this.user = user;
		this.orderStatus = orderStatus;
		orderCreateAt = getLocalDateInDateFormat();
	}

	public boolean pay() {
		orderPayAt = getLocalDateInDateFormat();
		return true;
	}

	private Date getLocalDateInDateFormat() {
		return Date.from(LocalDate
						.now()
						.atStartOfDay(ZoneId.systemDefault())
						.toInstant());
	}
}
