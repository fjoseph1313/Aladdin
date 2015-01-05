package aladdin.com.dao;

import javax.persistence.Query;

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
		Query query = (Query) HibernateUtil.getSession().createQuery("FROM Order or WHERE or.customer = :id and or.orderStatus = 'new'");
		query.setParameter("id", custid);
		return (Order) query.getSingleResult();
	}
}