package aladdin.com.dao;

import aladdin.com.model.Order;

public interface OrderDAO extends GenericDAO<Order, Long>
{
	
	public Order findByCustomerIdAndStatus(Long custid);
}