package aladdin.com.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import aladdin.com.dao.CartDAO;
import aladdin.com.dao.CustomerDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.OrderDAO;
import aladdin.com.dao.PaymentDAO;
import aladdin.com.dao.ProductDAO;
import aladdin.com.dao.TransactionHistoryDAO;
import aladdin.com.model.Cart;
import aladdin.com.model.Order;
import aladdin.com.model.Payment;
import aladdin.com.model.Product;
import aladdin.com.model.TransactionHistory;

@Controller
public class OrderController {
	
	private DAOFactory daoFactory = DAOFactory.getFactory();
	OrderDAO orderDao = daoFactory.getOrderDAO();
	ProductDAO productDao = daoFactory.getProductDAO();
	CartDAO cartDao = daoFactory.getCartDAO();
	CustomerDAO custDao = daoFactory.getCustomerDAO();
	TransactionHistoryDAO histDao = daoFactory.getTransactionHistoryDAO();
	PaymentDAO payDao = daoFactory.getPaymentDAO();
	
	/*@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public String createOrder(@PathVariable Long id, @RequestParam("quantity") int qn, Model model )
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
		if(qn > fetchedProduct.getProductQuantity())
		{
			//return to productdetails page
			String forQuantity = "We dont have sufficient, choose less than "+fetchedProduct.getProductQuantity();
			model.addAttribute("lessQuantity", forQuantity);
			model.addAttribute("product", fetchedProduct);
			result = "productDetails";
		}
		else
		{
		
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
				model.addAttribute("currentOrder", existingOrder); //set this order into the session for checkout
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
				model.addAttribute("currentOrder", order); //set this order into the session for checkout
				model.addAttribute("currentOrderNew", cart); //set this order into the session for checkout
				orderDao.commitTransaction();
				//avoid duplicates on refresh
				qn = 0; cart = null; 
				
				result = "orderView";
			}
		}
		
		return result;
	}*/
	
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public String createOrder(@PathVariable Long id, @RequestParam("quantity") int qn, Model model, HttpServletRequest request )
	{
		//if cart exist in the session use it, if not, create new cart
		HttpSession session = request.getSession();
		List<Cart> currentCart = (List<Cart>) session.getAttribute("userCart");
		System.out.println("values in existing cart ............"+currentCart);
		
		if(currentCart == null)
		{
			ArrayList<Cart> newCart = new ArrayList<Cart>();
			cartDao.beginTransaction();
			Product fetchedProduct = (Product) productDao.findByPrimaryKey(id);
			System.out.println(fetchedProduct.getProductName());
			
			//**************************
			/*ArrayList inside = new ArrayList();
			inside.add(fetchedProduct);
			inside.add(qn);*/
			//**************************
			Cart cart = new Cart();
			cart.setProduct(fetchedProduct);
			//cart.setOrder(order); // we dont need order before user has logged in
			cart.setQuantity(qn);
			cartDao.save(cart); //persisting a cart item(product, quantity) in the database
			newCart.add(cart); //add this item into cart.
			
			//put the modified list into the session
			session.setAttribute("userCart", newCart);
			cartDao.commitTransaction();
			
			System.out.println("Cart value ================================"+newCart.size());
			System.out.println(fetchedProduct.getProductName());
			//System.out.println("Cart value item================================"+(newCart.get(0)).getProduct().getProductName());
		}
		else{
			cartDao.beginTransaction();
			Product fetchedProduct = (Product) productDao.findByPrimaryKey(id);
			Cart cart = new Cart();
			cart.setProduct(fetchedProduct);
			//cart.setOrder(order); // we dont need order before user has logged in
			cart.setQuantity(qn);
			cartDao.save(cart);
			currentCart.add(cart); //add this item into cart.
			//put the modified list into the session
			session.setAttribute("userCart", currentCart);
			cartDao.commitTransaction();
			
			System.out.println("Existing Cart value ============================"+currentCart.size());
			//System.out.println("Cart value item================================"+(currentCart.get(1)).getProduct().getProductName());
		}
		
		
		return "index";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String displayCart(Model model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List<Cart> currentCart = (List<Cart>) session.getAttribute("userCart");
		model.addAttribute("thisCart", currentCart); //this is the list of cart items.
		
		//System.out.println("first item is ============"+((Cart)currentCart.get(0)).getProduct().getProductName());
		//System.out.println("Second item is ============"+((Cart)currentCart.get(1)).getProduct().getProductQuantity());
		return "orderView";
	}
	
	
	@RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
	public String preparePayment(@PathVariable("id") Long id, Model model)
	{
		orderDao.beginTransaction();
		Order order = orderDao.findByPrimaryKey(id);
		model.addAttribute(order);
		orderDao.commitTransaction();
		return "cardDetails";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String makePayment(//@PathVariable Long id,
			@RequestParam("cardNumber") String card,
			@RequestParam("cvv") String cvv,
			@RequestParam("expireDt") String ex_dt,
			Model model)
	{
		System.out.println("this card is ++++++++++++++++++++++++++++++"+card);
		String message = "";
				
		Long custId = new Long(1);
		orderDao.beginTransaction();
		Order orderToPay = orderDao.findByCustomerIdAndStatus(custId); // get this customer's order which is still new, ready to pay
		//concatenate the input parameters
		String paymentDetails = card+cvv+ex_dt+orderToPay.getOrderAmount(); System.out.println(paymentDetails);
		
		RestTemplate restTemp = new RestTemplate();
		String url = "http://localhost:8080/Aladdin/paymentrest/{paymentDetails}";
		String result = restTemp.getForObject(url, String.class);
		
		if(result.equalsIgnoreCase("false"))
		{
			//return to the card details form..
			message = "Payment Rejected, Insufficient Amount..";
			model.addAttribute("errormessage", message);
			orderDao.commitTransaction();
			return "cardDetails";
		}
		else
		{
			//card details are correct and payment has been triggered.
			Payment newPayment = new Payment();
			newPayment.setOrder(orderToPay);
			newPayment.setPaymentAmount(orderToPay.getOrderAmount());
			newPayment.setPaymentType("VisaCard/MasterCard");
			payDao.save(newPayment); //persisting this payment.
			
			//change order status 
			orderToPay.setOrderStatus("closed");
			
			TransactionHistory history = new TransactionHistory();
			history.setTransactionDate(new Date());
			history.setPayment(newPayment);
			histDao.save(history); //saving transaction history.
			
			message = "Payment has been done successfully!";
			model.addAttribute("successmessage", message);
			orderDao.commitTransaction();
		}
		
		return "paymentComfirmation";
	}
	
	@RequestMapping(value = "/order/cancel/{id}", method = RequestMethod.GET)
	public String cancelOrder(@PathVariable Long id, Model model)
	{
		orderDao.beginTransaction();
		Order order = orderDao.findByPrimaryKey(id);
		//before deleting order, traverse all the carts and rollback product transactions.
		List<Cart> cartsInOrder = order.getCart();
		for(int i = 0; i < cartsInOrder.size(); i ++)
		{
			Cart thisCart = (Cart) cartsInOrder.get(i);
			Product thisProd = thisCart.getProduct();
			thisProd.setProductQuantity(thisProd.getProductQuantity() + thisCart.getQuantity()); //add back the selected quantity
			//save this current modified product in the database
			productDao.save(thisProd); //changes persisted.
		}
		
		orderDao.delete(order);
		orderDao.commitTransaction();
		return "index"; //cancelled order.. return to index and start new shopping
	}

}
