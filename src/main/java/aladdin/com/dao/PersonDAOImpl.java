package aladdin.com.dao;

import aladdin.com.model.Person;

public class PersonDAOImpl extends HibernateDAO<Person, Long> implements PersonDAO
{
	public PersonDAOImpl()
	{
		super(Person.class);
	}
}