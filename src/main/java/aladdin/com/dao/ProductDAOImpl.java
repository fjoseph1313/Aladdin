package aladdin.com.dao;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Product;
import aladdin.com.model.ProductCategory;

public class ProductDAOImpl extends HibernateDAO<Product, Long> implements
		ProductDAO {
	public ProductDAOImpl() {
		super(Product.class);
	}

	@Override
	public Product findProductByIdCustom(Long id) {

		String hql = "SELECT P FROM Product P WHERE P.id=:id";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("id", id);
		Product results = (Product) query.uniqueResult();
		System.out.print(results.getProductName());
		return results;

	}

}