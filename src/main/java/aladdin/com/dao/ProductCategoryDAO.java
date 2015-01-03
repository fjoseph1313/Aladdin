package aladdin.com.dao;

import aladdin.com.model.Product;
import aladdin.com.model.ProductCategory;

public interface ProductCategoryDAO extends GenericDAO<ProductCategory, Long>
{
	
	public ProductCategory findProductCategoryByName(String Name);
}