package aladdin.com.dao;

import aladdin.com.model.Order;

public class OrderDAOImpl extends HibernateDAO<Order, Long> implements OrderDAO
{
	public OrderDAOImpl()
	{
		super(Order.class);
	}
}