package aladdin.com.dao;

import aladdin.com.model.Cart;

public interface CartDAO extends GenericDAO<Cart, Long>
{
	public int clearNullOrderCarts();
}