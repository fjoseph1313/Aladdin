package aladdin.com.dao;

import java.util.List;

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

		String hql = "from Product vd join fetch vd.vendor u where "
				+ " vd.id=:id" + " and vd.activeState = '1'"
				// + " and u.id = 1 "
				+ " and u.enable='1'";

		// String hql = "SELECT P FROM Product P WHERE P.id=:id";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("id", id);
		Product results = (Product) query.uniqueResult();
		System.out.print(results.getProductName());
		return results;

	}

	@Override
	public List<Product> findAllProductsByProductCategoryId(Long id) {

		String hql = "from Product vd join fetch vd.vendor u where "
				+ " vd.productCategory.id = :id" + " and vd.activeState = '1'"
				// + " and u.id = 1 "
				+ " and u.enable='1'";

		// String hql =
		// "SELECT P FROM Product P WHERE P.productCategory.id = :id";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("id", id);
		List<Product> results = query.list();
		System.out.print(results);
		return results;
	}

	// String hql = "from Product vd join fetch vd.vendor u where "
	// + " vd.activeState = '1'"
	// //+ " and u.id = 1 "
	// + " and u.enable='1'"
	// + " ORDER BY RAND()";

	@Override
	public List<Product> findRandomProducts() {

		String hql = "from Product vd join fetch vd.vendor u where "
				+ " vd.activeState = '1'"
				// + " and u.id = 1 "
				+ " and u.enable='1'" + " ORDER BY RAND()";

		Query query = HibernateUtil.getSession().createQuery(hql);
		// query.setParameter("id", id);
		List<Product> results = query.setMaxResults(6).list();
		System.out.print(results);
		return results;

		// return null;
	}

}