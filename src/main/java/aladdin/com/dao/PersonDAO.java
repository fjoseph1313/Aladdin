package aladdin.com.dao;

import java.util.List;

import aladdin.com.model.Customer;
import aladdin.com.model.Person;
import aladdin.com.model.Product;

public interface PersonDAO extends GenericDAO<Person, Long>
{
	public List <Person> getPerson();
	public boolean activatePerson(Long id, Boolean flag);
}