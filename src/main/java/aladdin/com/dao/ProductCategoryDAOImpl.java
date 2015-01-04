package aladdin.com.dao;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.ProductCategory;

public class ProductCategoryDAOImpl extends HibernateDAO<ProductCategory, Long> implements ProductCategoryDAO
{
	public ProductCategoryDAOImpl()
	{
		super(ProductCategory.class);
	}

	@Override
	public ProductCategory findProductCategoryByName(String Name) {
		
		String hql = "SELECT P FROM ProductCategory P WHERE P.categoryName=:Name";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("Name", Name);
		ProductCategory results = (ProductCategory)query.uniqueResult();
		
		
		return results;
	}
}