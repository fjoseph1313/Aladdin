package aladdin.com.controller;


import java.util.Date;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.*;
import aladdin.com.model.*;

public class OrderController {
	
	private DAOFactory daoFactory = DAOFactory.getFactory();
	OrderDAO orderDao = daoFactory.getOrderDAO();
	ProductDAO productDao = daoFactory.getProductDAO();
	CartDAO cartDao = daoFactory.getCartDAO();
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public String createOrder(@PathVariable Long id, Cart cart)
	{
		//get current logged in customer and create new order and find if its order still exists, else create new
		Long custId = new Long(1);
		String result = "index";
		orderDao.beginTransaction();
		Order existingOrder = orderDao.findByCustomerIdAndStatus(custId);
		Product fetchedProduct = (Product) productDao.findByPrimaryKey(id);
		
		if(existingOrder != null)
		{
			cart.setProduct(fetchedProduct);
			cart.setOrder(existingOrder);
			existingOrder.getCart().add(cart); //just for bidirectional association.
			cartDao.save(cart);
			
			existingOrder.setOrderAmount(existingOrder.getOrderAmount() + (fetchedProduct.getPrice() * cart.getQuantity()));
			existingOrder.setQuantity(existingOrder.getQuantity() + cart.getQuantity());
			
			orderDao.save(existingOrder); //persisting an updated order
			orderDao.commitTransaction();
			
			result = "viewOrder";
		}
		else{	
			Order order = new Order();
			order.setOrderCreateDate(new Date());
			order.setOrderAmount(fetchedProduct.getPrice() * cart.getQuantity());
			order.setQuantity(cart.getQuantity());
			//order.setCustomer(loggedInUser);
			order.setOrderStatus("new"); //assumption, on first creation, set status new.
			
			cart.setProduct(fetchedProduct);
			cart.setOrder(order);
			cartDao.save(cart);
			orderDao.save(order);
			orderDao.commitTransaction();
			
			result = "viewOrder";
		}
		
		
		return result;
	}

}
