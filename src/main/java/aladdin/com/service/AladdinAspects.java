package aladdin.com.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import aladdin.com.dao.CartDAO;
import aladdin.com.dao.DAOFactory;

@Aspect
public class AladdinAspects {
	DAOFactory factory = DAOFactory.getFactory();
	CartDAO cartDao = factory.getCartDAO();

	@After("execution(* *makePayment*(..))")
	public void cartTableTrigger(JoinPoint joinPoint)
	{
		System.out.println("**********Cart optimization trigger has been executed*********"+joinPoint.getSignature());
		//call database delete method to delete carts with that doesnt belong to any order.
		/*cartDao.beginTransaction();
		int rows = cartDao.clearNullOrderCarts();
		cartDao.commitTransaction();
		System.out.println("Cart that has been deleted ..........."+rows);*/
	}
}
