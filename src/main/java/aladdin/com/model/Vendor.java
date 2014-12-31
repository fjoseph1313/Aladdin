package aladdin.com.model;

import javax.persistence.Entity;
	

@Entity
public class Vendor extends Person {

	private String businessName;
	private float profitPercentage;
	
	public Vendor() {
    }
	
	public Vendor(Long id, String f, String l, String p, String e, String pass)
	{
		super(id, f, l, p, e, pass);
	}

	public String getBusinessName() {
		return businessName;
	}

	public float getProfitPercentage() {
		return profitPercentage;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setProfitPercentage(float profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

}
