package aladdin.com;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import aladdin.com.model.*;

public class HibernateUtil 
{
	private static SessionFactory factory;
	
	public static Configuration getInitializedConfiguration()
	{
		Configuration config = new Configuration();
		//Bring all annotated class here you want to use.
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
		
		return config;
	}
	
	public static Session getSession()
	{
		if(factory == null)
		{
			Configuration config = HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		
		return hibernateSession;
	}
	
	public static void recreateDatabase()
	{
		Configuration config = HibernateUtil.getInitializedConfiguration(); //WE dont need session in creating schema, we need session in persisting
		new SchemaExport(config).create(true, true);
	}
	
	public static Session beginTransaction()
	{
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}
	
	public static void commitTransaction(){HibernateUtil.getSession().getTransaction().commit();}
	public static void rollbackTransaction(){HibernateUtil.getSession().getTransaction().rollback();}
	public static void closeSession(){HibernateUtil.getSession().close();}
	
	public static void main (String[] Args)
	{
		HibernateUtil.recreateDatabase();
	}
}