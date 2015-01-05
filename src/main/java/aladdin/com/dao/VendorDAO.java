package aladdin.com.dao;

import java.util.List;

import aladdin.com.model.Admin;
import aladdin.com.model.Vendor;

public interface VendorDAO extends GenericDAO<Vendor, Long>
{
	public List <Vendor> getVendorForApproval(Boolean flag);
	public boolean editVendor(Long id);
	public Vendor findVendorByEmail(String email);
}