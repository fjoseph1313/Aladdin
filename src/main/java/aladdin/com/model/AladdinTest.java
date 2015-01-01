package aladdin.com.model;

/*import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;*/


import aladdin.com.dao.*;
//import aladdin.com.HibernateUtil;

public class AladdinTest
{
	public static void main(String[] Args)
	{
		/*AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(Customer.class);
		config.addAnnotatedClass(Vendor.class);
		config.addAnnotatedClass(ProductCategory.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Order.class);
		config.addAnnotatedClass(Cart.class);
		config.addAnnotatedClass(Payment.class);
		config.addAnnotatedClass(TransactionHistory.class);
		config.configure();
		new SchemaExport(config).create(true, true);*/
		
		ProductCategory pc = new ProductCategory();
		pc.setCategoryName("WShoes");
		pc.setCategoryDescription("Winter Shoes Temp below 25C");
		
		Product p = new Product();
		p.setProductName("Timberland");
		p.setProductDescription("Leather Shoes, soft interior");
		p.setPrice(new Double(24));
		p.setProductCategory(pc);
		
		DAOFactory factory = DAOFactory.getFactory();
		ProductCategoryDAO pcDao = factory.getProductCategoryDAO();
		ProductDAO pDao = factory.getProductDAO();
		
		pcDao.beginTransaction();
		pcDao.save(pc);
		pDao.save(p);
		pcDao.commitTransaction();
	}
}