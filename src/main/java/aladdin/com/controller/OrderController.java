package aladdin.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import aladdin.com.MailMail;
import aladdin.com.dao.CartDAO;
import aladdin.com.dao.CustomerDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.OrderDAO;
import aladdin.com.dao.PaymentDAO;
import aladdin.com.dao.ProductDAO;
import aladdin.com.dao.TransactionHistoryDAO;
import aladdin.com.model.Address;
import aladdin.com.model.Cart;
import aladdin.com.model.Customer;
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

	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public String createOrder(@PathVariable Long id,
			@RequestParam("quantity") int qn, Model model,
			HttpServletRequest request) {
		// if cart exist in the session use it, if not, create new cart
		HttpSession session = request.getSession();
		List<Cart> currentCart = (List<Cart>) session.getAttribute("userCart");
		System.out
				.println("values in existing cart ............" + currentCart);
		String result = "index";
		cartDao.beginTransaction();
		Product fetchedProduct = (Product) productDao.findByPrimaryKey(id);

		// before adding to cart check if the products has enough quantities
		if (qn > fetchedProduct.getProductQuantity()) {
			// return to productdetails page
			String forQuantity = "We dont have sufficient, choose less than "
					+ fetchedProduct.getProductQuantity();
			model.addAttribute("lessQuantity", forQuantity);
			model.addAttribute("product", fetchedProduct);

			cartDao.commitTransaction(); // before any return, commit hibernate
											// sessions.
			result = "productDetails";
		} else {

			if (currentCart == null) {
				ArrayList<Cart> newCart = new ArrayList<Cart>();

				System.out.println(fetchedProduct.getProductName());

				Cart cart = new Cart();
				cart.setProduct(fetchedProduct);
				fetchedProduct.getCart().add(cart);
				// cart.setOrder(order); // we dont need order before user has
				// logged in
				cart.setQuantity(qn);
				newCart.add(cart); // add this item into cart.

				// put the modified list into the session
				session.setAttribute("userCart", newCart);
				cartDao.commitTransaction();

				System.out
						.println("Cart value ================================"
								+ newCart.size());
				System.out.println(fetchedProduct.getProductName());
				// System.out.println("Cart value item================================"+(newCart.get(0)).getProduct().getProductName());
			} else {
				Cart cart = new Cart();
				cart.setProduct(fetchedProduct);
				// cart.setOrder(order); // we dont need order before user has
				// logged in
				cart.setQuantity(qn);
				fetchedProduct.getCart().add(cart);
				currentCart.add(cart); // add this item into cart.
				// put the modified list into the session
				session.setAttribute("userCart", currentCart);
				cartDao.commitTransaction();

				System.out
						.println("Existing Cart value ============================"
								+ currentCart.size());
				// System.out.println("Cart value item================================"+(currentCart.get(1)).getProduct().getProductName());
			}

		}

		return "redirect:/";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String displayCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Cart> currentCart = (List<Cart>) session.getAttribute("userCart");
		// send total quantity and total amount to be paid
		double amt = 0;
		int qua = 0;
		for (int i = 0; i < currentCart.size(); i++) {
			qua += currentCart.get(i).getQuantity();
			amt += currentCart.get(i).getQuantity()
					* currentCart.get(i).getProduct().getPrice();
		}
		model.addAttribute("orderQuantity", qua);
		model.addAttribute("orderAmount", amt);
		model.addAttribute("thisCart", currentCart); // this is the list of cart
														// items.

		System.out.println("first item is ============"
				+ ((Cart) currentCart.get(0)).getProduct().getProductName());
		// System.out.println("Second item is ============"+((Cart)currentCart.get(1)).getProduct().getProductQuantity());
		return "orderView";
	}

	// Dispatcher, Registered Customer or Guest Customer
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String preparePayment(Model model) {
		return "cardDetails";
	}

	@RequestMapping(value = "/guestCheckout", method = RequestMethod.GET)
	public String prepareGuestCheckout(Model model) {
		return "guestCheckout";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String makePayment(
	/* @PathVariable Long id, */HttpServletRequest request,
			@RequestParam("cardNumber") String card,
			@RequestParam("cvv") String cvv,
			@RequestParam("expireDt") String ex_dt, Model model) {

		System.out
				.println("this card is ++++++++++++++++++++++++++++++" + card);
		Order order = new Order();
		String message = "";
		HttpSession session = request.getSession();
		List<Cart> currCart = (List<Cart>) session.getAttribute("userCart");
		Customer loggedInCustomer = (Customer) session
				.getAttribute("userDetails");
		System.out.println("User logged in is ////////////////////////////////"
				+ loggedInCustomer.getFirstName());

		// Product quantity stock management
		List<Cart> currentCart = this.updateProductQuantity(currCart); // this
																		// work
																		// when
																		// we
																		// have
																		// one
																		// product
																		// selected
																		// once
		model.addAttribute("purchasedItem", currentCart);
		orderDao.beginTransaction(); // remember to close this session before
										// method termination

		// profit percentage computation
		int ordQuant = 0;
		double amt = 0;
		double vendorProf = 0;
		double myCompanyProf = 0;

		for (int i = 0; i < currentCart.size(); i++) {
			ordQuant += currentCart.get(i).getQuantity();
			amt += currentCart.get(i).getQuantity()
					* currentCart.get(i).getProduct().getPrice();

			// for every product, calculate profit
			double totalProf = (currentCart.get(i).getProduct().getPrice() - (currentCart
					.get(i).getProduct().getPrice() * 0.8))
					* currentCart.get(i).getQuantity();
			System.out.println("total profit for item "
					+ currentCart.get(i).getQuantity() + " ==== " + totalProf);
			double myCompPr = (currentCart.get(i).getProduct().getVendor()
					.getProfitPercentage() / 100)
					* totalProf;
			vendorProf += myCompPr;
			myCompanyProf += (totalProf - myCompPr);
		}

		// concatenate the input parameters
		String paymentDetails = card + cvv + ex_dt + amt;
		System.out.println("Path Variable +++++++++" + paymentDetails);

		// Consuming restful webservice....
		String result = this.callRestfulness(paymentDetails);

		if (result.equalsIgnoreCase("false")) {
			// return to the card details form..
			message = "Payment Rejected, Either Information provided was wrong or you have Insufficient Amount..";
			model.addAttribute("errormessage", message);
			orderDao.commitTransaction();
			return "cardDetails";
		} else {
			// now create order and populate it with the cart.
			// Order order = new Order();
			order.setCart(currentCart); // a cart must exist in the session to
										// be persisted..
			order.setOrderCreateDate(new Date());
			order.setOrderStatus("completed");
			order.setQuantity(ordQuant);
			order.setOrderAmount(amt);
			order.setCustomer(loggedInCustomer);
			orderDao.save(order); // saving the current order since payment has
									// been done...

			// card details are correct and payment has been triggered.
			Payment newPayment = new Payment();
			newPayment.setOrder(order);
			newPayment.setPaymentAmount(order.getOrderAmount());
			newPayment.setPaymentType("VisaCard/MasterCard");
			payDao.save(newPayment); // persisting this payment.

			// change order status
			// order.setOrderStatus("closed");

			/*
			 * Calculation on profit and store it on the transaction table...
			 * traversing on all products on the order and calculate the profit
			 * this could be done above! Should persist carts from this order
			 */
			for (int j = 0; j < currentCart.size(); j++) {
				Cart cart = new Cart();
				cart.setProduct(currentCart.get(j).getProduct());
				cart.setQuantity(currentCart.get(j).getQuantity());
				cart.setOrder(order);
				cartDao.save(cart);

			}

			TransactionHistory history = new TransactionHistory();
			history.setTransactionDate(new Date());
			history.setPayment(newPayment);
			history.setVendorProfit(vendorProf);
			history.setMyCompanyProfit(myCompanyProf);
			histDao.save(history); // saving transaction history.

			message = "Payment has been done successfully!";
			model.addAttribute("successmessage", message);
			model.addAttribute("paidOrder", order);
			orderDao.commitTransaction();

			// resert cart to null
			currentCart = null;
			session.setAttribute("userCart", currentCart);
		}

		String fullName = order.getCustomer().getFirstName() + " "
				+ order.getCustomer().getLastName();
		String customerEmailAddress = order.getCustomer().getEmailAddress();

		String emailSubject = "Customer Reciept";
		String emailBody = "Hi " + fullName + ",\n\n" + "Your Order Id "
				+ order.getId() + "\n\n" + "Your Order Amount "
				+ order.getOrderAmount() + "\n\n"
				+ "Your Item will be delivered in 7 days"
				+ "\nThanks for using Aladdin";

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("Aladdin <aladdin.mscs@gmail.com>", customerEmailAddress,
				"aladdin.mscs@gmail.com", emailSubject, emailBody);

		return "paymentComfirmation";
	}

	@RequestMapping(value = "/guestpayment", method = RequestMethod.POST)
	public String makePaymentGuest(
	/* @PathVariable Long id, */HttpServletRequest request,
			@RequestParam("cardNumber") String card,
			@RequestParam("cvv") String cvv,
			@RequestParam("expireDt") String ex_dt,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("emailAddress") String emailAddress,
			@RequestParam("state") String state,
			@RequestParam("street") String street,
			@RequestParam("city") String city, @RequestParam("zip") String zip,
			@RequestParam("country") String country, Model model) {

		String message = "";
		Order order = new Order();
		HttpSession session = request.getSession();
		List<Cart> currCart = (List<Cart>) session.getAttribute("userCart");

		// Product quantity stock management
		List<Cart> currentCart = this.updateProductQuantity(currCart); // this
																		// work
																		// when
																		// we
																		// have
																		// one
																		// product
																		// selected
																		// once
		model.addAttribute("purchasedItem", currentCart);
		orderDao.beginTransaction(); // remember to close this session before
										// method termination

		// get guest customer information and persist in database...
		Customer guest = new Customer();
		Address guestAdd = new Address();
		guestAdd.setCity(city);
		guestAdd.setCountry(country);
		guestAdd.setState(state);
		guestAdd.setStreet(street);
		guestAdd.setZip(zip);
		guest.setEmailAddress(emailAddress);

		guest.setFirstName(firstName);
		guest.setLastName(lastName);
		guest.setEmailAddress(emailAddress);
		guest.setAddress(guestAdd); // add address to this guest customer
		custDao.save(guest); // guest info peristed. but cant login...

		// profit percentage computation
		int ordQuant = 0;
		double amt = 0;
		double vendorProf = 0;
		double myCompanyProf = 0;

		for (int i = 0; i < currentCart.size(); i++) {
			ordQuant += currentCart.get(i).getQuantity();
			amt += currentCart.get(i).getQuantity()
					* currentCart.get(i).getProduct().getPrice();

			// for every product, calculate profit
			double totalProf = (currentCart.get(i).getProduct().getPrice() - (currentCart
					.get(i).getProduct().getPrice() * 0.8))
					* currentCart.get(i).getQuantity();
			System.out.println("total profit for item "
					+ currentCart.get(i).getQuantity() + " ==== " + totalProf);
			double myCompPr = (currentCart.get(i).getProduct().getVendor()
					.getProfitPercentage() / 100)
					* totalProf;
			vendorProf += myCompPr;
			myCompanyProf += (totalProf - myCompPr);
		}

		// concatenate the input parameters
		String paymentDetails = card + cvv + ex_dt + amt;
		System.out.println("Path Variable +++++++++" + paymentDetails);

		// Consuming restful webservice....
		String result = this.callRestfulness(paymentDetails);

		if (result.equalsIgnoreCase("false")) {
			// return to the card details form..
			message = "Payment Rejected, Either Information provided was wrong or you have Insufficient Amount..";
			model.addAttribute("errormessage", message);
			orderDao.commitTransaction();
			return "guestCheckout";
		} else {
			// now create order and populate it with the cart.
			// Order order = new Order();
			order.setCart(currentCart); // a cart must exist in the session to
										// be persisted..
			order.setOrderCreateDate(new Date());
			order.setOrderStatus("completed");
			order.setQuantity(ordQuant);
			order.setOrderAmount(amt);
			order.setCustomer(guest); // this order is for the guest
			orderDao.save(order); // saving the current order since payment has
									// been done...

			// card details are correct and payment has been triggered.
			Payment newPayment = new Payment();
			newPayment.setOrder(order);
			newPayment.setPaymentAmount(order.getOrderAmount());
			newPayment.setPaymentType("VisaCard/MasterCard");
			payDao.save(newPayment); // persisting this payment.

			// change order status
			// order.setOrderStatus("closed");

			/*
			 * Calculation on profit and store it on the transaction table...
			 * traversing on all products on the order and calculate the profit
			 * this could be done above! Should persist carts from this order
			 */
			for (int j = 0; j < currentCart.size(); j++) {
				Cart cart = new Cart();
				cart.setProduct(currentCart.get(j).getProduct());
				cart.setQuantity(currentCart.get(j).getQuantity());
				cart.setOrder(order);
				cartDao.save(cart);

			}

			TransactionHistory history = new TransactionHistory();
			history.setTransactionDate(new Date());
			history.setPayment(newPayment);
			history.setVendorProfit(vendorProf);
			history.setMyCompanyProfit(myCompanyProf);
			histDao.save(history); // saving transaction history.

			message = "Payment has been done successfully!";
			model.addAttribute("successmessage", message);
			model.addAttribute("paidOrder", order);
			orderDao.commitTransaction();

			// resert cart to null
			currentCart = null;
			session.setAttribute("userCart", currentCart);
		}

		String fullName = order.getCustomer().getFirstName() + " "
				+ order.getCustomer().getLastName();
		String customerEmailAddress = order.getCustomer().getEmailAddress();

		String emailSubject = "Customer Reciept";
		String emailBody = "Hi " + fullName + ",\n\n" + "Your Order Id "
				+ order.getId() + "\n\n" + "Your Order Amount "
				+ order.getOrderAmount() + "\n\n"
				+ "Your Item will be delivered in 7 days"
				+ "\nThanks for using Aladdin";

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("Aladdin <aladdin.mscs@gmail.com>", customerEmailAddress,
				"aladdin.mscs@gmail.com", emailSubject, emailBody);

		return "paymentComfirmation";
	}

	@RequestMapping(value = "/order/cancel", method = RequestMethod.GET)
	public String cancelOrder(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<Cart> currentCart = (List<Cart>) session.getAttribute("userCart");
		currentCart = null;
		session.setAttribute("userCart", currentCart);

		return "index";
	}

	// stock Manager
	public List<Cart> updateProductQuantity(List<Cart> cartList) {
		for (int k = 0; k < cartList.size(); k++) {
			productDao.beginTransaction();
			Product prod = cartList.get(k).getProduct();
			Product prod1 = productDao.findByPrimaryKey(prod.getId()); // fetch
																		// new
																		// object
																		// from
																		// database,
																		// prod
																		// is in
																		// memory
																		// not
																		// changing

			int prodQuant = prod1.getProductQuantity();
			System.out.println("Quantity now is ......" + prodQuant);
			if (cartList.get(k).getQuantity() > prodQuant) {
				System.out.println(cartList.get(k).getQuantity()
						+ "quantities are -" + prodQuant);
				// return false; //instead of returning false, update the
				// current quantity to this
				cartList.get(k).setQuantity(prodQuant);
				prod1.setProductQuantity(0); // if we purchased all then new
												// stock quantity is zero
				productDao.save(prod1);
			} else {
				System.out.println(cartList.get(k).getQuantity()
						+ "quantities are -" + prodQuant);
				prod1.setProductQuantity(prodQuant
						- cartList.get(k).getQuantity());
				productDao.save(prod1);
			}
			productDao.commitTransaction();
		}

		return cartList;
	}

	// restfulness alertness
	public String callRestfulness(String uri) {
		RestTemplate restTemp = new RestTemplate();
		String url = "http://localhost:8080/springhibernate/validate/" + uri;
		String result = restTemp.getForObject(url, String.class);

		return result;
	}
}
