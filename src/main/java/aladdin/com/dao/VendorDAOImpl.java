package aladdin.com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Vendor;

public class VendorDAOImpl extends HibernateDAO<Vendor, Long> implements VendorDAO
{
	public VendorDAOImpl()
	{
		super(Vendor.class);
	}
	
	public List <Vendor> getVendorForApproval(boolean flag){
		int xflag=0;
		if(flag)
			xflag=1;
		Query query = HibernateUtil.getSession().createQuery("from Vendor where isActive = :id ");
		query.setParameter("id", xflag);
		List<Vendor> list = query.list();
		return list;
		
	}
}