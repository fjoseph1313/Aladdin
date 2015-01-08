package aladdin.com.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AladdinAspects {

	@After("execution(* *makePayment(..))")
	public void cartTableTrigger(JoinPoint joinPoint)
	{
		System.out.println("**********Cart optimization trigger has been executed*********"+joinPoint.getSignature());
		
	}
}
