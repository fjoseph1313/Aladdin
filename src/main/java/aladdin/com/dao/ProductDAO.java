package aladdin.com.dao;

import aladdin.com.model.Product;

public interface ProductDAO extends GenericDAO<Product, Long>
{
	public Product findProductByIdCustom(Long id);
}