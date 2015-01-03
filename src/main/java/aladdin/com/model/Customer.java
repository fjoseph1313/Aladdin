package aladdin.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity	
public class Customer extends Person{
	
	@OneToMany(mappedBy = "customer", targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> order;
	
	public Customer() {
		
    }
	
	public Customer(String f, String l, String p, String e, String pass)
	{
		super(f, l, p, e, pass);
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
}
