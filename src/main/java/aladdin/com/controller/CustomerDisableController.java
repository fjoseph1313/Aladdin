package aladdin.com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.CustomerDAO;
import aladdin.com.dao.DAOFactory;
import aladdin.com.model.Customer;

@Controller
@RequestMapping("/customer")

public class CustomerDisableController {
	
	private DAOFactory factory = DAOFactory.getFactory();
	private CustomerDAO cDao = factory.getCustomerDAO();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAll(Model model) {
		cDao.beginTransaction();
		List<Customer> list= cDao.getCustomerForDisable(true);
		model.addAttribute("lists", list);
		cDao.commitTransaction();
		return "customerList";
		
	}
	@RequestMapping(value="/customer/edit/{id}", method = RequestMethod.GET)
	public String editCustomerById(@PathVariable Long id, Model model){
		cDao.beginTransaction();
		cDao.editCustomer(id);
		List<Customer> list= cDao.getCustomerForDisable(true);
		model.addAttribute("lists", list);
		cDao.commitTransaction();
		return "redirect:/customer/";
	}
}
