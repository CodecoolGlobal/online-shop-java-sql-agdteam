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

	// Constructor for first creation by Customer
	public Order(Basket basket, Customer user, OrderStatus orderStatus) {
		this.basket = basket;
		this.user = user;
		this.orderStatus = orderStatus;
		orderCreateAt = getLocalDateInDateFormat();
	}
	// Constructor for importing from DAO
	public Order(int id, Basket basket, Customer user, OrderStatus orderStatus, Date orderCreateAt, Date orderPayAt) {
		this(basket, user, orderStatus);
		this.orderPayAt = orderPayAt;
		this.id = id;
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
