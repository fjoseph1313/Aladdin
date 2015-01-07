package aladdin.com.dao;

import java.util.List;

import aladdin.com.model.Product;

public interface ProductDAO extends GenericDAO<Product, Long> {
	public Product findProductByIdCustom(Long id);
	public List<Product> findRandomProducts();
	public List<Product> findAllProductsByProductCategoryId(Long id);
}