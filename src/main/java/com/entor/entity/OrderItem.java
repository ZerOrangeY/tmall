package com.entor.entity;

public class OrderItem {
	private int id;
	private Product product;
	private Order order;
	private User user;
	private int number;
	
	public OrderItem() {
		super();
	}
	public OrderItem(int id, Product product, Order order, User user, int number) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.user = user;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
