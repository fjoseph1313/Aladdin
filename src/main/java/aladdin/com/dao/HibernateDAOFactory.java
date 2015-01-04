package aladdin.com.dao;

public class HibernateDAOFactory extends DAOFactory
{
	
	public AddressDAO getAddressDAO(){ return new AddressDAOImpl(); }
	public  PersonDAO getPersonDAO(){ return new PersonDAOImpl(); }
	public  VendorDAO getVendorDAO(){ return new VendorDAOImpl(); }
	public  CustomerDAO getCustomerDAO(){ return new CustomerDAOImpl(); }
	public  ProductCategoryDAO getProductCategoryDAO(){ return new ProductCategoryDAOImpl(); }
	public  ProductDAO getProductDAO(){ return new ProductDAOImpl(); }
	public  OrderDAO getOrderDAO(){ return new OrderDAOImpl(); }
	public  CartDAO getCartDAO(){ return new CartDAOImpl(); }
	public  TransactionHistoryDAO getTransactionHistoryDAO(){ return new TransactionHistoryDAOImpl(); }
	public  PaymentDAO getPaymentDAO(){ return new PaymentDAOImpl(); }
	public  UserRolesDAO getUserRolesDAO(){ return new UserRolesDAOImpl(); }
}