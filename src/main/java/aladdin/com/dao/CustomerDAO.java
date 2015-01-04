package aladdin.com.dao;

import java.util.List;

import aladdin.com.model.Customer;


public interface CustomerDAO extends GenericDAO<Customer, Long>
{
	public List <Customer> getCustomerForDisable(Boolean flag);
	public boolean editCustomer(Long id);
	
}