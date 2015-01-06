package aladdin.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
	

@Entity
public class Vendor extends Person {

	private String businessName;
	private float profitPercentage;
	
	@OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Product.class)
	private List<Product> products;

	
	public Vendor() {
    }
	
	public Vendor(String f, String l, String p, String e, String pass)
	{
		super(f, l, p, e, pass);
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
