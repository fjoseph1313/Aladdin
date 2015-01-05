package aladdin.com.model;

import javax.persistence.Entity;
	

@Entity
public class Admin extends Person {

	private String businessName;
	private float profitPercentage;
	
	public Admin() {
    }
	
	public Admin(String f, String l, String p, String e, String pass)
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

	@Override
	public String toString() {
		return "Admin [businessName=" + businessName + ", profitPercentage="
				+ profitPercentage + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getEmailAddress()=" + getEmailAddress()
				+ ", getPassword()=" + getPassword() + ", getIsActive()="
				+ getIsActive() + ", getAddress()=" + getAddress()
				+ ", getId()=" + getId() + ", getConfirmPassword()="
				+ getConfirmPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
