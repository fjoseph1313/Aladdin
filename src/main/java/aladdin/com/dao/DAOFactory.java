package aladdin.com.dao;

public abstract class DAOFactory
{
	public static final Class FACTORY_CLASS = HibernateDAOFactory.class;
	
	//public static final class FACTORY_CLASS = JDBCDAOFactory.class;
	//public static final class FACTORY_CLASS = JDODAOFactory.class;
	
	public static DAOFactory getFactory()
	{
		try
		{
			return (DAOFactory)FACTORY_CLASS.newInstance();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Couldn't create factory");
		}
	}
	
	public abstract AddressDAO getAddressDAO();
	public abstract PersonDAO getPersonDAO();
	public abstract VendorDAO getVendorDAO();
	public abstract CustomerDAO getCustomerDAO();
	public abstract ProductCategoryDAO getProductCategoryDAO();
	public abstract ProductDAO getProductDAO();
	public abstract OrderDAO getOrderDAO();
	public abstract CartDAO getCartDAO();
	public abstract TransactionHistoryDAO getTransactionHistoryDAO();
	public abstract PaymentDAO getPaymentDAO();
}