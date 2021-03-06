package aladdin.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import aladdin.com.HibernateUtil;
import aladdin.com.MailMail;
import aladdin.com.dao.CustomerDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.UserRolesDAO;
import aladdin.com.dao.VendorDAO;
import aladdin.com.model.Admin;
import aladdin.com.model.Customer;
import aladdin.com.model.UserRoles;
import aladdin.com.model.Vendor;

@Controller
public class RegistrationController {

	// @Resource
	private DAOFactory factory = DAOFactory.getFactory();
	private CustomerDAO customerDAO = factory.getCustomerDAO();
	private VendorDAO vendorDAO = factory.getVendorDAO();
	private UserRolesDAO userRolesDAO = factory.getUserRolesDAO();

	/*
	 * 
	 * Customer Part
	 */

	
	
	@RequestMapping(value = "/availability", method = RequestMethod.GET)
	@ResponseBody
	public String processAjaxRequest(HttpServletRequest request) {
		String email = request.getParameter("email");
		//System.out.println("E-mail: "+email);
		System.out.println("email: "+email);

		//Query query = HibernateUtil.getSession().createQuery("from person where emailAddress = :email");
		//query.setParameter("email", email);		
		
		//int count = query.list().size();	
		
		HibernateUtil.getSession().beginTransaction();
		Query query = HibernateUtil.getSession().createSQLQuery(
				"select s.emailAddress from person s where s.emailAddress = :email")
				.setParameter("email", email);
		int count = query.list().size();
		//HibernateUtil.getSession().
		System.out.println(count);
		if(count == 0)
			return "1";
		else
			return "0";
		
	}
		
	
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		model.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@RequestMapping(value = "/customer-register", method = RequestMethod.GET)
	public String getCustomerRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerRegistration";
	}

	@RequestMapping(value = "/customer-register/submit", method = RequestMethod.POST)
	public String createorUpdateCustomer(Model model,
			@ModelAttribute("customer") Customer customer, BindingResult result) {
		customer.setEnable(true);

		UserRoles userRoles = new UserRoles();
		userRoles.setPerson(customer);
		userRoles.setAuthority("ROLE_USER");
		
		String notEncodedPassword = customer.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		System.out.println("Encrypted Pass: "+passwordEncoder.encode(customer.getPassword()));

		customerDAO.beginTransaction();
		customerDAO.save(customer);
		customerDAO.commitTransaction();
		
		userRolesDAO.beginTransaction();
		userRolesDAO.save(userRoles);
		userRolesDAO.commitTransaction();

		String fullName = customer.getFirstName() + " " + customer.getLastName();
		model.addAttribute("fullName", fullName);
		
		String emailSubject = "Customer registration success to Aladdin";
		String emailBody = "Welcome " + fullName + ",\n\n"
				+ "You have successfully registered to Aladdin.\n\n"
				+ "Your email: " + customer.getEmailAddress() + "\n\n"
				+ "Your password: " + notEncodedPassword;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	MailMail mm = (MailMail) context.getBean("mailMail");
    	mm.sendMail("Aladdin <aladdin.mscs@gmail.com>", customer.getEmailAddress(), "aladdin.mscs@gmail.com", emailSubject, emailBody);

		return "registrationSuccess";
	}

	@RequestMapping(value = "/customer-activate", method = RequestMethod.GET)
	public String activateCustomer(Model model) {

		return "redirect:/login";
	}

	/*
	 * 
	 * Vendor Part
	 */

	@RequestMapping(value = "/vendor-register", method = RequestMethod.GET)
	public String getVendorRegistrationForm(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "vendorRegistration";
	}

	@RequestMapping(value = "/vendor-register/submit", method = RequestMethod.POST)
	public String createorUpdateVendor(Model model,
			@ModelAttribute("vendor") Vendor vendor, BindingResult result) {
		vendor.setEnable(false);

		String notEncodedPassword = vendor.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));
		System.out.println("Encrypted Pass: "+passwordEncoder.encode(vendor.getPassword()));
		
		UserRoles userRoles = new UserRoles();
		userRoles.setPerson(vendor);
		userRoles.setAuthority("ROLE_VENDOR");
		
		vendorDAO.beginTransaction();
		vendorDAO.save(vendor);
		vendorDAO.commitTransaction();

		userRolesDAO.beginTransaction();
		userRolesDAO.save(userRoles);
		userRolesDAO.commitTransaction();
		
		String fullName = vendor.getFirstName() + " " + vendor.getLastName();
		model.addAttribute("fullName", fullName);
		
		String emailSubject = "Vendor registration success to Aladdin";
		String emailBody = "Welcome " + fullName + ",\n\n"
				+ "You have successfully registered to Aladdin.\n\n"
				+ "Your email: " + vendor.getEmailAddress() + "\n\n"
				+ "Your password: " + notEncodedPassword;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	MailMail mm = (MailMail) context.getBean("mailMail");
    	mm.sendMail("Aladdin <aladdin.mscs@gmail.com>", vendor.getEmailAddress(), "aladdin.mscs@gmail.com", emailSubject, emailBody);

		return "registrationSuccess";
	}

	@RequestMapping(value = "/vendor-activate", method = RequestMethod.GET)
	public String activateVendor(Model model) {

		return "redirect:/login";
	}

	@RequestMapping(value = "/customer/successful", method = RequestMethod.GET)
	public String redirectToProperPage(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		
		
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		customerDAO.beginTransaction();
		Customer customer = customerDAO.findCustomerByEmail(auth.getName());
		HttpSession session = request.getSession(true); // create a new session		
		session.setAttribute("userDetails", customer);
		session.setAttribute("userType", customer.getClass().getSimpleName());
		customerDAO.commitTransaction();
		
		String referer = request.getHeader("Referer");
		System.out.println("referer: "+referer);
		if(referer.equalsIgnoreCase("http://localhost:8080/Aladdin/clogin")){
			return "redirect:/";
		}

		return "redirect:"+referer;
	}
}
