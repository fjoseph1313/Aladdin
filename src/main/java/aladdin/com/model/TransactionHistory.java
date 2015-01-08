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
	private double vendorProfit;
	private double myCompanyProfit;
	
	
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
	public double getVendorProfit() {
		return vendorProfit;
	}

	public void setVendorProfit(double vendorProfit) {
		this.vendorProfit = vendorProfit;
	}

	public double getMyCompanyProfit() {
		return myCompanyProfit;
	}

	public void setMyCompanyProfit(double myCompanyProfit) {
		this.myCompanyProfit = myCompanyProfit;
	}

}
