package model;

import java.util.List;

import model.api.Date;

public class Order {
	private int orderId;
	private String userName;
	private List<OrderItem> listOrderItem;
	private Date date;
	private int status;

	public Order(int orderId, String userName, List<OrderItem> listOrderItem, int status) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.listOrderItem = listOrderItem;
		this.status = status;
	}

	public Order(int orderId, String userName, List<OrderItem> listOrderItem, Date date, int status) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.listOrderItem = listOrderItem;
		this.date = date;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<OrderItem> getListOrderItem() {
		return listOrderItem;
	}

	public void setListOrderItem(List<OrderItem> listOrderItem) {
		this.listOrderItem = listOrderItem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		int price = 0;
		for (OrderItem orderItem : listOrderItem) {
			price += orderItem.getProduct().getPrice() * orderItem.getQuanlity();
		}
		return price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userName=" + userName + ", listOrderItem=" + listOrderItem + ", date="
				+ date + ", status=" + status + "]";
	}

}