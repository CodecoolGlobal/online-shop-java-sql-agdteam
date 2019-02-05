package Model;

import java.util.Date;

public class Order {
	private int id;
	private Basket basket;
	private Customer user;
	private Date orderCreateAt;
	private OrderStatus orderStatus;
	private Date orderPayAt;

	public boolean pay() {
		return false;
	}
}
