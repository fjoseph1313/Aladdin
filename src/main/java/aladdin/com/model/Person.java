//C:\_mycode>java -cp "C:\_hiblib\*";C:\_mycode test.Person

package aladdin.com.model;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.AnnotationConfiguration;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String phoneNumber;
	private String emailAddress;
	private String password;
	@Embedded
	private Address address;
	
	public Person() {

	}
	
	public Person(Long id, String firstname, String lastname, String phoneNumber, String emailaddress, String password) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailaddress;
        this.password = password;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

}