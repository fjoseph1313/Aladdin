package aladdin.com.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aladdin.com.dao.ProductCategoryDAOImpl;
import aladdin.com.model.Admin;

@Controller
@RequestMapping(value = "/admin")
public class AdminLoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminLoginController.class);


	@Autowired
	private ProductCategoryDAOImpl productCategoryDAO;
	
	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public String adminLoginForm(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		

		return "adminLogin";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(Locale locale, Model model,@ModelAttribute("newJobApplication") Admin adminLogin,
			
			BindingResult result) {
		logger.info("I came here... {}.", locale);
		

		return "adminLogin";
	}
	
	
	
}
