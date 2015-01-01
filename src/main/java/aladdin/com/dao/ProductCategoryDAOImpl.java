package aladdin.com.dao;

import aladdin.com.model.ProductCategory;

public class ProductCategoryDAOImpl extends HibernateDAO<ProductCategory, Long> implements ProductCategoryDAO
{
	public ProductCategoryDAOImpl()
	{
		super(ProductCategory.class);
	}
}