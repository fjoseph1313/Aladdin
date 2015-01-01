package aladdin.com.model;

import javax.persistence.*;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long id;
	private double paymentAmount;
	private String paymentType;
	@OneToOne
	//@Column(name = "payment_order")
	private Order order;
	//private TransactionHistory history;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/*public TransactionHistory getHistory() {
		return history;
	}

	public void setHistory(TransactionHistory history) {
		this.history = history;
	}*/
	
	

}
