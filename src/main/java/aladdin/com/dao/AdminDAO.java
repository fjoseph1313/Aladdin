package aladdin.com.dao;

import aladdin.com.model.Admin;

public interface AdminDAO extends GenericDAO<Admin, Long>
{
	public Admin findAdminByEmail(String email);
	
}