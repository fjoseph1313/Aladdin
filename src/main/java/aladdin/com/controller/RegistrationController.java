package aladdin.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.CustomerDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.dao.VendorDAO;
import aladdin.com.model.Customer;
import aladdin.com.model.Vendor;

@Controller
public class RegistrationController {

	// @Resource
	private DAOFactory factory = DAOFactory.getFactory();
	private CustomerDAO customerDAO = factory.getCustomerDAO();
	private VendorDAO vendorDAO = factory.getVendorDAO();

	/*
	 * 
	 * Customer Part
	 */

	@RequestMapping(value = "/customer-register", method = RequestMethod.GET)
	public String getCustomerRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerRegistration";
	}

	@RequestMapping(value = "/customer-register/submit", method = RequestMethod.POST)
	public String createorUpdateCustomer(Model model,
			@ModelAttribute("customer") Customer customer, BindingResult result) {
		customer.setIsActive(true);
		customerDAO.beginTransaction();
		customerDAO.save(customer);
		customerDAO.commitTransaction();

		String fullName = customer.getFirstName() + " " + customer.getLastName();
		model.addAttribute("fullName", fullName);

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
		vendor.setIsActive(false);
		vendorDAO.beginTransaction();
		vendorDAO.save(vendor);
		vendorDAO.commitTransaction();

		String fullName = vendor.getFirstName() + " " + vendor.getLastName();
		model.addAttribute("fullName", fullName);

		return "registrationSuccess";
	}

	@RequestMapping(value = "/vendor-activate", method = RequestMethod.GET)
	public String activateVendor(Model model) {

		return "redirect:/login";
	}

}
