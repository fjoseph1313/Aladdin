package aladdin.com.dao;

import aladdin.com.model.Vendor;

public class VendorDAOImpl extends HibernateDAO<Vendor, Long> implements VendorDAO
{
	public VendorDAOImpl()
	{
		super(Vendor.class);
	}
}