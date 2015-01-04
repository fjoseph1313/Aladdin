package aladdin.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity	
@Table(name="user_roles")
public class UserRoles {
	@Id
	@GeneratedValue
	private Long id;
	private String authority;
	@OneToOne
	private Person person;

	public UserRoles() {

	}

	public UserRoles(Long id, String authority, Person person) {
		this.id = id;
		this.authority = authority;
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}
