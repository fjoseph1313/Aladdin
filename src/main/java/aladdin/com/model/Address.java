package aladdin.com.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String state;
	private String city;
	private String zip;
	private String country;

	public Address() {

	}

	public Address(String street, String state, String city, String zip,
			String country) {
		super();
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
