package aladdin.com.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class TransactionHistory {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date transactionDate;
	@OneToOne
	private Payment payment;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
