package aladdin.com.dao;

import aladdin.com.model.Cart;

public class CartDAOImpl extends HibernateDAO<Cart, Long> implements CartDAO
{
	public CartDAOImpl()
	{
		super(Cart.class);
	}
}