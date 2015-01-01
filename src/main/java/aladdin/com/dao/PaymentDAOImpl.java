package aladdin.com.dao;

import aladdin.com.model.Payment;

public class PaymentDAOImpl extends HibernateDAO<Payment, Long> implements PaymentDAO
{
	public PaymentDAOImpl()
	{
		super(Payment.class);
	}
}