package aladdin.com.dao;

import aladdin.com.model.Product;

public class ProductDAOImpl extends HibernateDAO<Product, Long> implements ProductDAO
{
	public ProductDAOImpl()
	{
		super(Product.class);
	}
}