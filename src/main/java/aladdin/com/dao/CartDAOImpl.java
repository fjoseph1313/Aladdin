package aladdin.com.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Cart;
import aladdin.com.model.Product;
import aladdin.com.model.Vendor;

public class CartDAOImpl extends HibernateDAO<Cart, Long> implements CartDAO {
	public CartDAOImpl() {
		super(Cart.class);
	}
	
	public int clearNullOrderCarts()
	{
		String hql = "FROM Cart ct WHERE ct.order == null";
		
		//String hql = "from Cart vd join fetch vd.order u where "
		//		+ " u.id is null" ;
		
		Query query = HibernateUtil.getSession().createQuery(hql);
		int rows = query.executeUpdate();
		return rows;
	}

	public List<Cart> findCartsByDates(Date fromDate, Date toDate) {
		System.out.println("===========FROM:"+fromDate.toString());
		System.out.println("===========TO:"+toDate.toString());
		String HQL = "FROM Cart ct WHERE ct.order.orderCreateDate > :fromDate AND ct.order.orderCreateDate < :toDate";
		Query query = HibernateUtil.getSession().createQuery(HQL);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		List<Cart> carts = query.list();
		System.out.println("===========VALUES:"+carts.size());
		return carts;
	}

	public List<Cart> findCartsByVendor(Vendor vendor) {
		String HQL = "FROM Cart ct WHERE ct.product.vendor = :vendor";
		Query query = HibernateUtil.getSession().createQuery(HQL);
		query.setParameter("vendor", vendor);
		List<Cart> carts = query.list();
		return carts;
	}

	public List<Cart> findCartsByVendorDates(Vendor vendor, Date fromDate,
			Date toDate) {
		String HQL = "FROM Cart ct WHERE ct.order.orderCreateDate > :fromDate AND ct.order.orderCreateDate < :toDate AND ct.product.vendor = :vendor";
		Query query = HibernateUtil.getSession().createQuery(HQL);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		query.setParameter("vendor", vendor);
		List<Cart> carts = query.list();
		return carts;
	}

}