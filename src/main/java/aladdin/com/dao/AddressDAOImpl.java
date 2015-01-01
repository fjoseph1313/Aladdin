package aladdin.com.dao;

import aladdin.com.model.Address;

public class AddressDAOImpl extends HibernateDAO<Address, Long> implements AddressDAO
{
	public AddressDAOImpl()
	{
		super(Address.class);
	}
}