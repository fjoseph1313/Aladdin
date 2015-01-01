package aladdin.com.dao;

import aladdin.com.model.Customer;

public class CustomerDAOImpl extends HibernateDAO<Customer, Long> implements CustomerDAO
{
	public CustomerDAOImpl()
	{
		super(Customer.class);
	}
}