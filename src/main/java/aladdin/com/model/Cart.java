package aladdin.com.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	private int quantity;
	@ManyToOne
	private Order order;
	@ManyToOne
	private Product product;
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
