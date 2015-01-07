package aladdin.com.dao;

import java.util.List;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Customer;

public class CustomerDAOImpl extends HibernateDAO<Customer, Long> implements CustomerDAO
{
	public CustomerDAOImpl()
	{
		super(Customer.class);
	}
	public List <Customer> getCustomerForDisable(Boolean flag){
		Query query = HibernateUtil.getSession().createQuery("from Customer where isActive = :id ");
		query.setParameter("id", flag);
		List<Customer> list = query.list();
		return list;	
	}
	
	public boolean editCustomer(Long id){
		Customer customer = (Customer) HibernateUtil.getSession().get(Customer.class, id);
		customer.setEnable(false);
		HibernateUtil.getSession().save(customer);
		return true;
	}
	
	public Customer findCustomerByEmail(String email){
		Query query = HibernateUtil.getSession().createQuery("from Customer where emailAddress = :email ");
		query.setParameter("email", email);
		return (Customer) query.list().get(0);			
	}
	
	
}