package aladdin.com.dao;

import org.hibernate.Query;

import aladdin.com.HibernateUtil;
import aladdin.com.model.Admin;

public class AdminDAOImpl extends HibernateDAO<Admin, Long> implements AdminDAO
{
	public AdminDAOImpl()
	{
		super(Admin.class);
	}
	
	public Admin findAdminByEmail(String  email){
		Query query = HibernateUtil.getSession().createQuery("from Admin where emailAddress = :email");
		query.setParameter("email", email);		
		return (Admin) query.list().get(0);	
	}
	

}