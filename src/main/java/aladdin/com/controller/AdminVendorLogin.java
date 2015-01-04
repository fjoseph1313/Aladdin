package aladdin.com.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminVendorLogin {
	
	@RequestMapping(value = "/clogin", method = RequestMethod.GET)
	public String adminVenLogin(Model model) {
		
		

		return "cLogin";
	}
	
	@RequestMapping(value = "/clogout", method = RequestMethod.GET)
	public String adminVenLogout(Model model) {
		
		

		return "clogout";
	}


}
