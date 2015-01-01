package aladdin.com.dao;

import aladdin.com.model.TransactionHistory;

public class TransactionHistoryDAOImpl extends HibernateDAO<TransactionHistory, Long> implements TransactionHistoryDAO
{
	public TransactionHistoryDAOImpl()
	{
		super(TransactionHistory.class);
	}
}