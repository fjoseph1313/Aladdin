package aladdin.com.dao;

import java.util.List;



import org.hibernate.Query;



import aladdin.com.HibernateUtil;
import aladdin.com.model.Admin;
import aladdin.com.model.Vendor;

public class VendorDAOImpl extends HibernateDAO<Vendor, Long> implements VendorDAO
{
	public VendorDAOImpl()
	{
		super(Vendor.class);
	}
	
	public List <Vendor> getVendorForApproval(Boolean flag){
		Query query = HibernateUtil.getSession().createQuery("from Vendor where isActive = :id ");
		query.setParameter("id", flag);
		List<Vendor> list = query.list();
		return list;	
	}
	
	public boolean editVendor(Long id){
		Vendor vendor = (Vendor) HibernateUtil.getSession().get(Vendor.class, id);
		vendor.setIsActive(true);
		HibernateUtil.getSession().save(vendor);
		return true;
	}
	
	public Vendor findVendorByEmail(String  email){
		Query query = HibernateUtil.getSession().createQuery("from Vendor where emailAddress = :email");
		query.setParameter("email", email);		
		return (Vendor) query.list().get(0);	
	}	
	
}