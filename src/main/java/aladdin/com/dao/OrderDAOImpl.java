package aladdin.com.dao;


import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Order;

public class OrderDAOImpl extends HibernateDAO<Order, Long> implements OrderDAO
{
	public OrderDAOImpl()
	{
		super(Order.class);
	}
	
	public Order findByCustomerIdAndStatus(Long custid)
	{
		Query query = HibernateUtil.getSession().createQuery("FROM Order O");
		//query.setParameter("id", custid);
		return (Order) query.uniqueResult();
	}
}