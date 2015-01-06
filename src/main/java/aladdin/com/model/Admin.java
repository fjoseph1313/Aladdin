package aladdin.com.model;

import javax.persistence.Entity;
	

@Entity
public class Admin extends Person {

	
	public Admin() {
    }
	
	public Admin(String f, String l, String p, String e, String pass)
	{
		super(f, l, p, e, pass);
	}




	
	

}
