package aladdin.com.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aladdin.com.dao.*;
import aladdin.com.model.Cart;
import aladdin.com.model.Customer;
import aladdin.com.model.Order;
import aladdin.com.model.Product;

@Controller
public class OrderController {
	
	private DAOFactory daoFactory = DAOFactory.getFactory();
	OrderDAO orderDao = daoFactory.getOrderDAO();
	ProductDAO productDao = daoFactory.getProductDAO();
	CartDAO cartDao = daoFactory.getCartDAO();
	CustomerDAO custDao = daoFactory.getCustomerDAO();
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public String createOrder(@PathVariable Long id, @RequestParam("quantity") int qn )
	{
		//get current logged in customer and create new order and find if its order still exists, else create new
		Long custId = new Long(1);
		String result = "index";
		orderDao.beginTransaction();
		Order existingOrder = orderDao.findByCustomerIdAndStatus(custId);
		Product fetchedProduct = (Product) productDao.findByPrimaryKey(id);
		Customer fetchedCustomer = (Customer) custDao.findByPrimaryKey(custId);
		
		//we should check the quntity entered by customer is less than available copies.
		System.out.println("selected quantity is ***************************: "+qn);
		
		Cart cart = new Cart(); //creating new cart
		
		if(existingOrder != null) //qn must be less than stock quantity
		{
			//update fetchedproduct in quantity and 
			fetchedProduct.setProductQuantity(fetchedProduct.getProductQuantity() - qn);
			productDao.save(fetchedProduct);//update changes to product
			
			cart.setProduct(fetchedProduct);
			cart.setQuantity(qn);
			cart.setOrder(existingOrder);
			existingOrder.getCart().add(cart); //just for bidirectional association.
			cartDao.save(cart);
			
			existingOrder.setOrderAmount(existingOrder.getOrderAmount() + (fetchedProduct.getPrice() * cart.getQuantity()));
			existingOrder.setQuantity(existingOrder.getQuantity() + cart.getQuantity());
			
			orderDao.save(existingOrder); //persisting an updated order
			orderDao.commitTransaction();
			
			result = "orderView";
		}
		else{	
			Order order = new Order();
			order.setCustomer(fetchedCustomer); //this must be the loggedIn customer
			//must populate cart first before order.
			cart.setProduct(fetchedProduct);
			cart.setOrder(order);
			cart.setQuantity(qn);
			
			//update fetchedproduct in quantity and 
			fetchedProduct.setProductQuantity(fetchedProduct.getProductQuantity() - qn);
			productDao.save(fetchedProduct);//update changes to product
						
			order.setOrderCreateDate(new Date());
			order.setOrderAmount(fetchedProduct.getPrice() * cart.getQuantity());
			System.out.println("order amt is : =======new order======="+ fetchedProduct.getPrice() * cart.getQuantity());
			order.setQuantity(cart.getQuantity());
			order.setOrderStatus("new"); //assumption, on first creation, set status new.
			
			cartDao.save(cart);
			orderDao.save(order);
			orderDao.commitTransaction();
			
			result = "orderView";
		}
		
		
		return result;
	}

}
