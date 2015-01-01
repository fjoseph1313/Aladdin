package aladdin.com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customer_order")
public class Order {

	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	private double orderAmount;
	private String orderStatus;
	private Date orderCreateDate;
	@ManyToOne
	private Customer customer; //maps to customer(one to many)
	@OneToMany(mappedBy = "order", targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cart> cart;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderCreateDate() {
		return orderCreateDate;
	}
	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
	
	
}
