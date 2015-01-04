package aladdin.com.dao;

import aladdin.com.model.UserRoles;

public class UserRolesDAOImpl extends HibernateDAO<UserRoles, Long> implements UserRolesDAO
{
	public UserRolesDAOImpl()
	{
		super(UserRoles.class);
	}
}