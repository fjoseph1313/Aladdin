package aladdin.com.dao;

import java.util.List;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Person;

public class PersonDAOImpl extends HibernateDAO<Person, Long> implements PersonDAO
{
	public PersonDAOImpl()
	{
		super(Person.class);
	}
	public List <Person> getPerson(){
		Query query = HibernateUtil.getSession().createQuery("from Person p order by p.isActive asc");
		List<Person> list = query.list();
		return list;	
	}
	
	public boolean  activatePerson(Long id,Boolean flag){
		Person person = (Person) HibernateUtil.getSession().get(Person.class, id);
		person.setEnable(flag);
		HibernateUtil.getSession().save(person);
		return true;
	}
}