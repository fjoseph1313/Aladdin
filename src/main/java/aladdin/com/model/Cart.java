package aladdin.com.model;

import javax.persistence.*;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne
	private Product product;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
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
